package com.airtribe.meditrack.util;

import java.util.UUID;

public class IdGenerator {

    static {
        System.out.println("IdGenerator initialized");
    }

    private IdGenerator() {}

    public static String generateId() {
        return UUID.randomUUID().toString();
    }
}