package ru.aoklimov.workWithFile;

import ru.aoklimov.organization.Developer;
import ru.aoklimov.organization.Manager;
import ru.aoklimov.organization.User;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class FileEditor {

    public static void write(String fileName, User... users) {
        try {
            FileWriter fw = new FileWriter(fileName, true);
            for (User user : users) {
                fw.append(user.toCSV());
            }
            fw.flush();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<User> read(String fileName) {
        List<User> users = new LinkedList<>();
        try {
            Scanner sc = new Scanner(new FileReader(fileName));
            while (sc.hasNextLine()) {
                String user = sc.nextLine();
                if (user.contains("%")) {
                    Manager manager = new Manager();
                    manager.fromCSV(user);
                    users.add(manager);
                }
                if (user.contains("&")) {
                    Developer developer = new Developer();
                    developer.fromCSV(user);
                    users.add(developer);
                }
            }
            sc.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return users;
    }
}
