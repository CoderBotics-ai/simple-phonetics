# simple-phonetics
Template for REST webservice with spring

## Tecnologies

* Java 11 // Updated from Java 8 to Java 11
* Maven 3
* Release plugin
	* FindBugs plugin
	* JUnit

## Builds

To generate local builds with maven:
```bash
mvn clean install
```

To generate versioned builds for production and homologation enviroments:
```
mvn release:clean
mvn release:prepare
```

## Run
Find the SearchPhonetics root folder then run:
```
java -cp (jar file project) (Main and its path) (string list separated by space) < (input file .txt with a list of word separated by break-line)
```
Example
```
java -cp target/SearchPhonetics-0.0.1-SNAPSHOT.jar com.group.phonetics.Main 1ton# brief soon \< path\\to\\input\\file\\word_dict.txt
```
Check the word_dict.txt file on resource folder to check an example of input file.