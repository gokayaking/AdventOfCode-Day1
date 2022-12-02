package org.example;

import java.util.Collections;
import java.util.List;

public class MyElfUtils {

    public static Integer sumFoodItems( List<Integer> elfFoodItems ) {

        Integer sumFoodItems = 0;

        for (Integer foodItem : elfFoodItems) {
            sumFoodItems += foodItem;
        }

        return sumFoodItems;
    }

    public static Integer parseCalories( String strCurrentLine ) {

        Integer aFoodItem = null;

        try {
            aFoodItem = Integer.parseInt(strCurrentLine);
        }
        catch( Exception anException ) {
            System.out.println( "FAILURE! Failure parsing input:'" + strCurrentLine + "'" );
        }

        return aFoodItem;
    }

    public static void addIfTop3( Integer[] top3Calories, Integer elfTotalCalories ) {

        // 0 is highest
        if (elfTotalCalories > top3Calories[0]) {

            top3Calories[2] = top3Calories[1];
            top3Calories[1] = top3Calories[0];
            top3Calories[0] = elfTotalCalories;
        }

        else if (elfTotalCalories > top3Calories[1]) {

            top3Calories[2] = top3Calories[1];
            top3Calories[1] = elfTotalCalories;
        }

        else if (elfTotalCalories > top3Calories[2]) {

            top3Calories[2] = elfTotalCalories;
        }

        return;
    }
}
