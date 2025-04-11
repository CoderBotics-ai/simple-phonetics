/**
 * Defines the module for the simple-phonetics library.
 * This module exports the public API packages necessary for users of the library,
 * enabling modular applications to utilize its phonetic encoding capabilities.
 *
 * Adopting the Java Platform Module System (JPMS) enhances encapsulation and reliability.
 * Reviewed for Java 21 compatibility: No changes required as module declarations
 * remain valid and necessary dependencies (java.base, java.logging) are already declared.
 */
module simple.phonetics {
    // Explicitly require java.base for clarity, although often implicit.
    // Confirmed during Java 17 upgrade review. Remains valid for Java 21.
    requires java.base;
    // Require java.logging as the library may use the Java Logging API.
    // Added during Java 17 upgrade review to ensure module compatibility. Remains necessary for Java 21.
    requires java.logging;

    // Exports the core phonetics functionality package, including main encoder classes.
    exports com.group.phonetics;

    // Exports the package containing enumerations used within the library's public API.
    exports com.group.phonetics.enums;

    // Exports the package containing custom exceptions thrown by the library.
    exports com.group.phonetics.exception;

    // Exports the package containing Plain Old Java Objects (POJOs) used in the public API.
    exports com.group.phonetics.pojo;

    // Exports the package containing utility classes relevant to the library's users.
    exports com.group.phonetics.util;
}