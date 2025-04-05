package com.danton.documenttagger;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n====== Document Tagger ======");
            System.out.println("1. Generate tags from document");
            System.out.println("2. Save tags to file");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("Enter path to document file: ");
                    String filePath = scanner.nextLine();
                    String content = FileHandler.readFile(filePath);

                    if (content != null) {
                        String[] tags = DocumentProcessor.generateTags(content);
                        System.out.println("\nGenerated Tags:");
                        for (String tag : tags) {
                            System.out.println("- " + tag);
                        }
                        Session.setCurrentTags(tags); // store for later use
                    } else {
                        System.out.println("Failed to read file.");
                    }
                    break;

                case "2":
                    if (Session.hasTags()) {
                        System.out.print("Enter path to save the tags (e.g., C:\\Users\\You\\tags.txt): ");
                        String savePath = scanner.nextLine();
                        boolean success = FileHandler.writeFile(savePath, Session.getCurrentTags());

                        if (success) {
                            System.out.println("Tags saved to file.");
                        } else {
                            System.out.println("Failed to save tags.");
                        }
                    } else {
                        System.out.println("No tags to save. Please generate tags first.");
                    }
                    break;

                case "3":
                    running = false;
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }

        scanner.close();
    }
}
