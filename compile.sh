#!/bin/bash
# Replaced manual javac compilation with Maven build process.
# Maven uses the pom.xml which should be configured for the target Java version (11).
mvn compile