package com.harshit.usingloaders;

/**
 * Created by User on 28-04-2017.
 */

public class Mydata {
    int id;
    private  String text2;
    private  String text1;

    public Mydata(String text1, String text2,int id)
    {
        this.text1=text1;
        this.text2=text2;
        this.id=id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText2() {
        return text2;
    }

    public String getText1() {
        return text1;
    }

    public void setText2(String text2) {
        this.text2 = text2;
    }

    public void setText1(String text1) {
        this.text1 = text1;
    }
}
