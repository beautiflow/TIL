< Springboot with JPA>

# 1강 스프링 개념잡기

## 1. 스프링이란?
- 스프링은 프레임워크이다.
- 스프링은 오픈소스이다.
- 스프링은 IoC 컨테이너를 가진다.
- 스프링은 DI를 지원한다.
- 스프링은 엄청나게 많은 필터를 가지고 있따.
- 스프링은 엄청나게 많은 어노테이션을 가지고 있다. (리플렉션, 컴파일체킹)
- 스프링은 MessageConverter를 가지고 있다. 기본값은 현재 Json이다.
- 스프링은 BufferedReader와 BufferedWriter를 쉽게 사용할 수 있다.
- 스프링은 계속 발전중이다. 

# 2강 JPA 개념잡기

## 1. JPA란?
- JPA는 Java Persistence API(application programming interface)이다.
- JPA는 ORM(object relational mapping) 기술이다.
- JPA는 반복적인 CRUD(create, read, update, delete) 작업을 생략하게 해준다.
- JPA는 영속성 컨텍스트를 가지고 있다.
- JPA는 DB와 OOP의 불일치성을 해결하기 위한 방법론을 제공한다. (DB는 객체저장 불가능)
- JPA는 OOP의 관점에서 모델링을 할 수 있게 해준다.(상속, 컴포지션, 연관관계)
- 방언 처리가 용이하여 Migration하기 좋음. 유지보수에도 좋음
- JPA는 쉽지만 어렵다.

# 3강 Springboot 동작원리

## 1. 스프링부트 동작원리

### (1) 내장 톰켓을 가진다.
       : 톰캣을 따로 설치할 필요 없이 바로 실행가능하다.
       













































































public class Congratulation{
    public static void Cake(){
        System.out.println("자바의 여신");
        System.out.println("생일 축하해");
    }
}