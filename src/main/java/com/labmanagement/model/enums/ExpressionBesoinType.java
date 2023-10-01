package com.labmanagement.model.enums;

public enum ExpressionBesoinType {
    SMALL_TOOLS_EQUIPMENT_PURCHASE("Markets"),
    COMPUTER_SUPPLIES_PURCHASE("Markets"),
    OFFICE_SUPPLIES_PURCHASE("Markets"),
    RAW_MATERIALS_PURCHASE("Markets"),
    FUEL_PURCHASE("Markets"),
    SCIENTIFIC_EQUIPMENT_PURCHASE("Markets"),
    COMPUTER_EQUIPMENT_PURCHASE("Markets"),
    
    TRAVEL_EXPENSES_ABROAD("Financial"),
    TRAVEL_EXPENSES_IN_COUNTRY("Financial"),
    KILOMETER_ALLOWANCE("Financial"),
    MISSION_EXPENSES_ABROAD("Financial"),
    PARTICIPATION_FEES("Financial");

    private String category;

    ExpressionBesoinType(String category) {
        this.category = category;
    }

    public String getCategory() {
        return category;
    }
}
