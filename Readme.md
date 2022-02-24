
Запуск приложения происходит с помощью команды:
```java
docker-compose up -d
```

Данная команда выполняет сценарий из файла docker-compose.yml:
```yaml
version: '2.1'
services:
  #  запускает сценарий из файла Dockerfile из 
  #  папки /back - это мой REST-SERVICE
  web_back:
    build: back
    image: back
    container_name: 'back'
    ports:
      - 8080:8080
    command: bash -c 'while !</dev/tcp/db/5432; do sleep 1; done; java -jar myapp.jar'
    depends_on:
      - db
      
  # запускает базу данных postgres туда сохраняются данные
  # по картам и переводам
  db:
    image: postgres
    container_name: 'transfer_db'
    environment:
      - POSTGRES_USER=user
      - POSTGRES_PASSWORD=user
      - POSTGRES_DB=userdb

  # запускает сценарий из файла Dockerfile из папки 
  # /fornt-это предоставленный frontend
  web_front:
    build: front
    image: front
    container_name: 'front'
    ports:
      - 3000:3000
    depends_on:
      - db

  # для подключения к бд и проверки сохраняются ли данные, 
  # поднимаем pgAdmin- это не обязательно
  pgadmin:
    image: dpage/pgadmin4
    container_name: 'pgadmin4'
    depends_on:
      - db
    ports:
      - 5400:80
    environment:
      PGADMIN_DEFAULT_EMAIL: pgadmin4@pgadmin.org
      PGADMIN_DEFAULT_PASSWORD: admin

```
Сценарий поднимает 4 контейнера: front, back, transfer_db, pgadmin4:

front - это предоставленный front-end http://localhost:3000/;

back - это сервер обрабокти REST запросов от front. 
Обрабатывает только post-запросы;

transfer_db - это база данных с которой работает back;

pgadmin4 - контейнер для подключения к transfer_db http://localhost:5400;
Имя: pgadmin4@pgadmin.org
пароль: admin

Останавливается приложение командой: 
```java
docker-compose down 
```
