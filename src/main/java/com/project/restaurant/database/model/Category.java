package com.project.restaurant.database.model;

import lombok.Getter;

@Getter
public enum Category {
    MENU ("menus"),
    BURGER ("burgers"),
    KEBAB ("kebabs"),
    SHAWARMA ("shawarmas"),
    PIZZA ("pizza"),
    PASTA ("pasta"),
    SAUCE ("sauces"),
    SOUP ("soups"),
    SALAD ("salads"),
    DRINK ("drinks");

    private final String name;

    Category(String name) {
        this.name = name;
    }

    public static Category getCategory(String categoryAsString) {
        for (Category category : Category.values()) {
            if (category.name.equalsIgnoreCase(categoryAsString)) {
                return category;
            }
        }
        return null;
    }
}
