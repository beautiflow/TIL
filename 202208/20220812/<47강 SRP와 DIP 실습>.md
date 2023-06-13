<47강 SRP와 DIP 실습>

```java

interface CanAble{
    public abstract void talk();
}

abstract class 홀직원 implements CanAble{
   abstract void 청소();

    @Override
    public void talk(){
        System.out.println("손님과 대화");
    }
}

abstract class 종업원 extends 홀직원{
    void 서빙하기(){
        System.out.println("서빙하기");
    }
    // void 주문받기(){
    //     System.out.println("주문받기");
    // }
}

abstract class 캐셔 extends 홀직원{
    void 정산하기(){
        System.out.println("계산기 정산하기");
    }
    void 계산하기(){
        System.out.println("카드 계산하기");
    }
}

abstract class 요리사{
    abstract void 요리();
}

class 홍길동 extends 종업원{

    요리사 j;  // 의존성 역전 원칙 : 추상적인 것에 의존한다는 것

    @Override
    void 청소(){
        System.out.println("화장실 청소");
    }
}

class 임꺽정 extends 종업원{

    요리사 j;  // 의존성 역전 원칙

    @Override
    void 청소(){
        System.out.println("주방 청소");
    }
}

class 김유신 extends 캐셔{
    @Override
    void 청소(){
        System.out.println("홀 청소");
    }
}

class 이몽룡 extends 캐셔{
    @Override
    void 청소(){
        System.out.println("테이블 청소");
    }
}

// class 장보고 extends 요리사{
//     @Override
//     void 요리(){
//         System.out.println("양식 만들기");
//     }
// }

class 정몽주 extends 요리사{
    @Override
    void 요리(){
        System.out.println("양식 만들기");
    }
}

class 이순신 extends 요리사{
    @Override
    void 요리(){
        System.out.println("한식 만들기");
    }
}

public class OOPEx10{

    public static void main(String[] args){


    }
}

```

[챕터 5 연습문제]

길동이 집에는 티비가 두 대가 있다. 그런데 정말 불편한 점이 있다.
삼성 티비는 초록버튼을 클릭하면 전원이 켜지고 파랑버튼을 클릭하면 전원이 꺼졌다.
엘지 티비는 초록버튼을 클릭하면 전원이 켜지고 빨간버튼을 클릭하면 전원이 꺼졌다.

두 회사의 차이 때문에 안방에 있는 삼성 티비에서는 티비를 끌 때 파랑버튼을 클릭했고 거실에 있는 엘지 티비에서는 빨간버튼을 클릭해서 티비를 껐다. 너무 너무 혼란스러웠다.

길동이는 이 문제를 해결하고자 삼성과 엘지에 동시에 적용되는 리모콘을 직접 개발하기로 했다.

초록버튼은 전원켜짐
빨간버튼은 전원꺼짐

이렇게 통일하기로 마음 먹었고 행위에 대한 제약을 주기위해 인터페이스를 만들었다. 인터페이스 이름은 RemoconAble이라고 지었다.


```java

interface RemoconAble{
    public void 초록버튼();
    public void 빨간버튼();
}

class Samsung implements RemoconAble{

   @Override
   public void 초록버튼(){
        System.out.println("전원이 켜졌습니다.");
   }

    @Override
   public void 빨간버튼(){
        System.out.println("전원이 꺼졌습니다.");
   }
   

}

class LG implements RemoconAble{

    @Override
   public void 초록버튼(){
        System.out.println("전원이 켜졌습니다.");
   }

    @Override
   public void 빨간버튼(){
        System.out.println("전원이 꺼졌습니다.");
   }
}

public class ExampleEx01{

    public static void main(String[] args){
         //삼성 리모콘 2개 만들기 (new)
          Samsung s1 = new Samsung();
          Samsung s2 = new Samsung();
         // 엘지 리모콘 2개 만들기
          LG g1 = new LG();
          LG g2 = new LG();
    }
}

```

