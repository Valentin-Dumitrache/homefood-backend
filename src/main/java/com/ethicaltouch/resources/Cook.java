package com.ethicaltouch.resources;

import java.util.ArrayList;

public class Cook {
    private String id;
    private String firstName;
    private String lastName;
    private String city;
    private String county;
    private String description;
    private String coverPicture;
    private String profilePicture;
    private String phoneNumber;
    private ArrayList<Dish> dishes;

    public Cook() {

    }
    public Cook(String id,
                String firstName,
                String lastName,
                String city,
                String county,
                String description,
                String coverPicture,
                String profilePicture,
                String phoneNumber,
                ArrayList<Dish> dishes) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.city = city;
        this.county = county;
        this.description = description;
        this.coverPicture = coverPicture;
        this.profilePicture = profilePicture;
        this.phoneNumber = phoneNumber;
        this.dishes = dishes;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCoverPicture() {
        return coverPicture;
    }

    public void setCoverPicture(String coverPicture) {
        this.coverPicture = coverPicture;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public ArrayList<Dish> getDishes() {
        return dishes;
    }

    public void setDishes(ArrayList<Dish> dishes) {
        this.dishes = dishes;
    }
}
