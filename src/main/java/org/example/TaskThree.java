package org.example;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class TaskThree {
    public void print() throws IOException {
        ArrayList wordsList = new ArrayList();
        File file = new File("words.txt");

        try (FileInputStream fis = new FileInputStream(file); Scanner scanner = new Scanner(fis)) {
            while (scanner.hasNext()) {
                wordsList.add((scanner.next()));
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        LinkedHashMap<String, Integer> numbersMap = new LinkedHashMap<>();
        int numbersValue = 0;

        for (int j = 0; j < wordsList.size(); j++) {
            for (int i = 0; i < wordsList.size(); i++) {
                if (wordsList.get(j).equals(wordsList.get(i))) {
                    numbersValue++;
                }
                if (i == wordsList.size() - 1) {
                    numbersMap.put((String) wordsList.get(j), numbersValue);
                    numbersValue = 0;
                    break;
                }
            }
        }

        LinkedHashMap<String, Integer> sortedMap = numbersMap.entrySet()
                .stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new
                ));

        for (Map.Entry<String, Integer> entry : sortedMap.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
