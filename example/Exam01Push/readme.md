## 안드로이드 FCM 예제

google-services.json 파일은 파이어배이스 콘솔에서 따로 생성하여 추가하여야함.  

https://console.firebase.google.com

## fcm 서비스 특징

알림이 도착하면 실행되고 처리가 끝나면 바로 사라진다. 그래서 메인액티비티에서 이서비스는 따로 처리 할수없다.  

## 사용자정의 알림(음악) 구현

알림이 도착하면 정해진 mp3가 연주되는 것을 구형하기 위해서 전용 서비스를 하나더 만들어야한다.  
이 예제에서는 이름을 MyPlayerService라고 하였다.  
알림이 도착하면 Fcm서비스에서 브로드 캐스팅으로 start 메시지를 발송한다.

다음은 MyFCMService의 OnMessageReceived 함수 구현예제 이다.  
  
```java
@Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
//        super.onMessageReceived(remoteMessage);

        Log.d(TAG, "From: " + remoteMessage.getFrom());
        // Check if message contains a data payload.
        if (remoteMessage.getData().size() > 0) {
            Log.d(TAG, "Message data payload: " + remoteMessage.getData());

            //각각 키값으로 데이터 얻기
            Log.d(TAG," msg : " + remoteMessage.getData().get("msg"));
            Log.d(TAG," num1 : " + remoteMessage.getData().get("num1"));

            //벳지에 알림 내용 출력
            sendNotification(remoteMessage.getData().get("msg"));

            //Player서비스가 음악연주하도록 브로드 캐스팅
            Intent intent = new Intent("custom-event-name");
            intent.putExtra("message", "start");
            LocalBroadcastManager.getInstance(this).sendBroadcast(intent);


            if (/* Check if data needs to be processed by long running job */ true) {
                // For long-running tasks (10 seconds or more) use Firebase Job Dispatcher.
                //scheduleJob();
            } else {
                // Handle message within 10 seconds
                //handleNow();
            }
        }
        // Check if message contains a notification payload.
        if (remoteMessage.getNotification() != null) {
            Log.d(TAG, "Message Notification Body: " + remoteMessage.getNotification().getBody());
        }

    }
```

이것을 MyPlayerService에서 받아서 처리한다. 리시버를 다음과 같이 만들어 서비스에 등록한다.

```java

private BroadcastReceiver mMessageReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            // TODO Auto-generated method stub
            // Get extra data included in the Intent
            String message = intent.getStringExtra("message");
            Log.d(TAG, "service side Got message: " + message);

            try {
                if(message == "start") {
                    m_PlayerNinja.start();
                }
                else if(message == "stop"){
                    m_PlayerNinja.stop();
                    m_PlayerNinja.prepare();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    };

```

음악을 멈추고 싶으면 stop을 발송한다.

```java
Intent intent = new Intent("custom-event-name");
intent.putExtra("message", "stop");
LocalBroadcastManager.getInstance(MainActivity.this).sendBroadcast(intent);
```


   
