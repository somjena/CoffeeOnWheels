package com.example.coffeeonwheels.Domain;



import android.widget.ImageView;

import java.io.Serializable;

public class foodDomain implements Serializable {
    private String title;
    private String pic;
    private String description;
    private int fee;
    private int numberInCart;

    public foodDomain(String title,String pic,String description,int fee) {
        this.title=title;
        this.pic=pic;
        this.description=description;
        this.fee=fee;
    }
    public foodDomain(String title,String pic,String description,int fee,int numberInCart) {
        this.title=title;
        this.pic=pic;
        this.description=description;
        this.fee=fee;
        this.numberInCart=numberInCart;
    }

    public String getTitle(){
        return title;
    }


    public double getFee() {
        return fee;
    }

    public String getPic() {
        return pic;
    }

    public String getDescription() {
        return description;
    }

    public int getNumberInCart() {
        return numberInCart;
    }

    public void setNumberInCart(int numberInCart) {
        this.numberInCart=numberInCart;
    }
}

