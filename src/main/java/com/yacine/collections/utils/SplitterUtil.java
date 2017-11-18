package com.yacine.collections.utils;

import com.yacine.collections.exceptions.SplitterException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by meyacine on 18/11/2017.
 */
public abstract class SplitterUtil {
    /**
     * Splits Elements of a given list and return a list of sublists of elements
     * Note that negative number value, will throw a {@link SplitterException}
     * @param list
     * @param number
     * @return
     * @throws SplitterException
     */
    public static List<List<?>> split(List<?> list, int number) throws SplitterException {

        if (number < 0) {
            throw new SplitterException("The given number of elements is invalid : " + number + " Please give a positive value");
        }

        if (list == null || list.size() == 0) {
            return null;
        }

        if (list.size() <= number){
            ArrayList<List<?>> lists = new ArrayList<List<?>>();
            lists.add(list);
            return lists;
        }

        List<List<?>> result = new ArrayList<List<?>>();
        List<Object> subList =  new ArrayList<Object>();
        result.add(subList);
        int sublistIndex = 0;

        for (int i = 0; i < list.size(); i++) {
            int currentSublistIndex = i / number;

            if (sublistIndex != currentSublistIndex) {
                // we start a new sublist
                subList = new ArrayList<Object>();
                result.add(subList);

                sublistIndex = currentSublistIndex;
            }

            subList.add(list.get(i));
        }
        return result;
    }
}
