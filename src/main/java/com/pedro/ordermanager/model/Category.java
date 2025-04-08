package com.pedro.ordermanager.model;

import lombok.Getter;

@Getter
public enum Category {
    ELECTRONICS("Electronics"),
    CLOTHING("Clothing"),
    PET("Pet"),
    PC("Pc"),
    FOOD("Food"),
    TOYS("Toys");

    private final String displayName;

    Category(String displayName) {
        this.displayName = displayName;
    }

}