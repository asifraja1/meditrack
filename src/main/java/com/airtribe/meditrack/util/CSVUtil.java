package com.airtribe.meditrack.util;

public class CSVUtil {
    public static String[] parse(String line) {
        return line.split(",");
    }
}