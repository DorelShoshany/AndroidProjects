package com.example.androidproject;

import android.location.Location;

public class User {

    public String username;
    public String password;
    public Location location;
    public int points;

    public User() {
        // Default constructor required for calls to DataSnapshot.getValue(com.example.androidproject.User.class)
    }

    public User(String username, String password,Location location,int points) {
        this.username = username;
        this.password = password;
        this.location= location;
        this.points=points;
    }


}
