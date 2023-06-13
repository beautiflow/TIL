* DB 시스템의 특성
  - 최초 적재(Loading) -> 이벤트 발생에 따른 잦은 변경(Interaction)
  - 대용량의 데이터를 다룸
       - 사용자들이 원하는 순간 데이터에 접근하기 위해서는?
            -> 대용량의 데이터가 체계적으로 조직화되어 있어야 함.


*Database
- 데이터 및 데이터 간 관계의 집합

* DBMS(Database Management Systems)
- 사용자가 Database에 접근할 수 있도록 지원해주는 프로그램의 집합


* 데이터베이스 스키마
- 데이터베이스 구조, 데이터 타입 그리고 제약조건에 대한 명세
- 데이터베이스 설계 단계에서 명시되며, 자주 변경되지 않음
  
* 데이터베이스 인스턴스
- 특정 시점에 데이터베이스에 실제로 저장되어있는 데이터
   = Database instance = Occurence = Snapshot

* SQL
* DML/DDL
  - 데이터 정의어(DDL : Data Definition Language)
      - 스키마를 기술하기위해 사용되며, 주로 DB 설계자가 사용함
  - 데이터 조작어(DML : Data Manipulation Language)
      -  데이터의 조회, 삽입, 삭제, 갱신에 사용됨
  - DCL (Data control language), TCL(Transaction Control Language)    


* 독립 실행형 / 내장형
  - 독립 실행형 : SQL 인터페이스를 이용하여 SQL 쿼리를 직접 DBMS에 입력
  - 내장형 : C, C++, java 등의 프로그래밍 언어에 내장됨
  - Host language + Data sublanguage로 구성됨
  

 <ER Model Concepts> 
 - 개체(Entity)
   : 실세계에 존재하는 의미있는 하나의 정보 단위
   : 물리적 객체 뿐 아니라 개념적 객체도 포함

 -  관계(Relationship)
   : 개체들 사이의 연관성
       ex ) [학생]과 [교과목]사이의 [수강]관계

 - 속성(Attribute)
   : 개체 또는 관계의 본질적 성질
      - Single-valued VS Multivalued / 나이 VS 취미
      - Simple vs. Composite
           - Simple Attribute : 더 이상 쪼개지지 않는 원자값을 갖는 속성
                 - 나이, 학번
           - Composite Attribute : 몇 개의 요소로 분해될 수 있는 속성
                 - 주소 => 시, 군, 구, 번지, ...
      - Stored vs. Derived
            - Derived Attribute - 저장된 다른 데이터로부터 유도 가능한 속성
                 - 각 과목의 성적 => 총점, 주민등록번호 => 나이, ...


<Entity Types and Key Attributes>

* 키 속성(Key Attributes)
  - 어떤 개체에 대해서 항상 유일한 값을 갖는 속성(또는 속성들의 집합)
     - 학생의 학번, 책의 ISBN, 자동차의 차량번호, ...
  - 특정 Snapshot이 아닌, 해당 개체의 모든 가능한 Snapshot의 집합을 고려하여 파악되어야 함 

  - 복합 키(Key Attributes)
     - Composite Attribute가 키 속성이 되는 경우
     - 복합 키는 최소성을 가져야 함
           - (팀명, 등번호) vs. (팀명, 등번호, 선수명)
     -  각 개체는 하나 이상의 키를 가질 수 있음
     -  어떤 개체는 키를 갖지 않을 수도 있음
        - > 약성개체(Weak Entity)

 



