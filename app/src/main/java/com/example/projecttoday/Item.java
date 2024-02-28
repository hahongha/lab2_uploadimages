package com.example.projecttoday;

import android.view.View;
import android.widget.CheckBox;

public class Item {
    public int id;
    public String fullName;
    public String phoneNumber;
    public boolean status;

    public String images;

    public CheckBox checkBox;

    public Item(int id, String fullName, String phoneNumber, boolean status, String images){
        this.id = id;
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.status = status;
        this.images = images;
    }
    public Item(int id, String fullName, String phoneNumber, boolean status){
        this.id = id;
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.status = status;
        this.images=null;
    }

    public int getId(){
        return this.id;
    }
    public String getFullName(){
        return this.fullName;
    }
    public String getPhoneNumber(){
        return this.phoneNumber;
    }
    public boolean getStatus(){
        return status;
    }
    public void setStatus(boolean status){
        this.status = status;
    }

    public void setImages(String images){
        this.images = images;
    }

    public String getImages(){
        return this.images;
    }

}
