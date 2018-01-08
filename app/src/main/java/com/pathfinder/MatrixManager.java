package com.pathfinder;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Created by Spoorthi P on 12/21/17.
 */

public class MatrixManager {

    private final Matrix matrix;

    public MatrixManager(@NonNull Matrix matrix) {
        this.matrix = matrix;
    }

    @Nullable
    public Coordinate findSameRowNextColumn(Coordinate coordinate) {
        if (matrix.getTotalRows() > (coordinate.getYCoordinate() - 1) &&
                (coordinate.getXCoordinate() + 1 <= matrix.getInputMatrix().get(coordinate.getYCoordinate() - 1).size())) {
            final Coordinate adjacentCoordinate = new Coordinate(coordinate.getXCoordinate() + 1,
                    coordinate.getYCoordinate());
            return adjacentCoordinate;
        }
        return null;
    }

    @Nullable
    public Coordinate findRowAboveNextColumn(Coordinate coordinate) {
        Coordinate adjacentCoordinate = findSameRowNextColumn(coordinate);
        if (adjacentCoordinate != null) {
            int yCoordinate = coordinate.getYCoordinate() - 1;
            Coordinate rowAboveCoordinate = new Coordinate(adjacentCoordinate.getXCoordinate(),
                    yCoordinate == 0 ? matrix.getInputMatrix().size() : yCoordinate);
            return rowAboveCoordinate;
        }
        return null;
    }

    @Nullable
    public Coordinate findRowBelowNextColumn(Coordinate coordinate) {
        Coordinate adjacentCoordinate = findSameRowNextColumn(coordinate);
        if (adjacentCoordinate != null) {
            int yCoordinate = coordinate.getYCoordinate() + 1;
            Coordinate rowBelowCoordinate = new Coordinate(adjacentCoordinate.getXCoordinate(),
                    yCoordinate > matrix.getInputMatrix().size() ? 1 : yCoordinate);
            return rowBelowCoordinate;
        }
        return null;
    }

    public Matrix getMatrix() {
        return matrix;
    }

    public int getValueOfACoordinate(Coordinate coordinate) {
        return matrix.getInputMatrix().get(coordinate.getYCoordinate() - 1).get(coordinate.getXCoordinate() - 1);
    }

}
