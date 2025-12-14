package com.airtribe.meditrack.util;

public class Validator {
    public static void validateName(String name) {
        if (name == null || name.isEmpty())
            throw new IllegalArgumentException("Invalid Name");
    }
}