
FROM maven:3.9-eclipse-temurin-21 AS build
WORKDIR /app

COPY pom.xml .
COPY src ./src


RUN mvn clean package -DskipTests


FROM tomcat:10.1-jdk21-temurin
WORKDIR /usr/local/tomcat


RUN rm -rf webapps/*


# Đổi tên thành ROOT.war để chạy trực tiếp ở đường dẫn gốc http://localhost:8080/
COPY --from=build /app/target/Cart.war webapps/ROOT.war

EXPOSE 8080
CMD ["catalina.sh", "run"]
