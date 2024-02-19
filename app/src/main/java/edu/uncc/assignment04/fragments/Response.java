package edu.uncc.assignment04.fragments;

import android.os.Parcel;
import android.os.Parcelable;

public class Response implements Parcelable {
    private String name;
    private String email;
    private String role;
    public String educationLevel;
    public String maritalStatus;
    public String livingStatus;
    private Integer householdIncome;

    // Default constructor
    public Response() {
    }

    // Parameterized constructor
    public Response(String name, String email, String role, String educationLevel, String maritalStatus, String livingStatus, Integer householdIncome) {
        this.name = name;
        this.email = email;
        this.role = role;
        this.educationLevel = educationLevel;
        this.maritalStatus = maritalStatus;
        this.livingStatus = livingStatus;
        this.householdIncome = householdIncome;
    }

    // Parcelable implementation
    public static final Parcelable.Creator<Response> CREATOR = new Parcelable.Creator<Response>() {
        @Override
        public Response createFromParcel(Parcel in) {
            return new Response(in);
        }

        @Override
        public Response[] newArray(int size) {
            return new Response[size];
        }
    };

    @Override
    public int describeContents() {
        return  0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(email);
        dest.writeString(role);
        dest.writeString(educationLevel);
        dest.writeString(maritalStatus);
        dest.writeString(livingStatus);
        dest.writeValue(householdIncome);
    }

    // Constructor that takes a Parcel and gives you an object populated with its values
    protected Response(Parcel in) {
        name = in.readString();
        email = in.readString();
        role = in.readString();
        educationLevel = in.readString();
        maritalStatus = in.readString();
        livingStatus = in.readString();
        householdIncome = (Integer) in.readValue(Integer.class.getClassLoader());
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
    public String getEducationLevel() {
        return educationLevel;
    }

    // Setter for educationLevel
    public void setEducationLevel(String educationLevel) {
        this.educationLevel = educationLevel;
    }
}

