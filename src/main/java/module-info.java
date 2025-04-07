/**
 * Defines the module for the simple-phonetics library.
 * This module exports the public API packages necessary for users of the library,
 * enabling modular applications to utilize its phonetic encoding capabilities.
 *
 * Adopting the Java Platform Module System (JPMS) enhances encapsulation and reliability.
 */
module simple.phonetics {
    // Explicitly require java.base for clarity, although often implicit.
    // Confirmed during Java 17 upgrade review.
    requires java.base;
    // Require java.logging as the library may use the Java Logging API.
    // Added during Java 17 upgrade review to ensure module compatibility.
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

    // Opens the core package to JUnit Platform Commons for reflective access during testing.
    // Added during Java 21 upgrade review to ensure test frameworks can access necessary internals,
    // aligning with stricter module encapsulation checks if reflection is used in tests.
    // Adjust or add more 'opens' directives if other packages or frameworks require reflective access.
    opens com.group.phonetics to junit.platform.commons;
    // Example: If POJOs also need reflective access by test frameworks:
    // opens com.group.phonetics.pojo to junit.platform.commons;
    // Example: If utilities need reflective access by test frameworks:
    // opens com.group.phonetics.util to junit.platform.commons;

}