package org.example;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskOne {
    public String output() throws IOException {
        ArrayList numbersList = new ArrayList();
        File file = new File("file.txt");
        try (FileInputStream fis = new FileInputStream(file); Scanner scanner = new Scanner(fis)) {
            for (int i = 0; scanner.hasNext(); i++) {
                numbersList.add(String.valueOf(scanner.nextLine()));
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        String result = "";

        for (int i = 0; i < numbersList.size(); i++) {
            Pattern pattern = Pattern.compile("\\d{3}-\\d{3}-\\d{4}");
            Matcher matcher = pattern.matcher(String.valueOf(numbersList.get(i)));
            while (matcher.find()) {
                result = result + String.valueOf(numbersList.get(i)).substring(matcher.start(), matcher.end()) + "\n";
            }
        }

        for (int i = 0; i < numbersList.size(); i++) {
            Pattern pattern = Pattern.compile("\\(\\d{3}\\) \\d{3}-\\d{4}");
            Matcher matcher = pattern.matcher(String.valueOf(numbersList.get(i)));
            while (matcher.find()) {
                result = result + String.valueOf(numbersList.get(i)).substring(matcher.start(), matcher.end()) + "\n";
            }
        }
        return result.trim();
    }
}

