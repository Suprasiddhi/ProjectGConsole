/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.projectGC.controller.algorithm;

import com.projectGC.model.ProjectGConsole;
import java.util.List;

/**
 *
 * @LmuID 23048628
 * @author Suprasiddhi
 */
public class BinarySearch {

    public ProjectGConsole searchByName(String searchValue, List<ProjectGConsole> consoleDeviceDetailsList, int left, int right) {
        if (right < left) {
            return null;
        }

        int mid = (left + right) / 2;
        ProjectGConsole midConsole = consoleDeviceDetailsList.get(mid);
        if (midConsole == null || midConsole.getConsoleName() == null) {
            return null; // Handle null object or name
        }

        if (searchValue.toLowerCase().equals(consoleDeviceDetailsList.get(mid).getConsoleName().toLowerCase())) {
            return consoleDeviceDetailsList.get(mid);
        } else if (searchValue.compareToIgnoreCase(consoleDeviceDetailsList.get(mid).getConsoleName()) < 0) {
            return searchByName(searchValue, consoleDeviceDetailsList, left, mid - 1);
        } else {
            return searchByName(searchValue, consoleDeviceDetailsList, mid + 1, right);
        }
    }

}
