Web 서버

Web 서버는 클라이언트가 웹 브라우저에서 서버에 페이지 요청을 하면 Web 서버에서 요청을 받아 정적 페이지(.html .jpeg .css 등..) 컨텐츠를 제공하는 서버 대표적인 WEB서버에는 Apache, NGINX 와 Windows 전용 Web 서버 인 IIS 가 있음

WAS (Web Application Server)

html 만으로는 할 수 없는 데이터베이스 조회나 다양한 로직처리 같은 동적인 컨텐츠를 제공하기 위해 만들어진 어플리케이션 서버 대표적인 WAS에는 Tomcat, Jeus, JBoss, Web Sphere 등이 있음

Web 서버를 반드시 구축해야하는 것은 아니다. 허나 WAS는 동적 컨텐츠를 제공하기 위해 존재하는 서버이기에 정적 컨텐츠 요청이 들어온다면 Web서버보다 수행속도가 느릴 수 밖에 없다. 이 때문에 Web서버를 앞에 두고 필요한 WAS 들을 Web서버에 플러그인 형태로 설정하여 효율적으로 처리되도록 한다.

출처 : https://shj7242.github.io/2018/06/18/ETC/