package com.yacine.collections.utils;

import com.yacine.collections.exceptions.SplitterException;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by meyacine on 18/11/2017.
 */
public class ListSplitterUtilTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void negativeNumberTestShouldThrowSplitterException() throws SplitterException {
        ArrayList<Integer> givenList = new ArrayList<Integer>();
        givenList.add(1);
        thrown.expect(SplitterException.class);
        int givenNumber = -1;
        thrown.expectMessage("The given partitionSize of elements is invalid : " + givenNumber + " Please give a positive value");
        ListSplitterUtil.split(givenList, givenNumber);
    }

    @Test
    public void nullTestShouldReturnNull() throws SplitterException {
        List<List<Integer>> result = ListSplitterUtil.split(null, 2);
        Assert.assertEquals("Case list null : This list should be null", result, null);
    }

    @Test
    public void emptyListTestShouldReturnNull() throws SplitterException {
        List<List<Integer>> result = ListSplitterUtil.split(new ArrayList<Integer>(), 2);
        Assert.assertEquals("Case list empty : This list should be null", result, null);
    }

    @Test
    public void listSmallerSizeTestShouldReturnAListOf() throws SplitterException {
        ArrayList<Integer> givenList = new ArrayList<Integer>();
        givenList.add(1);
        List<List<Integer>> resultList = ListSplitterUtil.split(givenList, 2);

        Assert.assertEquals("Case size < number : This result should be a list containing the given list", new ArrayList<List<Integer>>(Arrays.asList(givenList)), resultList);

        givenList.add(2);
        resultList = ListSplitterUtil.split(givenList, 2);

        Assert.assertEquals("Case size == number : This result should be a list containing the given list", new ArrayList<List<Integer>>(Arrays.asList(givenList)), resultList);
    }

    @Test
    public void listTestShouldReturnList() throws SplitterException {

        List<Integer> givenList = Arrays.asList(1, 2, 3, 4, 5);

        List<Integer> expectedSubList1 = Arrays.asList(1, 2);
        List<Integer> expectedSubList2 = Arrays.asList(3, 4);
        List<Integer> expectedSublist3 = Arrays.asList(5);
        List<List<Integer>> expectedList = new ArrayList<List<Integer>>(Arrays.asList(expectedSubList1, expectedSubList2, expectedSublist3));

        List<List<Integer>> resultList = ListSplitterUtil.split(givenList, 2);

        Assert.assertEquals("Test case with rest of elements : This list should return sublists with 2 elements max", expectedList, resultList);
    }

    @Test
    public void listTestShouldReturnTwoLists() throws SplitterException {

        List<Integer> givenList = Arrays.asList(1, 2, 3, 4, 5);

        List<Integer> expectedSubList1 = Arrays.asList(1, 2, 3);
        List<Integer> expectedSubList2 = Arrays.asList(4, 5);
        List<List<Integer>> expectedList = new ArrayList<List<Integer>>(Arrays.asList(expectedSubList1, expectedSubList2));

        List<List<Integer>> resultList = ListSplitterUtil.split(givenList, 3);

        Assert.assertEquals("Test case with rest of elements : this list should result sublists with 3 elements max", expectedList, resultList);
    }

    @Test
    public void listTestShouldReturnFiveList() throws SplitterException {

        List<Integer> givenList = Arrays.asList(1, 2, 3, 4, 5);

        List<Integer> expectedSubList1 = Arrays.asList(1);
        List<Integer> expectedSubList2 = Arrays.asList(2);
        List<Integer> expectedSubList3 = Arrays.asList(3);
        List<Integer> expectedSubList4 = Arrays.asList(4);
        List<Integer> expectedSubList5 = Arrays.asList(5);
        List<List<Integer>> expectedList = new ArrayList<List<Integer>>(Arrays.asList(expectedSubList1, expectedSubList2, expectedSubList3, expectedSubList4, expectedSubList5));

        List<List<Integer>> resultList = ListSplitterUtil.split(givenList, 1);

        Assert.assertEquals("Test case with 1 element each : This list should be a list of lists of 1 element", expectedList, resultList);
    }
}
