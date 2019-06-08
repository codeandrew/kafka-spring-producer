#!/bin/sh

cd producer
./gradlew build

cd ..
pwd

docker-compose build
docker-compose up
