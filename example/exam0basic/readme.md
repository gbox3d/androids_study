## exam0

just say hello 

### 버튼 이밴트 처리하기

메인 액티비티에 Button.OnClickListener 를 implements 시킨다음 onClick 메써드 오버라이드 받는다.

```java

((Button) findViewById(R.id.button_test2)).setOnClickListener(this);

```



### 음악연주

MediaPlayer 를 이용한다.  
res/raw 폴더를 만들고 그안에 음악 파일을 넣는다.  
리소스는 R.raw.파일명 형식으로 접근한다.    

```java

m_PlayerNinja =  MediaPlayer.create(this,R.raw.ninja);

```


참고 자료  
https://developer.android.com/reference/android/media/MediaPlayer  


