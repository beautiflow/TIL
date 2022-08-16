* 제네릭(Generic)의 이해

```java
public class ClassName<T>{...}
public Interface InterfaceName <T> {...}
```
기본적으로 제네릭 타입의 클래스나 인터페이스의 경우 이렇게 선언한다.
T타입은 해당블럭 {...} 안에서까지 유효

제네릭 타입을 두 개로 둘 수도 있다.
```java
public class ClassName <T,K> {...}
public Interface InterfaceName <T,K> {...}

// HashMap의 경우 아래와 같이 선언되어있을 것이다.
public class HashMap <K,V> {...}
```

이렇게 데이터 타입을 외부로부터 지정할 수 있도록 할 수 있다.

* 제네릭 클래스 사용  /  즉, 객체를 생성해야 하는데 이 때 구체적인 타입을 명시를 해주어야 한다.
```java
public class ClassName <T,K> {...}

public class Main{
    public static void main(String[] args){
        ClassName<String, Integer> a = new ClassName<String, Integer>();
    }
}
```
T는 String이 되고, K는 Integer가 된다.

여기서 주의해야 할 점은 타입 파라미터로 명시할 수 있는 것은 참조타입(Reference Type)밖에 올 수 없다. 즉, int, double, char 같은 primitive type은 올 수 없다는 것. 그래서 int형 double형 등 primitive Type의 경우 Integer, Double 같은 Wrapper Type으로 쓰는 이유가 바로 위와 같은 이유다.


또 참조 타입이 올 수 있다는 것은 사용자가 정의한 클래스도 타입으로 올 수 있다는 것이다.
```java
public class ClassName<T> {...}

public class Student {...}

public class Main{
    public static void main(String[] args){
        ClassName<Student> a = new ClassName<Student>();
    }
}
```



* 프로세스
  : 실행중인 프로그램을 의미
  : 완전히 독립적인 수행단위

* 스레드
  : 프로그램 내에서 실행되는 프로그램 제어 흐름(실행단위)을 말한다.
  : 한 프로그램에 여러 개의 스레드가 존재할 수 있다. 스레드가 1개라면 단일스레드, 2개이상이라면 다중스레드
  : 프로그램 코드를 한 줄씩 실행하는 것이 스레드의 역할이다.( = 실행제어 )
  : 스레드란 곧 프로그램을 실행하는 주체이다
  : 스레드를 보통 가벼운 프로세스(light-process)라고 표현한다.

* 멀티스레드
  : 멀티스레드 = multi thread = 다중스레드
  : 멀티스레드는 여러 개의 스레드를 이용하는 프로그램
  : 다중 스레드에서 각각의 스레드는 하나의 독립적인 프로세스처럼 작업 수행

  * 멀티스레드로 구현된 프로그램을 실행하면
    - 하나의 프로세서는 한번에 스레드 1개밖에 실행시키지 못한다.
    - 대신 일정한 시간 간격으로 수행해야하는 스레드를 전환한다
    - 스레드를 전활 할 때는 운영체제의 스케줄러의 기준에 따라 순서가 정해지게 된다
    - 여러 스레드를 번갈아 처리하기 때문에 엄밀히 한번에 한가지를 처리하지만 동시에 작업하는 듯한 효과를 준다.
    - 이와 같은 방식을 시분할 방식이라고 한다.

  * 멀티 스레드 방식을 사용하는 이유(장점)
    - 프로세스는 독립적이다. 이 때문에 작업공간이 독립적이고, 프로세스끼리 자원 및 데이터를 공유하기 어렵다. 혹시 프로세스간 데이터 전송이 필요한 경우 시간, 자원 소요가 많다.
    - 프로그램 내의 스레드는 서로 독립적이지 않다. 작업공간을 같이 사용하기 때문에 자원 및 데이터를 공유할 수 있다. 즉, 스레드간 데이터 전송이 필요한 경우 시간, 자원 소요가 적다.
    - 정리하면, 스레드는 프로세스처럼 작업을 동시에 처리할 수 있는 공통적인 특징이 있으면서, 프로세스보다 오버헤드가 적다는 것이 장점


* 멀티 프로세싱 VS. 멀티 태스킹 VS. 멀티스레드
  
  멀티프로세싱(multi processing) : 시스템 관점 : CPU 여러개에서 동시에 여러 개의 프로세스 수행 : 다수의 송금거래를 동시에 처리하는 은행전산 시스템
  
  멀티태스킹(multi tasking)      : 프로그램 외부에서의 관점 : CPU 1개에서 동시에 여러 프로그램을 실행 : pc카톡 켜놓고 youtube음악 들으면서 온라인 뱅킹 업무

  멀티스레딩(multi threading)    : 프로그램 내부에서의 관점 : processor 1개가 동시에 여러 스레드를 실행 : 프로그램 안에서 실행되는 코드흐름이 여러개


* 멀티스레드를 적용하기 위한 조건
   - 병행성(concurrency) : 다수의 스레드 생성방법 존재
   - 동기화(synchronization) : 작업이 방해받지 않고 각 스레드의 동기화 방법이 존재   
   - 통신(communication) : 서로 다른 스레드가 정보를 교환할 수 있는 방법이 존재


* 스레드 생성방법
  1. Thread 클래스 상속받아서 생성

```java
class MyThread extends Thread{
    public void run(){ // Thread클래스의 run() 메서드 오버라이딩
        /* 작업내용 */
    }
}
```
    - 특징 : 실행 스레드로 자신의 콜 스택을 갖춘 독립적인 프로세스
            start() 메서드를 통해 스레드가 시작된다.


  2. Runnalbe 인터페이스 구현하여 생성
```java
class MyThread2 implements Runnable{
    public void run(){ // Runnable 인터페이스의 추상메서드 run()메서드를 구현하여 생성한다. 참고로 Runnable 인터페이스는 run()메서드 1개만 가지는 함수형 인터페이스이다.
        /* 작업내용 */
    }
}   
```
    - 특징 : Runnable 인터페이스를 구현한다고 해서 바로 스레드가 되지 않는다
            Thread class를 통해 스레드가 될 수 있다.
            (방법 : 객체 참조변수를 인자값으로 하는 Thread 생성)


=> 방법이 2가지인 이유는 자바가 단일 상속만 허용하기 때문이다. 만약 상속 받아야하는 클래스가 있다면 Thread 클래스를 상속받는 방법 대신 Runnable 인터페이스를 구현하는 방법을 사용할 수 있다.

* 멀티 스레딩 장점
  : 메모리 공유로 인한 시스템 자원 소모가 줄어든다
  : 동시에 두 가지 이상의 활동을 하는 것이 가능해진다

* 멀티 스레딩 단점
  : 서로 자원을 소모하다가 충돌이 일어날 가능성이 존재한다
  : 코딩이 난해해져 버그생성확률이 높아진다

* Thread의 생성주기
   - Runnable 상태 : 쓰레드가 실행되기 위한 준비 단계
   - Running 상태 : 스케줄러에 의해 선택된 쓰레드가 실행되는 단계
   - Blocked 상태 : 쓰레드가 작업을 완수하지 못하고 잠시 작업을 멈추는 단계

* 스레드의 생명주기
  
  1. Runnable (준비상태)
   
      스레드가 실행되기 위한 준비단계. CPU를 점유하고 있지 않으며 실행(Running 상태)을 하기 위해 대기하고 있는 상태. 코딩 상에서 start() 메소드를 호출하면 run() 메소드에 설정된 스레드가 Runnable 상태로 진입한다. "Ready"상태라고도 한다.
  
  2. Running (실행상태)
      
      CPU를 점유하여 실행하고 있는 상태. run() 메서드는 JVM만이 호출 가능하다. Runnable(준비상태)에 있는 여러 스레드 중 우선 순위를 가진 스레드가 결정되면 JVM이 자동으로 run() 메소드를 호출하여 스레드가 Running 상태로 진입한다.
  
  3. Dead (종료상태)
   
      Running 상태에서 스레드가 모두 실행되고 난 후 완료 상태. "Done"상태라고도 한다.

  4. Blocked (지연 상태)

      CPU를 점유권을 상실한 상태. 후에 특정 메서드를 실행시켜 Runnable(준비상태)로 전환한다. wait() 메소드에 의해 Blocked 상태가 된 스레드는 notify() 메소드가 호출되면 Runnable 상태로 간다. sleep(시간)메소드에 의해 Blocked 상태가 된 스레드는 지정된 시간이 지나면 Runnable 상태로 간다.








* synchroized를 이용한 동기화 예제

```java

class Ex13_13{
    public static void main(String[] args){
        Runnable r = new RunnalbleEx13();
        new Thread(r).start();
        new Thread(r).start();
    }
}

class Account2{
    private int balance = 1000; // private으로 해야 동기화가 의미가 있다.

    public int getBalance(){
        return balance;
    }

    public synchronized void withdraw(int money){  // synchronized로 메서드를 동기화
        if(balance >= money){
            try{ Thread.sleep(1000);} catch(IterruptedException e){}
            balance -= money;
        }
    } // withdraw
}

class RunnableEx13 implements Runnable {
    Account2 acc = new Account2();

    public void run(){
        while(acc.getBalance() > 0){
            // 100, 200, 300 중의 한 값을 임의로 선택해서 출금(withdraw)
            int money = (int)(Math.random() * 3 + 1) * 100;
            acc.withdraw(money);
            System.out.println("balance:"+acc.getBalance());
        }
    }  //  run()
}

[결과]
balance : 800
balance : 500
balance : 200
balance : 200
balance : 100
balance : 100
balance : 100
balance : 100
balance : 0
balance : 0
