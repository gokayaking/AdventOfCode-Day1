package org.example;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;


public class Main {

    public static void main(String[] args) {

        String fileName = "/Users/todd/IdeaProjects/AdventOfCode-Day1/input/Day1_input.txt";
        FileInputStream inputStream = null;

        Path path = FileSystems.getDefault().getPath(".").toAbsolutePath();
        System.out.println( "Current path is:'" + path + "'" );

        try {

            Integer maxCalories = 0;

            Integer[] top3Calories = new Integer[3];
            top3Calories[0] = 0;
            top3Calories[1] = 0;
            top3Calories[2] = 0;

            List<Integer> elfFoodItems = new ArrayList<Integer>();

            String strCurrentLine = null;
            BufferedReader reader = new BufferedReader( new FileReader( fileName ) );

            while ((strCurrentLine = reader.readLine()) != null) {

                // System.out.println(strCurrentLine);

                if( MyStringUtils.isBlank( strCurrentLine ) ) {

                    // sum existing elf and add to collection
                    Integer elfTotalCalories = MyElfUtils.sumFoodItems( elfFoodItems );

                    // for top 3
                    MyElfUtils.addIfTop3( top3Calories, elfTotalCalories );

                    // for top 1
                    if( elfTotalCalories > maxCalories ) {
                        maxCalories = elfTotalCalories;
                    }

                    // create new collection
                    elfFoodItems = new ArrayList();
                }
                else {

                    Integer aFoodItem = MyElfUtils.parseCalories( strCurrentLine );

                    if( aFoodItem != null ) {
                        // System.out.println("For string:'" + strCurrentLine + "' aFoodItem:'" + aFoodItem + "'");
                        elfFoodItems.add(aFoodItem);
                    }
                    else {
                        System.out.println( "FAILURE! Parsing string:'" + strCurrentLine + "'" );
                    }
                }
            }

            System.out.println( "Max calories:'" + maxCalories + "'"  );

            Integer totalTop3Calories = top3Calories[0] + top3Calories[1] + top3Calories[2];
            System.out.println( "Top 1 calories:'" + top3Calories[0] + "'"  );
            System.out.println( "Top 2 calories:'" + top3Calories[1] + "'"  );
            System.out.println( "Top 3 calories:'" + top3Calories[2] + "'"  );
            System.out.println( "Total Top 3 calories:'" + totalTop3Calories + "'"  );
        }
        catch( FileNotFoundException anException ) {
            System.out.println( "FAILURE! File:'" + fileName + "' not found! ");
        }
        catch( Exception anException ) {
            System.out.println( "FAILURE! Due to exeption:'" + anException.toString() + "'" );
        }
    }
}