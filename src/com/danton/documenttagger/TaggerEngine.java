package com.danton.documenttagger;

import java.util.*;

public class TaggerEngine {
    private static final Map<String, List<String>> tagKeywords = new HashMap<>();

    static {
        tagKeywords.put("Artificial Intelligence", Arrays.asList("ai", "machine learning", "neural network", "deep learning"));
        tagKeywords.put("Cloud Computing", Arrays.asList("cloud", "aws", "azure", "gcp", "virtual machine"));
        tagKeywords.put("Networking", Arrays.asList("network", "tcp", "ip", "firewall", "router", "switch"));
        tagKeywords.put("Data Analysis", Arrays.asList("data", "analysis", "analytics", "data mining", "statistics"));
        tagKeywords.put("Cybersecurity", Arrays.asList("security", "malware", "phishing", "encryption", "threat"));
        tagKeywords.put("Software Development", Arrays.asList("java", "python", "development", "code", "programming", "software"));
    }

    public static String[] tag(String content) {
        Set<String> foundTags = new HashSet<>();
        String lowerContent = content.toLowerCase();

        for (Map.Entry<String, List<String>> entry : tagKeywords.entrySet()) {
            for (String keyword : entry.getValue()) {
                if (lowerContent.contains(keyword)) {
                    foundTags.add(entry.getKey());
                    break;
                }
            }
        }

        if (foundTags.isEmpty()) {
            foundTags.add("General");
        }

        return foundTags.toArray(new String[0]);
    }
}
