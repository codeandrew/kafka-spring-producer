# Kafka Spring Boot Producer
> Dockerized Kafka using bitnami kafka image    
> https://hub.docker.com/r/bitnami/kafka



### KAFKA

** In Bitnami Images the working directory of Kafka is located at **
```
/opt/bitnami/kafka
```

#### To Create Topic

```
./kafka-topics.sh --create --zookeeper zookeeper:2181 --replication-factor 1 --partitions 1 --topic example
```

#### To Create Producer
```
./kafka-console-producer.sh --broker-list 127.0.0.1:9092 --topic test
```


#### To Create Consumer 
```
./kafka-console-consumer.sh --bootstrap-server 127.0.0.1:9092 --topic test --from-beginning
```


---
Notes: 
For Kubernetes Helm
https://github.com/bitnami/charts/tree/master/bitnami/kafka
