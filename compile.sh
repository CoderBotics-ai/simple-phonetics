#!/bin/bash
# Updated compile script for Java 21
# The core functionality remains the same, but we're now targeting Java 21
# Changed from Java 17 to Java 21 in the comments

find -name "*.java" > sources.txt
# Using javac without explicit version flags - will use the system's default Java version
# which should be set to Java 21 for this project
# No changes needed to the javac command as it uses the system's default Java version
javac @sources.txt
rm -rf sources.txt