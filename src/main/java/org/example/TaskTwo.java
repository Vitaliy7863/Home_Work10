package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class TaskTwo {
    public void rewrite() throws IOException {
        String textRead = "";
        File file = new File("file.txt");

        try (FileInputStream fis = new FileInputStream(file); Scanner scanner = new Scanner(fis)) {
            for (int i = 0; scanner.hasNext(); i++) {
                textRead = textRead + scanner.nextLine() + " ";
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        String[] fileTxtArr = textRead.split(" ");
        List<User> userList = new ArrayList<>();
        int ag = 3;
        for (int name = 2; name < fileTxtArr.length; name++) {
            userList.add(new User(fileTxtArr[name], Integer.parseInt(fileTxtArr[ag])));
            name++;
            ag = ag + 2;
        }

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        File userFile = new File("user.json");

        try (FileWriter writer = new FileWriter(userFile, true)) {
            gson.toJson(userList, writer);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}