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
public class InsertionSort {

    List<ProjectGConsole> QuantityList;

    public InsertionSort() {
        QuantityList = new ArrayList<>();
    }

    /**
     * Sorts a list of ProjectGConsole objects by their company ID in ascending or
     * descending order using insertion sort.
     *
     * @param QuantityList the list of ProjectGConsole objects to be sorted
     * @param isDesc specifies the sort order (true for descending, false for
     * ascending)
     * @return the sorted list
     */
    public List<ProjectGConsole> sortByQuantity(List<ProjectGConsole> QuantityList, boolean isDesc) {
        if (QuantityList == null || QuantityList.isEmpty()) {
            throw new IllegalArgumentException("Ordered List cannot be null or empty.");
        }

        for (int i = 1; i < QuantityList.size(); i++) {
            ProjectGConsole current = QuantityList.get(i);
            int j = i - 1;

            // Shift elements based on the sort order
            while (j >= 0 && shouldSwap(current.getQuantity(), QuantityList.get(j).getQuantity(), isDesc)) {
                QuantityList.set(j + 1, QuantityList.get(j));
                j--;
            }

            // Place the current element in its correct position
            QuantityList.set(j + 1, current);
        }

        return QuantityList;
    }

    private boolean shouldSwap(int current, int previous, boolean isDesc) {
        return isDesc ? current > previous : current < previous;
    }
}
