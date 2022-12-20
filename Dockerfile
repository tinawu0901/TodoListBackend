# 基礎image use java1.8
FROM openjdk:8

MAINTAINER yating

# 將jar報添加到容器中並更名為yating_docker.jar 
# 將宿主機目錄下的文件拷貝進鏡像且會自動處理URL和解壓tar壓縮包 

ADD target/todolist-0.0.1-SNAPSHOT.jar /yating_docker.jar
# 運行jar包 -c cmd
ENTRYPOINT ["java","-jar","/yating_docker.jar"]
# 暴露8000端口作為為服務
EXPOSE 8000