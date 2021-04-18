package com.example.myquiz;

public class UserModel {
    String username;
    String score;

    public UserModel() {
    }

    public UserModel(String username, String score) {
        this.username = username;
        this.score = score;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String  getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }
}
