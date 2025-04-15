find -name "*.java" > sources.txt
# Using javac with Java 11 - no specific changes needed as the script uses the system's default javac
# If a specific Java 11 installation needs to be used, you could add:
# export JAVA_HOME=/path/to/java11
# export PATH=$JAVA_HOME/bin:$PATH
javac @sources.txt
rm -rf sources.txt