<JDBC , DAO, DTO>

# JDBC

* JDBC란



  : JDBC(Java DataBase Connectivity)는 데이터베이스에 연결 및 작업을 하기 위한 자바 표준 인터페이스이다.
    자바는 DBMS(Oracle, MySQL, MongoDB 등)의 종류에 상관 없이 하나의 JDBC API를 이용해서 데이터베이스 작업을 처리한다.
    이 JDBC는 DB에 접근해서 CRUD를 쉽고 효율적이게 할 수 있게 하고, 고성능에서의 세련된 메소드를 제공하며 쉽게 프로그래밍을 할 수 있게 도와준다.



  : JDBC는 자바 언어로 데이터베이스 프로그래밍을 하기 위한 라이브러리
    JDBC는 DBMS에 종속되지 않는 관련 API를 제공한다. JDBC API는 JDK에서 제공하며 JDBC 프로그래밍을 위해서는 JDBC 드라이버가 필요하다. JDBC 드라이버는 각 DBMS 회사에서 제공하는 라이브러리 압축파일이다. 



* JDBC의 역할
  
   * JDBC가 생긴 이유
     - JDBC API가 없던 때에는 데이터베이스의 종류마다(ms-sql, my-sql, oracle ..) 각각의 SQL문을 사용
     - 그 결과 DB의 종류에 따라 SQL문의 작성 방법이 너무나 차이가 나서 구현이 불편함
     - 그래서 메서드나 전역변수 등을 통합하는 문법으로 통일시킴. 이것이 JDBC

   * 역할
     - JAVA 코드에서 DB 서버에 접속
     - SQL문을 구성하고 DB서버에서 실행
     - DB서버에서 처리한 결과를 가져오기
     - DB의 정보를 가져오기
    => JDBC는 위와 같은 역할을 수행한다. 이런 기능들을 수행하기 위해 자바에서 다양한 인터페이스를 제공한다. 

    * JDBC 관련 인터페이스
  
     - JDBC Driver manager
        : DBC 드라이버 매니저에서는 JDBC 아키텍처 중핵을 이룬 모듈에서 자바 프로그램과 JDBC 드라이버와의 접속을 공급하는 역할을 한다.
    
    - JDBC Driver API
       : JDBC Driver API는 JDBC 드라이버 매니저와 각 DBMS의 벤더에서 제공하는 JDBC Driver가 서로 접속하기 위한 인터페이스이다.

    - JDBC Driver
       : JDBC Driver와 DBMS 접속을 제어하는 모듈. 통상적으로 JDBC 드라이버는 각각의 DBMS 벤더에서 제공하는 DBMS에 어떤 형태로 접속하는지에 의해 크게 네 종류로 나눌 수 있으며, JDBC에서는 자바 프로그램에서 사용하는 JDBC 드라이버 매니저와 DBMS에 의존하는 JDBC 드라이버를 분리하는 것에서 DBMS 벤더에 의존하지 않는 환경을 제공한다.


* JDBC API 클래스
  : JDBC는 다양한 클래스와 인터페이스로 구성된 패키지 java.sql와 javax.sql로 구성되어 있다.

    - 데이터베이스를 연결하여 테이블 형태의 자료를 참조
    - SQL문을 질의
    - SQL문의 결과를 처리


* JDBC를 이용한 데이터베이스 연동과정

1. 드라이버 로드 : Class.forName()메서드를 호출하여, mysql에서 제공하는 Driver클래스를 JVM method area에 로딩시킨다.
   
  ```java
         Class.forName("com.mysql.Jdbc.Driver");
 ```

2. 데이터베이스 연결 : 

 ```java
         String jdbc_url = "jdbc:mysql://localhost3306/database?serverTimezone=UTC";
         Connection con = DriverManager.getConnection(URL,"user", "password");
 ```

두번째 줄의 의미는 localhost:3306 (로컬환경에서 MySQL의 포트번호가 3306이기 때문이다.) 그리고  database는 스키마 이름을 지정하면 안된다. 
이제 Connection 객체를 만들어 사용하게 되는데 방법은 DriverManager 클래스의 static 메서드인 getConnection()메서드를 호출해서, mysql에 연결하기 위한 커넥션 정보(url, user, password)를 입력한다.
getConnection()메서드 수행결과로 Connection 객체를 반환하는데, 이 객체를 통해 쿼리를 날리는 statement를 작성할 수 있디. 
    ** SELECT 쿼리에서는 createStatement(), INSERT에서는 prepareStatement()를 호출한다.    

3. SQL을 위한 객체생성

```java
         Statement stmt = con.createStatement();
```

4. SQL 문장 실행


```java
         String sql = "select * from student";
         ResultSet result = stmt.executeQuery(sql);
```

 : select 문장은 테이블 형태의 결과를 반환한다. 그러므로 select 문장을 실행하기 위해 Statement의 메소드 executeQuery()를 사용한다. 메소드 executeQuery()는 질의 결과로 테이블 형태의 결과를 반환하는데, 이 반환형이 인터페이스 ResultSet이다.
    객체 Statement의 메소드 executeUpdate()는 create 또는 drop, insert, delete, update와 같이 테이블의 내용을 변경하는 문장에 사용한다.




:: 자바라는 프로그래밍 언어에서 JDBC를 사용하게 되면 DBMS 벤더에 의존하지 않는 독립적 시스템 개발을 해줄 수 있게 하는 것이다. 이를 통해, DBMS의 종류에 따라 다르게 코딩하지 않고, 어떤 DBMS든지 동일하게 데이터베이스의 CRUD를 구현할 수 있게 된다.



# DAO (Data Access Object)
: DAO는 Data Access Object의 줄임말로, 데이터 접근 객체라고 해석이 된다. 즉 DAO를 통해 DB를 연결하여 데이터를 가져오거나 삭제, 수정 등 CRUD를 작업하는 것이라고 생각하면 된다. 그 이유는, 다른 로직에서 데이터베이스(DB)를 통해 데이터를 얻어오려면 DB Driver와 Connection 객체를 생성하여 작업량이 많아진다. 비효율적인 작업량을 줄이기 위해 DB와 연결하는 객체를 따로 만들어 관리하면 불필요한 작업량이 줄어든다. 



: 데이터베이스의 데이터에 접근하는 트랜젝션 객체. 일종의 객체이다. DAO는 저수준의 Logic과 고급 비지니스 Logic을 분리하고, domain logic으로부터 persistence mechanism을 숨기기위해 사용한다. 
- persistence 계층 : Database(영구 저장소)에 데이터를 CRUD(create, read, update, drop)의 줄임말

: 웹서버는 DB와 연결하기 위해서 매번 커넥션 객체를 생성하는데, 이것을 해결하기 위해 나온 것이 컨넥션 풀이다.


  ConnectionPool이란 connection 객체를 미리 만들어 놓고, 그것을 가져다 쓰는 것. 또 다쓰고 난 후에는 반환해 놓는 것. 하지만 유저 한 명이 접속해서 한번에 하나의 커넥션만 일으키지 않고 게시판 하나만 봐도 목록볼 때 한번, 글 읽을때마다 한번, 글 읽을 때마다 한번 등등... 엄청나게 많은 커넥션이 일어나기에, 커넥션 풀은 커넥션을 또만드는 오버헤드 효과를 효율적으로 하기위해 DB에 접속하는 객체를 전용으로 하나만 만들었고, 모든 페이지에서 그 객체를 호출해다 사용한다면 이렇게 커넥션을 하남나 가져오고 그 커넥션을 가져온 객체가 모든 DB와의 연결을 하는 것이 바로 DAO객체이다.


: DB를 사용해 데이터를 조회하거나 조작하는 기능을 전담하도록 만든 오브젝트

: 사용자는 자신이 필요한 Interface를 DAO에게 던지고 DAO는 이 인터페이스를 구현한 객체를 사용자에게 편리하게 사용할 수 있도록 반환해준다.


  * DAO 인터페이스 만들기

```java

public interface IUserDao{
    public int insert(UserDto userDto);
    public int delete(String userId);
    public int modify(String userId, UserDto userDto);
    public List<UserDto> selectAll();
    public UserDto selectOne(String userId);
}

```

[DAO 클래스 예제]

```java

// DB와 연결할 Connection을 가져온다.
// 어떤 DB를 사용할 것이며, 어떤 드라이브와 로그인 정보를 사용할 것인가.
// 작업이 끝나면 사용한 리소스를 시스템에 돌려준다.

public class TestDao{

    public void add(DTOBean dto) throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.jdbc.Driver");

        Connection c = DriverManager.getConnection("jdbc:mysql://localhost/springbook","spring","book");
        PreparedStatement ps = c.prepareStatement("insert into users(id,name,password) value(?,?,?)");

        ps.setString(1, dto.getName());
        ps.setInt(2, dto.getValue());
        ps.setString(3, dto.getData());

        ps.executeUpdate();

        ps.close();
        c.close();
    }
}

```


#  DTO (Data Transfer Object)
: Data Transfer Objeect의 줄임말로, 프로세스 사이에서 데이터를 운반하는 객체(Object)라고 생각하면 된다. 이 DTO는  Dao나 Service 등처럼 로직을 가지고 있지 않고, Data에 접근하기 위해 getter와 setter를 가지고 있따. 즉, Dao가 데이터베이스(DB)에서 얻어온 데이터를 Service나 Controller로 보낼 때 getter와 setter를 통해 얻어 사용하는 객체라고 생각하면 된다.


: 계층간 데이터 교환을 위한 자바빈즈를 말한다. 여기서 말하는 계층간의 컨트롤러, 뷰, 비즈니스 계층, 퍼시스턴스 계층을 말하며 각 계층간 데이터 교환을 위한 객체를 DTO 또는 VO라고 부른다.
       cf) VO는 DTO와 동일한 개념이지만 read only 속성을 가짐

: 대표적인 DTO로는 폼데이터빈, 데이터베이스 테이블 빈 등이 있으며 각 폼요소나, 데이터베이스 레코드의 데이터를 매핑하기 위한 데이터 객체를 말한다. 즉 폼 필드들의 이름을 그대로 가지고 있는 자바빈 객체를 폼 필드와 그대로 매핑하여 비즈니스 계층으로 보낼 때사용한다. 이런 객체를 DTO라고 부르며 VO(Value Object)패턴이라고도 한다.

   VO 패턴은 데이터 전달을 위한 가장 효율적인 방법이지만, 클래스 선언을 위해 많은 코드가 필요하다는 단점이 있다.

   일반적인 DTO는 로직을 지가고 있지 않다. 순수한 데이터 객체이며 속성과 그 속성에 접근하기 위한 getter, setter 메소드만 가진 클래스를 말한다. 여기에 추가적으로 toString(), equals() 등의 Object 클래스 메소드를 작성할 수 있다.

   즉, 계층 간의 데이터 전달에 사용하는 데이터 객체들을 말한다.



```java

package com.ssafy.happyhouse.user.dto;

public class UserDto{
    private String userId;
    private String userName;
    private String userPwd;
    private String email;
    private String phoneNumber;

    public String getUserId(){
        return userId;
    }

    public void setUserId(String userId){
        this.userId = userId;
    }

    public String getUserName(){
        return userName;
    }

    public void setUserName(String userName){
        this.userName = userName;
    }

    public String getUserPwd(){
        return userPwd;
    }

    public void setUserPwd(String userPwd){
        this.userPwd = userPwd;
    }

    public String getEmail(){
        return email;
    } 

    public void setEmail(){
        this.email = email;
    }

    public String getPhoneNumber(){
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString(){
        return "UserDto [userId=" + userId + ",userName=" + userName + ",userPwd=" + userPwd + ",email=" 
        + email + ",phoneNumber=" + phoneNumber + "]";
    }
}

```


# 커넥션 풀(Connection pool)

1. 커넥션 풀(DBCP)이란
  : 웹 컨테이너(WAS)가 실행되면서 DB와 미리 connetion(연결)을 해놓은 객체들을 pool에 저장해두었다가 클라이언트 요청이 오면 connection 을 빌려주고, 처리가 끝나면 다시 connection을 반납받아 pool에 저장하는 방식을 말한다.

2. 커넥션 풀을 사용하는 이유

```java 
// JSP 샘플용 소스

Connection conn = null;
PreparedStatement pstmt = null;
ResultSet rs = null;

try{
    sql = "SELECT * FROM T_BOARD"

    // 1.드라이버 연결 DB 커넥션 객체를 얻음
    connection = DriverManager.getConnection(DBURL, DBUSER, DBPASSWORD);

    // 2. 쿼리 수행을 위한 PreparedStatement 객체 생성
    pstmt = conn.createStatement();

    // 3. executeQuery : 쿼리 실행후
    // ResultSet : DB 레코드 ResultSet에 객체에 담김
    rs = pstmt.executeQuery(sql);
   } catch (Exception e){
   }finally{
    conn.close();
    pstmt.close();
    rs.close();
   }

```

위와 같이 자바에서 DB에 직접 연결해서 처리하는 경우(JDBC) 드라이버(Driver)를 로드하고 커넥션(connection)객체를 받아와야 한다. 그러면 매번 사용자가 요청을 할 때마다 드라이버를 로드하고 커넥션 객체를 생성하여 연결하고 종료하기 때문에 매우 비효울적이다. 이런 문제를 해결하기 위해서 커넥션풀(DBCP)을 사용한다.



* DBCP (DataBase Connection Pool) : DB와 커넥션을 맺고 있는 객체르 관리하는 역할을 한다.

3. 커넥션 풀 특징
   - 웹 컨테이너(WAS)가 실행되면서 connection객체를 미리 Pool에 생성해둔다.
   - HTTP 요청에 따라 Pool에서 connection 객체를 가져다 쓰고 반환한다.
   - 이와 같은 방식으로 물리적인 데이터베이스 connection(연결) 부하를 줄이고 연결 관리 한다.
   - pool에 미리 connection이 생성되어 있기 때문에 connection을 생성하는데 드는 요청마다 연결 시간이 소비되지 않는다.
   - 커넥션을 계속해서 재사용하기 때문에 생성되는 커넥션 수를 제한적으로 설정함
  

  * 동시 접속자가 많을 경우
    - 위에 커넥션 풀 설명에 따르면, 동시 접속할 경우 Pool에서 미리 생성된 connection을 제공하고 없을 경우는 사용자는 connection이 반환될 때 까지 번호 순서대로 대기상태로 기다린다.
    - 여기서 WAS에서 커넥션 풀을 크게 설정하면 메모리 소모가 큰 대신 많은 사용자가 대기시간이 줄어들고, 반대로 커넥션 풀을 적게 설정하면 그 많큼 대기시간이 길어진다.













참고 블로그 :

https://devlog-wjdrbs96.tistory.com/139

https://genesis8.tistory.com/214

https://yongku.tistory.com/entry/Dto-Dao-Service-Controller

https://genesis8.tistory.com/214

https://linked2ev.github.io/spring/2019/08/14/Spring-3-%EC%BB%A4%EB%84%A5%EC%85%98-%ED%92%80%EC%9D%B4%EB%9E%80/