# 사용할 base 이미지 선택
# amd64 서버와 arm64 서버 모두에서 사용할 수 있는 멀티 아키텍처 이미지
FROM eclipse-temurin:17-jdk-focal

# build/libs/ 에 있는 jar 파일을 JAR_FILE 변수에 저장
ARG JAR_FILE=build/libs/*.jar

# JAR_FILE을 app.jar로 복사
COPY ${JAR_FILE} app.jar

# Docker 컨테이너가 시작될 때 /app.jar 실행
# 애플리케이션 timezone을 대한민국으로 설정
ENTRYPOINT ["java", "-Duser.timezone=Asia/Seoul", "-jar", "/app.jar"]
