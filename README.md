#### MVC 와 MVP

1. MVC
- Model – View – Controller
- 모든 입력은 Controller에서 처리 됨
- 입력이 Controller로 들어오면 Controller는 입력에 해당하는 Model을 조작(업데이트)하고, Model을 나타내어줄 View를 선택 때문에, View는 Model는 서로간의 의존성을 완벽히 피할 수는 없음


2. MVP
- Model – View – Presenter
- 입력이 View에서 처리 됨
- View에서 이벤트가 발생하면 Presenter에게 전달해주고 Presenter는 해당 이벤트에 따른 Model을 조작하고 그 결과를 View에게 통보를 하여 View를 업데이트
- Model과 View가 분리되어있음


**공통점**
- Model은 일종의 데이터, 데이터 이외에 간단한 로직도 추가
- View는 디스플레이로 사용자에게 보여지는 페이지


![enter image description here](https://cdn-images-1.medium.com/max/800/0*CNMHroWFQUOEC-PI.png)


![enter image description here](http://www.techyourchance.com/wp-content/uploads/2015/06/MVC_MVP.png)

#### Stream
- 자료의 입출력을 도와주는 중간매개체


_입력 문자 스트림_
![enter image description here](http://cfile10.uf.tistory.com/image/2653B34755BB063F09D6B0)

_출력 문자 스트림_
![enter image description here](http://cfile3.uf.tistory.com/image/2310264C55BB06861369EF)
