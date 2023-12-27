package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class);
       // checkFileAccess();
    }
    public static void checkFileAccess() {
        Path path = Paths.get("src/main/resources/static/img/bookCovers/1.jpg");
        if (Files.exists(path)) {
            System.out.println("File exists!");
        } else {
            System.out.println("File does not exist.");
        }
    }
}