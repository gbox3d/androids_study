/** fcm-node 모듈 설치 필요 */
// --> npm install fcm-mode --save
var FCM = require('fcm-node');
var mykeys = require('./keys');

/** 아래는 푸시메시지 발송절차 */
var fcm = new FCM(mykeys.serverKey);

/** 발송할 Push 메시지 내용 */
var push_data = {
    // 수신대상
    to: mykeys.client_token,
    // App이 실행중이지 않을 때 상태바 알림으로 등록할 내용
    notification: {
        title: "Hello Node",
        body: "Node로 발송하는 Push 메시지 입니다.",
        sound: "default"
        // click_action: "FCM_PLUGIN_ACTIVITY",
        // icon: "fcm_push_icon"
    },
    // 메시지 중요도
    priority: "high",
    // App 패키지 이름
    restricted_package_name: mykeys.client_package,
    // App에게 전달할 데이터
    data: {
        num1: 2000,
        num2: 3000
    }
};




fcm.send(push_data, function(err, response) {
    if (err) {
        console.error('Push메시지 발송에 실패했습니다.');
        console.error(err);
        return;
    }

    console.log('Push메시지가 발송되었습니다.');
    console.log(response);
});