#!/bin/bash
# Updated compile script for Java 11
# The core functionality remains the same, but we're now targeting Java 11

find -name "*.java" > sources.txt
# Using javac without explicit version flags - will use the system's default Java version
# which should be set to Java 11 for this project
javac @sources.txt
rm -rf sources.txt