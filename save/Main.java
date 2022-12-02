package org.example;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        String fileName = "input/Day1_input.txt";
        FileInputStream inputStream = null;

        try {

            inputStream = new FileInputStream( fileName );

            String data = LoadFile.readFromInputStream( inputStream );

            System.out.println( data );

        }
        catch( Exception anException ) {
            System.out.println( "File:'" + fileName + "' not found! ");
        }

        finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}