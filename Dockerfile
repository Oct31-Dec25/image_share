FROM alpine as builder
RUN sed -i "s/dl-cdn.alpinelinux.org/mirrors.aliyun.com/g" /etc/apk/repositories \
    && apk add --no-cache nodejs npm
COPY ./frontend /src/frontend
WORKDIR /src/frontend
RUN npm config set registry https://registry.npmmirror.com
RUN npm install && npm run build

FROM maven:3.9.5-eclipse-temurin-17 as builderBack
COPY ./backend /src/backend
COPY --from=builder /src/frontend/dist /src/backend/src/main/resources/static
WORKDIR /src/backend
RUN mvn clean package -Dmaven.test.skip=true

FROM openjdk:17-jdk-alpine
COPY --from=builderBack /src/backend/target/*.jar /app.jar
WORKDIR /
CMD ["java", "-jar", "app.jar"]

