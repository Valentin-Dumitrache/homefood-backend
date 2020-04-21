package com.ethicaltouch.resources;

import java.util.ArrayList;
import java.util.List;

public class Dish {
    private String id;
    private String name;
    private int price;
    private String mainPicture;
    private String description;
    private String cookId;
    private List<String> pictures;
    private List<String> ingredients;
    private Cook cook;

    public Dish() {

    }


    public Dish(Dish dish,
                List<String> pictures,
                List<String> ingredients,
                Cook cook
    ) {
        this.id = dish.id;
        this.name = dish.name;
        this.price = dish.price;
        this.description = dish.description;
        this.cookId = dish.cookId;
        this.mainPicture = dish.mainPicture;
        this.pictures = pictures;
        this.ingredients = ingredients;
        this.cook = cook;
    }

    public Dish(String id,
                String name,
                int price,
                String mainPicture,
                String description,
                String cookId) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.cookId = cookId;
        this.mainPicture = mainPicture;
    }

    public Cook getCook() {
        return cook;
    }

    public void setCook(Cook cook) {
        this.cook = cook;
    }

    public List<String> getPictures() {
        return pictures;
    }

    public void setPictures(ArrayList<String> pictures) {
        this.pictures = pictures;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(ArrayList<String> ingredients) {
        this.ingredients = ingredients;
    }

    public String getId() {
        return id;
    }

    public void setMainPicture(String mainPicture) {
        this.mainPicture = mainPicture;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCookId() {
        return cookId;
    }

    public void setCookId(String cookId) {
        this.cookId = cookId;
    }

    public String getMainPicture() {
        return mainPicture;
    }
}
