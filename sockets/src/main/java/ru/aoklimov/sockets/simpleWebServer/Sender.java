package ru.aoklimov.sockets.simpleWebServer;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Sender implements Runnable {

    private final Socket target;
    private String http;

    public Sender(Socket target) {
        this.target = target;
    }

    @Override
    public void run() {
        ClassLoader cl = this.getClass().getClassLoader();
        try {
            String fileName = getFileName();

            URI resource = cl.getResource(fileName).toURI();
            Path filePath = Paths.get(resource);

            Scanner file = new Scanner(Files.newBufferedReader(filePath));
            StringBuilder stringBuilder = new StringBuilder();

            while (file.hasNextLine()) {
                stringBuilder.append(file.nextLine()).append("\n");
            }

            stringBuilder.insert(0, http + " 200 OK\nContent-Type: text/html; " + "charset=utf-8\n\n");

            PrintWriter printWriter = new PrintWriter(target.getOutputStream());
            printWriter.println(stringBuilder.toString());
            printWriter.flush();

            target.close();
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
    }

    private String getFileName() throws IOException {
        Scanner input = new Scanner(target.getInputStream());
        Pattern pattern = Pattern.compile("GET [a-z0-9./]+ HTTP/[0-2.]{3}");
        String header = "";
        Matcher matcher = pattern.matcher(header);

        while (input.hasNextLine() && !matcher.find()) {
            header = input.nextLine();
            matcher = pattern.matcher(header);
        }

        header = matcher.group();
        String url = header.substring(5, header.length() - 9);
        http = header.substring(header.length() - 8);
        return url;
    }
}
