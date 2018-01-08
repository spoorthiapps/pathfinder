package com.pathfinder;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.List;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;

/**
 * Created by Spoorthi P on 12/22/17.
 */
public class TextParserTest {

    TextParser subject;

    @Rule
    public ExpectedException expectedEx = ExpectedException.none();

    @Before
    public void setUp() throws Exception {
        subject = new TextParser();
    }

    @Test
    public void subject_should_return_non_empty_list_when_a_valid_input_is_entered() throws Exception {
        List<List<Integer>> listOfIntegers = subject.getListOfIntegers("1,2,3,4\n5,6,7,8");

        assertNotNull(listOfIntegers);
    }

    @Test
    public void subject_should_return_list_of_size_two_when_proper_input_is_entered() {
        List<List<Integer>> listOfIntegers = subject.getListOfIntegers("1,2,3,4\n5,6,7,8");

        assertNotNull(listOfIntegers);
        assertEquals(2, listOfIntegers.size());
    }

    @Test
    public void subject_should_return_appropriate_list_contents_when_proper_input_is_entered() {
        List<List<Integer>> listOfIntegers = subject.getListOfIntegers("1,2,3,4\n5,6,7,8");

        assertEquals(new Integer(1), listOfIntegers.get(0).get(0));
        assertEquals(new Integer(2), listOfIntegers.get(0).get(1));
        assertEquals(new Integer(3), listOfIntegers.get(0).get(2));
        assertEquals(new Integer(4), listOfIntegers.get(0).get(3));

        assertEquals(new Integer(5), listOfIntegers.get(1).get(0));
        assertEquals(new Integer(6), listOfIntegers.get(1).get(1));
        assertEquals(new Integer(7), listOfIntegers.get(1).get(2));
        assertEquals(new Integer(8), listOfIntegers.get(1).get(3));
    }

    @Test
    public void subject_should_throw_Empty_Illegal_argument_exception_when_null_input_entered() {
        expectedEx.expect(IllegalArgumentException.class);
        expectedEx.expectMessage("Input cannot be empty!");

        subject.getListOfIntegers(null);
    }

    @Test
    public void subject_should_throw_Empty_Illegal_argument_exception_when_empty_input_entered() {
        expectedEx.expect(IllegalArgumentException.class);
        expectedEx.expectMessage("Input cannot be empty!");

        subject.getListOfIntegers("");
    }

    @Test
    public void subject_should_throw_Non_numeral_Illegal_argument_exception_when_non_numeral_input_entered() {
        expectedEx.expect(IllegalArgumentException.class);
        expectedEx.expectMessage("Non-numerals are not allowed");

        subject.getListOfIntegers("1,a,b,4\n5,6,7,8");
    }


    @Test
    public void subject_should_throw_Non_Equal_Rows_Illegal_argument_exception_when_improper_input_entered() {
        expectedEx.expect(IllegalArgumentException.class);
        expectedEx.expectMessage("Rows should be of same size");

        subject.getListOfIntegers("1,2,3\n5,6,7,8");
    }
}