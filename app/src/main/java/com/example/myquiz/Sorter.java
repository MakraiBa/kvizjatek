package com.example.myquiz;

import java.util.Comparator;

public class Sorter implements Comparator<UserModel> {
    @Override
    public int compare(UserModel o1, UserModel o2) {
        return o2.getScore().compareTo(o1.getScore());
    }
}
