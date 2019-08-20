# Number-To-Words

Number-To_words is a Java Springboot application for parsing numeric input (from stdin) to it's equivalent in words.

## Installation

Just clone this project 

```bash
git clone https://github.com/dr34mh4ck/number-to-words.git
```

## Building

This project uses Gradle, for building please use the gradle wrapper provided within the project, go to the projects root folder and type 

```bash
./gradlew build
```

This command build the project, execute all it's tests and generates a .jar file on the folder ./build/libs/number-to-words-xxx.jar

## Usage
from a command line console go to the generated jar folder and type

```bash
java -jar number-to-words-xxx.jar
```
Make sure the xxx in the jar name are replaced according to the generated jar version.

A simple REPL interface will appear, to use it please input the number you want to parse to words.

To exit the REPL interface please type 'exit' instead any other other input.

## Tools

```bash
- Java 1.8
- Springboot 2.1.7
- lombok [latest]
- gradle [gradle wrapper is provided]
- Mockito
```

## Importing the project
You can import this project on your preferred IDE, please use the gradle wrapper when importing

## License
[MIT](https://choosealicense.com/licenses/mit/)