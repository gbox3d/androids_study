# TF Lite Object Detection Android Studio 예제

* [전체 개요 참고](app/readme.md)

## installation
```
git clone http://github.com/gbox3d/androids_study
```
> 안드로이드 스튜디오에서 TF_lite_sample 프로젝트 열기

## 개요
사용할 파일(모델파일, 라벨파일)은 아래경로에 ./app/src/main/asset 폴더 안에 저장

* **메인 기능**(카메라, 객체감지)은 app/java/org.tensorflow.lite.examples.detection 패키지 내에 CameraActivity, DetectorActivity 두 파일에 작성되어있음.

* **화면 레이아웃**은 res/layout 폴더의 xml파일 

* **텐서 플로우 관련 라이브러리**는 lib_interpreter, lib_task_api 에 있음. 현재는 task_api 이용중 만약 변경하길 원한다면 Build -> Select Build Variant.. 클릭해서  Active Build Variant 테이블 클릭시 drop_down 메뉴로 선택할 수 있음.

* **Bitmap 읽고 처리**하는 부분은 lib_task_api에 TFLiteObjectDetectionAPIModel.java 파일 Line 167 recognizeImage(Bitmap bitmap) 부분에 구현되어 있다.

* 기본 예제용 모델파일은 빌드시 gradle script를 통하여 다운로드 된다.

## 모델 호환성
* [모델 호환성 요구사항](https://www.tensorflow.org/lite/inference_with_metadata/task_library/object_detector)
