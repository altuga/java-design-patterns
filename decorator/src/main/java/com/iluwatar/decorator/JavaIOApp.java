package com.iluwatar.decorator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

public class JavaIOApp {

    private static final Logger LOGGER = LoggerFactory.getLogger(JavaIOApp.class);

    public static void main(String args[]) throws IOException {


        BufferedReader bufferedReader = null;

        try {
            ClassLoader cl = ClassLoader.getSystemClassLoader();
            bufferedReader = new BufferedReader(new InputStreamReader(cl.getResourceAsStream("file.txt")));


            String line = null;
            while((line = bufferedReader.readLine()) != null) {
                LOGGER.info(line);
            }

        } catch (IOException ex) {
            ex.getStackTrace();
        } finally {
            bufferedReader.close();
        }


    }
}
