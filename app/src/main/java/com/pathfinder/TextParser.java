package com.pathfinder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Spoorthi P on 12/22/17.
 */


public class TextParser {

    public List<List<Integer>> getListOfIntegers(String userInput) {
        List<List<Integer>> inputList = new ArrayList<>();
        if (userInput == null || userInput.isEmpty()) {
            throw new IllegalArgumentException("Input cannot be empty!");
        } else {
            String[] rows = userInput.split("\n");
            for (int i = 0; i < rows.length; i++) {
                List<Integer> rowList = new ArrayList<>();
                String[] split = rows[i].split(",");
                for (String s : split) {
                    try {
                        rowList.add(Integer.parseInt(s));
                    } catch (NumberFormatException e) {
                        throw new IllegalArgumentException("Non-numerals are not allowed");
                    }
                }
                inputList.add(rowList);
            }
        }

        if (!areAllRowsOfSameLength(inputList)) { throw new IllegalArgumentException("Rows should be of same size");}

        return inputList;
    }


    private boolean areAllRowsOfSameLength( List<List<Integer>> inputList) {
        int baseLineSize = inputList.get(0).size();
        for (List<Integer> integer : inputList) {
            if (integer.size() != baseLineSize) {
                return false;
            }
        }
        return true;
    }

}
