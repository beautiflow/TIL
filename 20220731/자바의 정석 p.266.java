자바의 정석 p.266

/* 인터페이스를 이용한 다형성 */

- 인터페이스도 구현 클래스의 부모? YES
- 인터페이스 타입 매개변수는 인터페이스 구현한 클래스의 객체만 가능 
- 인터페이스를 메서드의 리턴타입으로 지정할 수 있다.
   

[실습]

abstract class Unit2{
    int x,y ;
    abstract void move(int x, int y);
    void stop(){ System.out.println("멈춥니다.");}
}

interface Fightable { // 인터페이스의 모든 메서드는 public abstract. 예외없이
    void move(int x, int y); // public abstract 가 생략됨
    void attack(Fightable f); // public abstract 가 생략됨
}

class Fighter extends Unit2 implements Fightable{
    // 오버라이딩 규칙 : 조상(public)보다 접근제어자가 범위가 좁으면 안된다.
    public void move(int x, int y){
        System.out.println("["+x+","+y+"] 로 이동");
    }
    public void attack(Fightable f){
        System.out.println(f+"를 공격");
    }
    
    //싸울 수 있는 상대를 불러온다.
    Fightable getFightable(){
        Fighter f = new Figheter();  // Fighter를 생성해서 반환
        return f;
    }
}

public class FighterTest{

    public static void main(String[] args){
// /     Fighter f = new Fighter();
//         Unit2 u = new Fighter();
//         Fightable f = new Fighter();
//         u.move(100,200);
// //      u.attack(new Fighter()); // Unit2 에는 attack()이 없어서 호출 불가
//         u.stop();
        
//         f.move(100,200);
//         f.attack(new Fighter());
// //      f.stop();  // Fightable에는 stop()이 없어서 호출불가

          Fighter f = new Fighter();
          Fightable f2 = f.getFightable();
    }
}

cf)
Fightable method(){
    ...
    Figheter f = new Fighter();  //-> 여기 두 분장은 한 문장으로 바꾸면 다음과 같다.
    return f;                    // = return new Fighter();
}

중요!! 
<리턴타입이 인터페이스라는 것은 메서드가 해당 인터페이스를 구현한 클래스의 인스턴스를 반환한다는 것을 의미한다>


------------------------------------------------------------------------------------


/* 인터페이스의 장점 */
- 두 대상(객체)간의 '연결, 대화, 소통'을 돕는 '중간 역할'을 한다.
- 선언(설계)와 구현을 분리시킬 수 있게 한다.


[실습]

class A{
//    public void method(B b){ // 인터페이스 I를 구현한 넘들만 들어와라
      public void method(I i){ // 인터페이스 I를 구현한 넘들만 들어와라
        i.method();
      }
}

// B클래스의 선언과 구현을 분리
interface I {
    public void method();
}

class b implements I {
    public void mehtod(){
        System.out.println("B클래스의 메서드");

    }
}

class C implements I {
    public void method(){
        System.out.println("C클래스의 메서드");
    }
}

public class InterfaceTest{
    public static void main(String[] agrs){
        A a = new A();
        a.method(new C()); // A가 B를 사용(의존)
    }
}


------------------------------------------------------------------------------------

/* 인터페이스의 장점 2 */


- 개발시간을 단축시킬 수 있다.
  : 일단 인터페이스가 작성되면, 이를 사용해서 프로그램을 작성하는 것이 가능하다. 메서드를 호출하는         쪽에서는 메서드의 내용에 관계없이 선언부만 알면 되기 때문이다.
   그리고 동시에 다른 한 쪽에서는 인터페이스를 구현하는 클래스를 작성하게 되면, 인터페이스를 구현하는 클래스가 작성될 때 까지 기다리지 않고도 양쪽에서 개발을 진행할 수 있다.

- 변경에 유리한 유연한 설계가 가능하다.


- 표준화가 가능하다.
: 프로젝트에 사용되는 기본 틀을 인터페이스로 작성한 다음, 개발자들에게 인터페이스를 구현하여 프로그램을 작성하도록 함으로써 보다 일관되고 정형화된 프록램의 개발이 가능하다.

- 서로 관계없는 클래스들에게 관계를 맺어 줄 수 있다.
: 서로 상속관계에 있지도 않고, 같은 조상클래스르 가지고 있지 않은 서로 아무런 관계도 없는 클래스들에게 하나의 인터페이스를 공통적으로 구현하도록 함으로써 관계를 맺어 줄 수 있다.

- 독립적인 프로그래밍이 가능하다.
: 인터페이스를 이용하면 클래스의 선언과 구현을 분리시킬 수 있기 때문에 실제 구현에 독립적인 프로그램을 작성하는 것이 가능하다. 클래스와 클래스간의 직접적인 관계를 인터페이스를 이용해서 간접적인 관계로 변경하면, 한 클래스의 변경이 관련된 다른 클래스에 영향을 미치지 않는 독립적인 프로그래밍이 가능하다.


------------------------------------------------------------------------------------

/* 디폴트 메서드와 static 메서드 */
- 인터페이스에 디폴트 메서드, static 메서드 추가 가능.(JDK 1.8부터)
- 인터페이스에 새로운 메서드(추상 메서드)를 추가하기 어려움.
      
       해결책 => 디폴트 메서드(default method)

- 디폴트 메서드는 인스턴스 메서드(인터페이스 원칙 위반 - 예외)

interface MyInterface{
    void method();
    void newMethod(); // 추상 메서드
}

           |
           V
interface MyInterface{
    void mehtod();
    default void newMethod(){}
}

위쪽과 같이 newMethod()라는 추상메서드를 추가하는 대신 밑과 같이 디폴트 메서드를 추가하면, 기존의 
MyInterface를 구현한 클래스를 변경하지 않아도 된다. 즉, 조상클래스에 새로운 메서드를 추가한 것과
동일해지는 것이다.

- 디폴트 메서드가 기존의 메서드와 충돌할 때의 해결책
1. 여러 인터페이스의 디폴트 메서드 간의 충돌
 - 인터페이스를 구현한 클래스에서 디폴트 메서드를 오버라이딩해야 한다.
2. 디폴트 메서드와 조상 클래스의 메서드 간의 충돌
- 조상클래스의 메서드가 상속되고, 디폴트 메서드는 무시된다.



------------------------------------------------------------------------------------
/* 내부클래스 */

장점
1. 내부클래스에서 외부클래스의 멤버들을 쉽게 접근할 수 있다.
2. 코드의 복잡성을 줄일 수 있다.(캡슐화)


------------------------------------------------------------------------------------


/* 내부클래스의 제어자와 접근성 */

[예제 1]

class Ex7_12{
    class InstanceInner{
        int iv = 100;
   //   static int cv = 100;    // 에러! static 변수를 선언할 수 없다.
    final static int CONST = 100;  // final static은 상수이므로 허용
    }

    static class StaticInner{
        int iv = 200;
        static int cv = 200;   // static 클래스만 static 멤버를 정의할 수 있다.
                               // static 내부클래스에서는 외부 클래스의 인스턴스 멤버에 접근할   수  없다.
    }
   
    void myMethod(){
        class LocalInner{
            int iv = 300;
            static int cv = 300;       // 에러! static 변수를 선언할 수 없다.
            final static int CONST = 300;  //final static은 상수이므로 허용
        }
    }

    public static void main(String args[]){
        System.out.println(InstanceInner.CONST);
        System.out.println(StaticInner.cv);
 //     System.out.println(LocalInner.CONST); // 에러. 지역내부클래스는 메서드 내에서만
  }
}

//  = 결과 :100
//         200


[예제 2]

class Ex7_13{

 class InstanceInner{}
 static class StaticInner{}

 InstanceInner IV = new InstanceInner();  // 인스턴스 멤버끼리는 직접 접근 가능
 static StaticInner cv = new StaticInner();  // static 멤버끼리는 직접 접근 가능

 static void staticMethod(){  // static멤버는 인스턴스 멤버에 직접 접근 불가
 // InstanceInner obj1 = new InstanceInner();
    StaticInner obj2 = new StaticInner();

    Ex7_13 outer = new Ex7_13(); // 인스턴스 클래스는 외부 클래스를 먼저 생성해야 생성가능
    InstanceInner obj1 = outer.new InstanceInner();
 }

 void instanceMethod(){  // 인스턴스 메서드에서는 인스턴스 멤버와 static 멤버 모두 접근 가능
    InstanceInner obj1 = new InstanceInner();
    StaticInner obj2 = new StaticInner();
//  LocalInner lv = new LocalInner();  // 지역 내부 클래스는 외부에서 접근할 수 없다. 
 }
 
 void myMethod(){
    class LocalInner{}
    LocalInner lv = new LocalInner();
 }
}


+ 인스턴스 멤버가 static 멤버 쓰는 것은 가능
+ static 멤버가 인스턴스 멤버 쓰는 것은 불가능 


 