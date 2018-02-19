# java-logger
Simple Java application that uses jfortune and cowsay to output logs.

## Table of Contents

<!-- toc -->

- [Background](#background)
- [Pre-requisites](#pre-requisites)
- [Build the JAR](#build-the-jar)
- [Run the JAR via default entry point](#run-the-jar-via-default-entry-point)
- [Run the JAR via named entry point](#run-the-jar-via-named-entry-point)
- [References](#references)

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

## Run the JAR via default entry point
```bash
export LOGGER_LOOP_COUNT=30
export LOGGER_THREAD_SLEEP=500
java -Dlogger.loopCount=${LOGGER_LOOP_COUNT} -Dlogger.sleep=${LOGGER_THREAD_SLEEP} -jar target/java-logger-1.0.0-SNAPSHOT-jar-with-dependencies.jar
```

Here are the available options:

| Command | Description |
| --- | --- |
| logger.loopCount | (Optional) The number of times to iterate. Default value = 10 |
| logger.sleep | (Optional) The number of milliseconds to sleep between each iteration of the loop. Default value = 500 |

## Run the JAR via named entry point
```bash
export LOGGER_ENTRY_POINT=30
java -cp target/java-logger-1.0.0-SNAPSHOT-jar-with-dependencies.jar io.thinkstack.logger.slf4j.${LOGGER_ENTRY_POINT}
```

Here are the available entry points:

| Entry Point | Description |
| --- | --- |
| HelloWorld | Outputs a single Hello World at INFO level plus a message at DEBUG level if enabled |
| CowsayOutput | Outputs a loop of single line INFO messages and then a fortune cookie message delivered via Cowsay |
| SingleLineOutput | Outputs a configurable loop of messages generated via fortune cookies |

## References
- [Cowsay](https://github.com/RickSBrown/cowsay)
- [jfortune](https://github.com/oboehm/jfortune)
