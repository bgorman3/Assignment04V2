package edu.uncc.assignment04.fragments;

import android.util.Log;

public class Response {
    private String name;
    private String email;
    private String role;
    public String educationLevel;
    public String maritalStatus;
    public String livingStatus;
    private Integer householdIncome;
    // Default constructor
    // Parameterized constructor
    public Response(String name, String email, String role, String educationLevel, String maritalStatus, String livingStatus, int householdIncome) {
        // Initialize the Response object with the provided parameters
        this.name = name;
        this.email = email;
        this.role = role;
        this.educationLevel = educationLevel;
        this.maritalStatus = maritalStatus;
        this.livingStatus = livingStatus;
        this.householdIncome = householdIncome;

        // Log each parameter individually
        Log.d("Response", "Name: " + name);
        Log.d("Response", "Email: " + email);
        Log.d("Response", "Role: " + role);
        Log.d("Response", "Education Level: " + educationLevel);
        Log.d("Response", "Marital Status: " + maritalStatus);
        Log.d("Response", "Living Status: " + livingStatus);
        Log.d("Response", "Household Income: " + householdIncome);
    }



    // Getter for name
    public String getName() {
        return name;
    }

    // Setter for name
    public void setName(String name) {
        this.name = name;
    }

    // Getter for email
    public String getEmail() {
        return email;
    }

    // Setter for email
    public void setEmail(String email) {
        this.email = email;
    }

    // Getter for role
    public String getRole() {
        return role;
    }

    // Setter for role
    public void setRole(String role) {
        this.role = role;
    }


    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    // Getters and setters for livingStatus
    public String getLivingStatus() {
        return livingStatus;
    }

    public void setLivingStatus(String livingStatus) {
        this.livingStatus = livingStatus;
    }

    // Getters and setters for householdIncome
    public int getHouseholdIncome() {
        return householdIncome;
    }

    public void setHouseholdIncome(int householdIncome) {
        this.householdIncome = householdIncome;
    }
}

