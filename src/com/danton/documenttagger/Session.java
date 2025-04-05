package com.danton.documenttagger;

public class Session {
    private static String[] currentTags;

    public static void setCurrentTags(String[] tags) {
        currentTags = tags;
    }

    public static String[] getCurrentTags() {
        return currentTags;
    }

    public static boolean hasTags() {
        return currentTags != null && currentTags.length > 0;
    }
}
