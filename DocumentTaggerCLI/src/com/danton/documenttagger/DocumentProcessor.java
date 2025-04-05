package com.danton.documenttagger;

public class DocumentProcessor {
    public static String[] generateTags(String content) {
        return TaggerEngine.tag(content);
    }
}
