package com.pathfinder;

import android.support.annotation.NonNull;

import java.util.List;

/**
 * Created by Spoorthi P on 12/21/17.
 */

public class Matrix {

    private final List<List<Integer>> inputMatrix;

    public Matrix(@NonNull List<List<Integer>> inputMatrix) {
        this.inputMatrix = inputMatrix;
    }

    public List<List<Integer>> getInputMatrix() {
        return inputMatrix;
    }

    public int getTotalRows() {
        return inputMatrix.size();
    }

    public int getTotalColumns() {
        return inputMatrix.get(0).size();
    }
}