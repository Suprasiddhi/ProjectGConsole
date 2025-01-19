/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.projectGC.model;

/**
 * @LmuID 23048628
 * @author Suprasiddhi
 */
public class ProjectGConsole {

    private String consoleName;
    private String brand;
    private String technicalFeature;
    private String additionalFeature;
    private String energyEfficiency;
    private String releaseDate;
    private int price;
    private int quantity;

    public ProjectGConsole(String consoleName, int quantity, String brand, String releaseDate) {
        this.consoleName = consoleName;
        this.quantity = quantity;
        this.brand = brand;
        this.releaseDate = releaseDate;
    }

    public ProjectGConsole(String consoleName, String brand, String technicalFeature, String additionalFeature,
            String energyEfficiency, String releaseDate, int price) {
        this.consoleName = consoleName;
        this.brand = brand;
        this.technicalFeature = technicalFeature;
        this.additionalFeature = additionalFeature;
        this.energyEfficiency = energyEfficiency;
        this.releaseDate = releaseDate;
        this.price = price;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setTechnicalFeature(String technicalFeature) {
        this.technicalFeature = technicalFeature;
    }

    public void setAdditionalFeature(String additionalFeature) {
        this.additionalFeature = additionalFeature;
    }

    public void setEnergyEfficiency(String energyEfficiency) {
        this.energyEfficiency = energyEfficiency;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getTechnicalFeature() {
        return technicalFeature;
    }

    public String getAdditionalFeature() {
        return additionalFeature;
    }

    public String getEnergyEfficiency() {
        return energyEfficiency;
    }

    public int getPrice() {
        return price;
    }

    public String getConsoleName() {
        return consoleName;
    }

    public void setConsoleName(String consoleName) {
        this.consoleName = consoleName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getBrand() {
        return brand;
    }

    public String getReleaseDate() {
        return releaseDate;
    }
}
