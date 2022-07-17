package org.terenin;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Main {

    public static void main(String[] args) {

        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("home/terenin/documents/MyPostgreProj/TrainRegistration/src/main/resources/db.properties"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }



    }

}
