# Spring Application

## Kafka cluster in Windows

## START

```bash
cd kafka_directory

.\bin\windows\kafka-server-start.bat .\config\kraft\server-1.properties
.\bin\windows\kafka-server-start.bat .\config\kraft\server-2.properties
.\bin\windows\kafka-server-start.bat .\config\kraft\server-3.properties
```


## STOP

```bash
cd kafka_directory

.\bin\windows\kafka-server-stop.bat
```
