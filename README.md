# java-logger
Simple Java application that uses jfortune and cowsay to output logs.

## Table of Contents

<!-- toc -->

- [Background](#background)
- [Pre-requisites](#pre-requisites)
- [Build the JAR](#build-the-jar)
- [Run the JAR](#run-the-jar)

<!-- tocstop -->

## Background

In order to test an EFK (Elasticsearch, FluentD and Kibana) stack I required a Java app that can output logs in an
easily configurable way so that it is easy to trial various FluentD configuration files. This project outputs a JAR
that can be run wherever JAVA is available.

## Pre-requisites
All these instructions are for macOS only.

- Install [Homebrew](https://docs.brew.sh/Installation.html)
- Install [Java](https://docs.oracle.com/javase/8/docs/technotes/guides/install/mac_jdk.html)

```bash
brew install git maven
```

## Build the JAR
```bash
mvn clean install
```

## Run the JAR
```bash
java -Dlogger.loopCount=50 -Dlogger.sleep=100 -jar target/java-logger-1.0.0-SNAPSHOT-jar-with-dependencies.jar
```

Here are the available options:

| Command | Description |
| --- | --- |
| logger.loopCount | (Optional) The number of times to iterate. Default value = 10 |
| logger.sleep | (Optional) The number of milliseconds to sleep between each iteration of the loop. Default value = 500 |
