### Pull image from docker hub

```shell
docker image pull node
```

---
### create and start container

- and if image doesn't exist, it will pull the image

```shell
docker container run 
```

---
### interactive mode in container

```shell
docker container run -it con-name img-name
```

---

### Show containers

#### all containers

```shell
docker container ls -a
```

#### running containers 

- ps -> show running process in machine

```shell
docker ps
```

---
### open - create container 

```shell
docker container run --name name -it python bash or \bin\bash
```

---
### remove containers

```shell
docker container rm name
```

---
### remove image

```shell
docker image rm image_name
```

---
### pulling image 

```shell

```

---
### running processes on JVM

```shell
jps
```

--- 
### IP address show

يعرض كل **الـ network interfaces** (كروت الشبكة) اللي موجودة عندك على الجهاز أو جوه الـ container، مع الـ **IP addresses** بتاعتها.

---
### image info

```bash
docker image inspect
```

---
### images id

```terminal
docker image ls -q
```

---
### delete all images

```
docker image rm $(docker image ls -q) 
```

---
### detach mode

- container run in background no interaction

```shell
docker container run -d --name web-server -p 80:80 nginx:latest
```

---

### copy file :

```shell
docker container cp source container:locatoin

docker container cp /index.py 7e80:/temp/index.py
```

---
### defining host inside container

```shell
docker container run -it --name ahmed --add-host web:172.0.0.2 python:latest
```

---
### defining network type 

```shell
docker container run -it --name ahmed --network none python:latest
```

---
### creating network

```shell
docker network create name // --subnet 172.17.0.0/17 
--internal => containers see each others only -> good in testing
```

---
### assign container with network

```shell
docker network connect network-name container-name
```

---
### bind mount

```bash
docker container run -it -v pwd:/app/code python
```

---
### creating volume

```bash
docker volume create myVolume
```

```bash
docker volume create mydata
docker run -it -v mydata:/app/data ubuntu
```

---
### building image 

```shell
docker build -t myImage:v1.1 (. , github repo)
```

---

### bind mount volume :

#### 2 way bind

```
docker run -it --name c1 -v pwd:/app python
```

#### 1 way bind

```
docker run -it --name c1 -v pwd:/app:ro python
```

---

### anonyms volume :

```
-- when you do not give a name to the volume
docker run -it --name c1 -v /app python
```

---
### arg

```yml
---in docker file
ARG name
RUN if [ "$name" = "production"]; \
	then npm install --only=production; \
	else nps install; \
	fi
	
---in docker compose
build:
	context: .
	arg:
		- node_env=production
```

---
