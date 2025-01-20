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
 * @LmuID 23048628
 * @author Suprasiddhi
 */
public class SelectionSortByName {

    List<ProjectGConsole> ConsoleNameList;

    public SelectionSortByName() {
        ConsoleNameList = new ArrayList<>();
    }

    /**
     * Sorts a list of StudentModel objects by their LMU ID in ascending or
     * descending order.
     *
     * @param ConsoleNameList the list of StudentModel objects to be sorted
     * @param isDesc specifies the sort order (true for descending, false for
     * ascending)
     * @return the sorted list
     */
    public List<ProjectGConsole> sortByName(List<ProjectGConsole> ConsoleNameList, boolean isDesc) {
        this.ConsoleNameList.clear();
        this.ConsoleNameList.addAll(ConsoleNameList);
        if (ConsoleNameList == null || ConsoleNameList.isEmpty()) {
            throw new IllegalArgumentException("Console device detail list cannot be null or empty.");
        }

        for (int i = 0; i < ConsoleNameList.size() - 1; i++) {
            int extremumIndex = findExtremumIndex(ConsoleNameList, i, isDesc);
            if (i != extremumIndex) {
                swap(ConsoleNameList, i, extremumIndex);
            }
        }

        return ConsoleNameList;
    }

    /**
     * Finds the index of the extremum value (minimum or maximum) in the list
     * from the start index.
     *
     * @param studentSortList the list of StudentModel objects
     * @param startIndex the index to start searching from
     * @param isDesc specifies whether to find the maximum (true) or minimum
     * (false)
     * @return the index of the extremum value
     */
    private int findExtremumIndex(List<ProjectGConsole> ConsoleNameList, int startIndex, boolean isDesc) {
        int extremumIndex = startIndex;

        for (int j = startIndex + 1; j < ConsoleNameList.size(); j++) {
            if (shouldSwap(ConsoleNameList.get(j).getConsoleName(), ConsoleNameList.get(extremumIndex).getConsoleName(), isDesc)) {
                extremumIndex = j;
            }
        }

        return extremumIndex;
    }

    /**
     * Determines whether the current value should replace the current extremum
     * based on sort order.
     *
     * @param current the current value
     * @param extremum the current extremum value
     * @param isDesc specifies the sort order (true for descending, false for
     * ascending)
     * @return true if the current value should replace the extremum; false
     * otherwise
     */
    private boolean shouldSwap(String current, String extremum, boolean isDesc) {
        int comparison=current.compareToIgnoreCase(extremum);
        return isDesc ? comparison > 0 : comparison < 0;
    }

    /**
     * Swaps two elements in the list.
     *
     * @param ConsoleNameList the list of StudentModel objects
     * @param i the index of the first element
     * @param j the index of the second element
     */
    private void swap(List<ProjectGConsole> ConsoleNameList, int i, int j) {
        ProjectGConsole temp = ConsoleNameList.get(i);
        ConsoleNameList.set(i, ConsoleNameList.get(j));
        ConsoleNameList.set(j, temp);
    }
}
