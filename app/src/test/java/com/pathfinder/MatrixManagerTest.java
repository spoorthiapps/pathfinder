package com.pathfinder;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNull;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

/**
 * Created by Spoorthi P on 12/22/17.
 */
public class MatrixManagerTest {

    @Rule
    public ExpectedException expectedEx = ExpectedException.none();

    @Test
    public void subject_should_return_null_when_y_coordinate_NOT_in_bounds_of_the_matrix() throws Exception {
        Coordinate sampleCoordinate = new Coordinate(2,2);
        ArrayList<List<Integer>> sample1 = new ArrayList<>();
        sample1.add(Arrays.asList(3, 4));
        sample1.add(Arrays.asList(6, 1));
        Matrix matrix = new Matrix(sample1);
        MatrixManager matrixManager = new MatrixManager(matrix);

        Coordinate sameRowNextColumn = matrixManager.findSameRowNextColumn(sampleCoordinate);

        assertEquals(null, sameRowNextColumn);
    }

    @Test
    public void subject_should_return_null_when_x_coordinate_NOT_in_bounds_of_the_matrix() throws Exception {
        Coordinate sampleCoordinate = new Coordinate(6,1);
        ArrayList<List<Integer>> sample1 = new ArrayList<>();
        sample1.add(Arrays.asList(3, 4));
        sample1.add(Arrays.asList(6, 1));
        Matrix matrix = new Matrix(sample1);
        MatrixManager matrixManager = new MatrixManager(matrix);

        Coordinate sameRowNextColumn = matrixManager.findSameRowNextColumn(sampleCoordinate);

        assertEquals(null, sameRowNextColumn);
    }

    @Test
    public void subject_should_return_same_row_next_column_element_when_in_bounds_of_the_matrix() throws Exception {
        Coordinate sampleCoordinate = new Coordinate(1,1);
        ArrayList<List<Integer>> sample1 = new ArrayList<>();
        sample1.add(Arrays.asList(3, 4));
        sample1.add(Arrays.asList(6, 1));
        Matrix matrix = new Matrix(sample1);
        MatrixManager matrixManager = new MatrixManager(matrix);

        Coordinate sameRowNextColumn = matrixManager.findSameRowNextColumn(sampleCoordinate);

        assertEquals(2, sameRowNextColumn.getXCoordinate());
        assertEquals(1, sameRowNextColumn.getYCoordinate());

    }

    @Test
    public void subject_should_return_null_if_next_column_value_is_null() {
        Coordinate sampleCoordinate = new Coordinate(1,1);
        ArrayList<List<Integer>> sample1 = new ArrayList<>();
        sample1.add(Arrays.asList(3, 4));
        sample1.add(Arrays.asList(6, 1));
        Matrix matrix = new Matrix(sample1);
        MatrixManager matrixManager = new MatrixManager(matrix);
        MatrixManager subjectSpy = spy(matrixManager);
        doReturn(null).when(subjectSpy).findSameRowNextColumn(any(Coordinate.class));
        when(subjectSpy.findSameRowNextColumn(any(Coordinate.class))).thenReturn(null);

        Coordinate rowAboveNextColumn = subjectSpy.findRowAboveNextColumn(sampleCoordinate);

        assertNull(rowAboveNextColumn);
    }

    @Test
    public void subject_should_return_valid_above_column_when_there_is_NO_row_above() {
        Coordinate sampleCoordinate = new Coordinate(1,1);
        ArrayList<List<Integer>> sample1 = new ArrayList<>();
        sample1.add(Arrays.asList(3, 4));
        sample1.add(Arrays.asList(6, 1));
        Matrix matrix = new Matrix(sample1);
        MatrixManager matrixManager = new MatrixManager(matrix);

        Coordinate rowAboveNextColumn = matrixManager.findRowAboveNextColumn(sampleCoordinate);

        assertEquals(2, rowAboveNextColumn.getXCoordinate());
        assertEquals(2, rowAboveNextColumn.getYCoordinate());
    }

    @Test
    public void subject_should_return_valid_above_column_when_there_isa_a_valid_row_above() {
        Coordinate sampleCoordinate = new Coordinate(1,2);
        ArrayList<List<Integer>> sample1 = new ArrayList<>();
        sample1.add(Arrays.asList(7, 3));
        sample1.add(Arrays.asList(3, 4));
        sample1.add(Arrays.asList(6, 1));
        Matrix matrix = new Matrix(sample1);
        MatrixManager matrixManager = new MatrixManager(matrix);

        Coordinate rowAboveNextColumn = matrixManager.findRowAboveNextColumn(sampleCoordinate);

        assertEquals(2, rowAboveNextColumn.getXCoordinate());
        assertEquals(1, rowAboveNextColumn.getYCoordinate());
    }

    @Test
    public void subject_should_return_below_row_as_null_if_next_column_value_is_null() {
        Coordinate sampleCoordinate = new Coordinate(1,1);
        ArrayList<List<Integer>> sample1 = new ArrayList<>();
        sample1.add(Arrays.asList(3, 4));
        sample1.add(Arrays.asList(6, 1));
        Matrix matrix = new Matrix(sample1);
        MatrixManager matrixManager = new MatrixManager(matrix);
        MatrixManager subjectSpy = spy(matrixManager);
        doReturn(null).when(subjectSpy).findSameRowNextColumn(any(Coordinate.class));
        when(subjectSpy.findSameRowNextColumn(any(Coordinate.class))).thenReturn(null);

        Coordinate rowAboveNextColumn = subjectSpy.findRowBelowNextColumn(sampleCoordinate);

        assertNull(rowAboveNextColumn);
    }

    @Test
    public void subject_should_return_valid_below_column_when_there_is_a_row_below() {
        Coordinate sampleCoordinate = new Coordinate(1,1);
        ArrayList<List<Integer>> sample1 = new ArrayList<>();
        sample1.add(Arrays.asList(3, 4));
        sample1.add(Arrays.asList(6, 1));
        Matrix matrix = new Matrix(sample1);
        MatrixManager matrixManager = new MatrixManager(matrix);

        Coordinate rowAboveNextColumn = matrixManager.findRowBelowNextColumn(sampleCoordinate);

        assertEquals(2, rowAboveNextColumn.getXCoordinate());
        assertEquals(2, rowAboveNextColumn.getYCoordinate());
    }

    @Test
    public void subject_should_return_valid_below_column_when_there_is_NO_row_below() {
        Coordinate sampleCoordinate = new Coordinate(1,2);
        ArrayList<List<Integer>> sample1 = new ArrayList<>();
        sample1.add(Arrays.asList(3, 4));
        sample1.add(Arrays.asList(6, 1));
        Matrix matrix = new Matrix(sample1);
        MatrixManager matrixManager = new MatrixManager(matrix);

        Coordinate rowAboveNextColumn = matrixManager.findRowBelowNextColumn(sampleCoordinate);

        assertEquals(2, rowAboveNextColumn.getXCoordinate());
        assertEquals(1, rowAboveNextColumn.getYCoordinate());
    }

    @Test
    public void subject_should_return_valid_value_from_coordinates() {
        ArrayList<List<Integer>> sample1 = new ArrayList<>();
        sample1.add(Arrays.asList(3, 4));
        sample1.add(Arrays.asList(6, 1));
        Matrix matrix = new Matrix(sample1);
        MatrixManager matrixManager = new MatrixManager(matrix);

        Coordinate sampleCoordinate = new Coordinate(1,2);
        int result = matrixManager.getValueOfACoordinate(sampleCoordinate);

        assertEquals(6, result);
    }
}