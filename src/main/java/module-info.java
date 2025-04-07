/**
 * Defines the module for the simple-phonetics library.
 * This module exports the public API packages necessary for users of the library,
 * enabling modular applications to utilize its phonetic encoding capabilities.
 *
 * Adopting the Java Platform Module System (JPMS) enhances encapsulation and reliability.
 */
module simple.phonetics {
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