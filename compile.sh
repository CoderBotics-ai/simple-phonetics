#!/bin/bash
# Ensure JAVA_HOME points to the Java 21 installation
# Replace /path/to/java21 with the actual path to your Java 21 JDK
export JAVA_HOME=/path/to/java21
# Add the Java 21 bin directory to the PATH to ensure the correct java/javac is used
export PATH=$JAVA_HOME/bin:$PATH

# Replaced manual javac compilation with Maven build process.
# Maven uses the pom.xml which should be configured for the target Java version (21).
# The mvn command will use the JAVA_HOME set above.
mvn compile