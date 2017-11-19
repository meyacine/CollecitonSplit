package com.yacine.collections.utils;

import com.yacine.collections.exceptions.SplitterException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by meyacine on 18/11/2017.
 */
public abstract class ListSplitterUtil {
    /**
     * Splits Elements of a given list and return a list of sublists of elements
     * Note that negative partitionSize value, will throw a {@link SplitterException}
     *
     * @param list
     * @param partitionSize
     * @return
     * @throws SplitterException
     */
    public static <T extends Object> List<List<T>> split(List<T> list, int partitionSize) throws SplitterException {

        if (partitionSize < 0) {
            throw new SplitterException("The given partitionSize of elements is invalid : " + partitionSize + " Please give a positive value");
        }

        if (list == null || list.size() == 0) {
            return null;
        }

        if (list.size() <= partitionSize || partitionSize == 0) {
            ArrayList<List<T>> lists = new ArrayList<List<T>>();
            lists.add(list);
            return lists;
        }

        List<List<T>> result = new ArrayList<List<T>>();
        List<T> subList = new ArrayList<T>();
        result.add(subList);
        int sublistIndex = 0;

        for (int i = 0; i < list.size(); i++) {
            int currentSublistIndex = i / partitionSize;

            if (sublistIndex != currentSublistIndex) {
                // we start a new sublist
                subList = new ArrayList<T>();
                result.add(subList);

                sublistIndex = currentSublistIndex;
            }

            subList.add(list.get(i));
        }
        return result;
    }
}
