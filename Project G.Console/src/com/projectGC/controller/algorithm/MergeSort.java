/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.projectGC.controller.algorithm;
import com.projectGC.model.ProjectGConsole;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Defier
 */
public class MergeSort {

 List<ProjectGConsole> ConsolePriceList;
    public MergeSort() {
        ConsolePriceList = new ArrayList<>();
    }

    /**
     * Sorts a list of ProjectGConsole objects by their price in ascending or
     * descending order using selection sort.
     *
     * @param ConsolePriceList the list of ProjectGConsole objects to be sorted
     * @param isDesc specifies the sort order (true for descending, false for
     * ascending)
     * @return the sorted list
     */
    public List<ProjectGConsole> sortByPrice(List<ProjectGConsole> ConsolePriceList, boolean isDesc) {
        this.ConsolePriceList.clear();
        this.ConsolePriceList.addAll(ConsolePriceList);
        if (ConsolePriceList == null || ConsolePriceList.isEmpty()) {
            throw new IllegalArgumentException("Console device detail list cannot be null or empty.");
        }

        for (int i = 0; i < ConsolePriceList.size() - 1; i++) {
            int extremumIndex = findExtremumIndex(ConsolePriceList, i, isDesc);
            if (i != extremumIndex) {
                swap(ConsolePriceList, i, extremumIndex);
            }
        }

        return ConsolePriceList;
    }

    private int findExtremumIndex(List<ProjectGConsole> ConsolePriceList, int startIndex, boolean isDesc) {
        int extremumIndex = startIndex;

        for (int j = startIndex + 1; j < ConsolePriceList.size(); j++) {
            if (shouldSwap(ConsolePriceList.get(j).getPrice(), ConsolePriceList.get(extremumIndex).getPrice(), isDesc)) {
                extremumIndex = j;
            }
        }

        return extremumIndex;
    }

    private boolean shouldSwap(int current, int extremum, boolean isDesc) {
        return isDesc ? current > extremum : current < extremum;
    }

    private void swap(List<ProjectGConsole> ConsolePriceList, int i, int j) {
        ProjectGConsole temp = ConsolePriceList.get(i);
        ConsolePriceList.set(i, ConsolePriceList.get(j));
        ConsolePriceList.set(j, temp);
    }

    /**
     * Sorts a list of ProjectGConsole objects by their price using merge sort.
     *
     * @param ConsolePriceList the list of ProjectGConsole objects to be sorted
     * @param isDesc specifies the sort order (true for descending, false for
     * ascending)
     * @return the sorted list
     */
    public List<ProjectGConsole> mergeSortByPrice(List<ProjectGConsole> ConsolePriceList, boolean isDesc) {
        if (ConsolePriceList == null || ConsolePriceList.isEmpty()) {
            throw new IllegalArgumentException("Console device detail list cannot be null or empty.");
        }
        return mergeSort(ConsolePriceList, isDesc);
    }

    private List<ProjectGConsole> mergeSort(List<ProjectGConsole> list, boolean isDesc) {
        if (list.size() <= 1) {
            return list;
        }

        int mid = list.size() / 2;
        List<ProjectGConsole> left = new ArrayList<>(list.subList(0, mid));
        List<ProjectGConsole> right = new ArrayList<>(list.subList(mid, list.size()));

        left = mergeSort(left, isDesc);
        right = mergeSort(right, isDesc);

        return merge(left, right, isDesc);
    }

    private List<ProjectGConsole> merge(List<ProjectGConsole> left, List<ProjectGConsole> right, boolean isDesc) {
        List<ProjectGConsole> merged = new ArrayList<>();
        int i = 0, j = 0;

        while (i < left.size() && j < right.size()) {
            if (shouldSwap(right.get(j).getPrice(), left.get(i).getPrice(), isDesc)) {
                merged.add(left.get(i));
                i++;
            } else {
                merged.add(right.get(j));
                j++;
            }
        }

        // Add remaining elements
        while (i < left.size()) {
            merged.add(left.get(i));
            i++;
        }

        while (j < right.size()) {
            merged.add(right.get(j));
            j++;
        }

        return merged;
    }
}

