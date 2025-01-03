# < 아이티센 - AWS 특강 1 >

### 클라우드 컴퓨팅이란?
: 인터넷을 통해 (물리적 서버, 네트워크와 같은 ) IT 리소스와 (데이터 분석과 같은) 애플리케이션을 원할 때 언제든지(On-demand)사용한 만큼만 요금을 내는 서비스

: 클라우드 컴퓨팅을 사용하면 인프라를 하드웨어가 아닌 소프트웨어로 간주하고 사용할 수 있다. : 프로그래밍 가능한 리소스, 동적기능, 종량 과금제

: 몇 번의 클릭과 간단한 명령만으로 IT 자원을 언제 어디서나 바로 사용할 수 있다.

### 클라우드 컴퓨팅의 6가지 이점
1. 초기 선투자 비용 없음 : 고정비용을 가변비용을 대체. 미리 서버를 구매할 필요 없음
2. 운영 비용 절감 : 사용한 만큼만 지불하며 규모의 경제로 인한 지속적인 비용 절감
                (상면(물리적 공간) 비용, 전력 비용, 향후 증설 비용, 항온항습 비용, 운영 관리 비용, 라이선스 비용 등등)
3. 탄력적인 운영 및 확장 : 필요 용량에 대한 예측 불필요. 수요에 맞춘 유연한 확장
4. 속도 및 민첩성 : 수 분 만에 인프라 구축 가능. 빠르게 변화에 대응
5. 비즈니스에만 집중 가능 : 혁신을 위한 다양한 실험 가능. 불필요한 인프라 관리 업무 제거
6. 글로벌 확장 : 빠른 시간 내 글로벌 서비스 구현 가능

### 왜 Amazon이 클라우드를?
- Amazon.com이라는 확장성 높은 글로벌 온라인 전자 상거래 서비스를 제공하는데 대용량 인프라 서비스 기술이 핵심 역량이라고 판단하고, 2006년 Amazon Web Service(AWS) 시작
- 2002년 제프베조스(CEO)는 모든 아마존 서비스가 웹 프로토콜을 통해 서로 쉽게 소통할 수 있는 방식으로 구축되어야 한다고 주장했고, 그는 모든 팀이 서비스 인터페이스를 통해 데이터와 기능을 노출해야한다는 명력을 내렸다.
- 가장 트래픽이 몰리는 크리스마스 시즌에 대비해 인프라를 구축했지만 그 이후에는 활용도가 낮은 IT 인프라를 최대한 활용하기 위해
- 아마존 닷컴을 10년간 운영하면서 축적한 기술을 바탕으로 클라우드 사업을 체계적으로 준비
- 아마존 닷컴의 모든 기능은 API로 서로 통신하는 서비스 지향 아키텍처(SOA), 오늘날로 치면 마이크로서비스 아키텍처로 구성
- AWS의 수많은 서비스들은 API로 제공하는데 유리

#### AWS 핵심 인프라 및 서비스
방화벽/ACL/관리자  <= 보안 => 보안그룹/네트워크 ACL/AWS IAM
라우터/네트워크 스위치/파이프라인 <= 네트워킹 => Elastic Load Balancing/Amazon VPC
온프레미스 서버 <= 서버 => AMI/Amazon EC2 인스턴스
DAS/SNA/NAS/RDBMS <= 스토리지 및 데이터베이스 => Amazon EBS/Amazon EFS/Amazon S3/Amazon RDS

#### AWS 주요 서비스 분야
: 컴퓨팅, 스토리지, 데이터베이스, 네트워킹, 보안

#### AWS 작동방식
- AWS는 네트워크로 연결된 하드웨어를 소유하고 유지 관리
- 고객은 필요한 항목을 피로비저닝하고 사용

#### AWS와 상호작용하는 3가지 방법
- AWS Management Console : 사용하기 쉬운 그래픽 인터페이스
- AWS 명령줄 인터페이스(AWS CLI) : 개별 명령을 사용하여 서비스에 액세스
- 소프트웨어 개발 키트(SDK) : 코드에서 서비스에 액세스



# < 아이티센 - AWS 특강 2 >

#### AWS 핵심 서비스
- Amazon Elastic Compute Cloud(Amazon EC2) 
    : 크리 조정 가능한 컴퓨팅 용량 / 컴퓨팅 리소스 완전 제어 / 새로운 서버 인스턴스 확보 및 부팅시간 단축
- Amazon EC2 : 종량 과금제 요금과 다양한 하드웨어 및 소프트웨어를 제공
    : Amazon Machine Image(AMI) 사용, 필요에 따라 인스턴스를 추가 또는 종료, 인스턴스 일시중지 및 다시 시작
    * 이점 : 탄력성, 제어, 유연성, 통합, 안정성, 보안, 저렴한 비용, 용이성 
- Amazon Elastic Container Service(Amazon ECS)
    : 컨테이너의 실행을 조정한다 / 컨테이너를 실행하는 노드 플릿을 유지 관리하고 확장한다. / 인프라 구축의 복잡성을 제거한다.

#### 서버리스 컴퓨팅이란?
: 서버를 관리하지 않고 애플리케이션과 서비스를 구축하고 실행
   - 프로비저닝하거나 관리할 서버 없음
   - 사용량에 따라 조정
   - 유휴 상태에 대한 지불 없음
   - 가용성 및 내결함성 내장 

#### 스토리지
 * AWS 스토리지 옵션
  - Amazon S3 : 클라우드상의 확장 가능하고 내구성이 뛰어난 객체 스토리지
  - Amazon EBS : Amazon EC2 인스턴스를 위한 내구성이 있는 블록수준 스토리지를 제공하는 네트워크 연결 볼륨
  - Amazon S3 Glacier : 클라우드상의 저렴하고 내구성이 뛰어난 아카이브 스토리지
  - Amazon Storage Gateway : 온프레미스에서 거의 무제한의 클라우드 스토리지에 액세스할 수 있는 하이브리드 클라우드 스토리지 서비스
  - Amazon EFS : Amazon EC2 인스턴스용 확장 가능한 네트워크 파일 스토리지

@ Amazon Simple Store Service (Amazon S3)
 : 객체 수준 스토리지 / 99.9999999% 내구성을 제공하도록 설계 / 이벤트 트리거
 - 사용 사례 : 콘텐츠 저장 및 배포, 백업 및 아카이빙, 빅데이터 분석, 재해 복구, 정적 웹 사이트 호스팅
 - 데이터를 저장 및 검색 하도록 구축
 - 속도, 내구성, 가용성이 뛰어난 객체 액세스
 - 버킷에 저장할 수 있는 객체 수에 제한이 없음
 - 웹 어디서나 언제든 데이터 저장 및 검색

@ Amazon S3 Glacier
: 장기 데이터 스토리지, 아카이브 및 백업, 비용이 매우 저렴한 스토리지
- 사용 사례 : 미디어 자산 워크플로, 의료 정보 아카이빙, 규제 및 규정 준수를 위한 아카이빙, 과학적 데이터 스토리지, 디지털 보존, 마그네틱 테이프 대체

@ Amazon Elasitc Block Store(Amazon EBS)
- 인스턴스용 영구 블록 스토리지
- 복제를 통해 보호
- 상이한 드라이브 유형
- 몇 분 만에 확장 또는 축소
- 프로비저닝한 만큼만 요금 지불
- 스냅샷 기능
- 암호화 사용 가능



# < 아이티센 - AWS 특강 3 >

#### 데이터베이스 종류
- 관계형 데이터베이스, 비관계형 키-값, 비관계형 문서, 비관계형 인 메모리, 비관계형 그래프, 비관계형 원장

#### DIY(설치형)와 AWS 데이터베이스 서비스 비교
- Amazon EC2의 데이터 베이스 : 운영 체제 액세스, 특정 애플리케이션의 기능 필요
- AWS 데이터베이스 서비스 : 손쉬운 설정, 관리, 유지 / 즉각적인 고가용성 구현, 성능에 초점, 관리형 인프라

#### 네트워크
* Amazon Virtual Private Cloud(Amazon VPC)
   - AWS 클라우드의 프라이빗 네트워크 공간
   - 워크로드의 논리적 격리 제공
   - 리소스에 대한 사용자 지정 액세스 제어 및 보안 설정 허용
   - 서브넷을 사용하여 VPC 분리
       : 서브넷은 리소스 그룹을 격리할 수 있는 VPC IP 주소 범위의 세그먼트 또는 파티션
       : 서브넷은 인터넷 접근성을 정의
       * 프라이빗 서브넷
          - 인터넷 게이트웨이에 대한
          - 라우팅 테이블 항목 없음
          - 퍼블릭 인터넷에서 직접 액세스 불가

* VPC의 계층화된 네트워크 방어
  1. VPC 라우팅 테이블
  2. 서브넷 ACL : 인바운드/아웃바운드
  3. EC2/탄력적 네트워크 인터페이스 보안 그룹 : 인바운드/아웃바운드
  4. 서드 파티 호스팅 기반 보호
=> 모든 계층에서의 보안 "심층 방어"

* Elastic Load Balancing(ELB)
  : 수신되는 애플리케이션 트래픽을 여러 Amazon EC2 인스턴스, 컨테이너, IP 주소에 분산하는 관리형 로드 밸런싱 서비스

* Amazon Route 53
  : Route 53은 가용성과 확장성이 뛰어난 클라우드 Domain Name System(DNS)서비스
   - DNS는 도메인 이름을 IP 주소로 변환
   - 도메인 이름을 구입하여 관리하고 DNS 설정을 자동으로 구성할 수 있음
   - AWS에서 유연한 고성능, 고가용성 아키텍처를 위한 도구를 제공
   - 멀티플 라우팅 옵션



#### 보안
* 보안은 AWS의 최우선 과제 : 보안을 고려한 설계, 지속적 모니터링, 고도의 자동화, 높은 가용성, 엄격한 인증

* AWS Identity and Access Management(IAM)
  : AWS 리소스에 대한 액세스를 안전하게 제어
     - 사용자, 그룹 또는 역할에 세분화된 권한 할당
     - AWS 계정에 대한 임시 액세스 공유
     - 회사 네트워크의 사용자 연동 또는 인터넷 자격 증명 공급자와 연동

* IAM 구성요소
 - 사용자 : AWS와 상호작용하는 사람 또는 애플리케이션
 - 그룹 : 동일한 권한을 가진 사용자 모음
 - 역할 : 엔터티가 맡을 수 있는 임시권한 / 권한, 정책
  
  * 사용자가 액세스 할 수 있는 AWS 리소스 정의
  * 자격 증명 및 액세스 제어 표준을 충족하는 데 도움 - 인증, 권한 부여

@ IAM 사용자
- IAM 사용자는 별도의 AWS 계정이 아닌 계정 내 사용자
- 각 사용자는 자체 자격 증명 보유
- IAM 사용자는 자체 권한을 기준으로 특정 AWS 작업을 수행할 권한 보유

* Amazon S3 액세스 제어 : 일반
  - 일부 서비스는 S3 버킷 정책과 같은 리소스 기반 정책을 지원

* AWS CloudTrail
 : AWS 계정의 사용자 활동 및 API 사용 추적
  - 지속적으로 사용자 활동을 모니터링하고 API 호출을 기록
  - 규정 준수 감사, 보안 분석, 문제 해결에 유용
  - 로그 파일은 Amazon S3 버킷으로 전송됨
  - API 보안 관련 정보 : 누가, 무엇을, 언제, 어디로 

* AWS Trusted Advisor
  : 비용절감, 성능 개선, 보안 강화에 도움이 되는 지침을 제공하는 서비스

  

   