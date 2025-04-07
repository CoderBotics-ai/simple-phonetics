#!/bin/bash
# Ensure JAVA_HOME points to the Java 21 installation
# Replace /path/to/java21 with the actual path to your Java 21 JDK
export JAVA_HOME=/path/to/java21
# Add the Java 21 bin directory to the PATH to ensure the correct java/javac is used
export PATH=$JAVA_HOME/bin:$PATH

# === Java 21 Version Check Start ===
# Verify that the active Java version is 21 before proceeding with compilation.
echo "Checking Java version..."
# Execute 'java -version' and redirect stderr (where version info is often printed) to stdout (2>&1).
# Pipe the output to awk. -F[\"_] sets the field separators to either a double quote (") or an underscore (_).
# 'NR==1{print $2}' processes only the first line (NR==1) and prints the second field based on these separators.
# For typical 'java -version' output like 'openjdk version "21.0.1" 2023-10-17', this aims to extract '21.0.1'.
JAVA_VERSION_OUTPUT=$(java -version 2>&1)
# Extract the version string (e.g., "21.0.1") from the first line
JAVA_VERSION=$(echo "$JAVA_VERSION_OUTPUT" | awk -F[\"_] 'NR==1{print $2}')

# Check if the extracted version string starts with '21'.
if [[ "$JAVA_VERSION" != 21* ]]; then
  echo "Error: Java 21 is required. Found version details:"
  echo "$JAVA_VERSION_OUTPUT" # Print full output for diagnosis
  echo "(Extracted version for check: '$JAVA_VERSION')" # Show what was extracted
  exit 1
fi
echo "Java version check passed. Found version starting with '$JAVA_VERSION'."
# === Java 21 Version Check End ===

# Replaced manual javac compilation with Maven build process.
# Maven uses the pom.xml which should be configured for the target Java version (21).
# The mvn command will use the JAVA_HOME set above.
mvn compile