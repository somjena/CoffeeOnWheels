package com.example.coffeeonwheels.Helper;

import android.content.Context;
import android.widget.Toast;

import com.example.coffeeonwheels.Domain.foodDomain;
import com.example.coffeeonwheels.Interface.changeNumberItemsListener;

import java.util.ArrayList;

public class ManagementCart {
    private Context context;
    private TinyDB tinyDB;

    public ManagementCart(Context context){
        this.context=context;
        this.tinyDB=new TinyDB(context);
    }

    public void insertFood(foodDomain item){
        ArrayList<foodDomain> listFood=getListCart();
        boolean existAlready = false;
        int n=0;
        for(int i=0;i<listFood.size();i++){
            if(listFood.get(i).getTitle().equals(item.getTitle())){
                existAlready=true;
                n=i;
                break;
            }
        }
        if(existAlready){
            listFood.get(n).setNumberInCart(item.getNumberInCart());
        }else{
            listFood.add(item);
        }

        tinyDB.putListObject("CartList",listFood);
        Toast.makeText(context,"Added to Your Cart",Toast.LENGTH_SHORT).show();

    }

    public ArrayList<foodDomain> getListCart(){
        return tinyDB.getListObject("CartList");
    }

    public void plusNumberFood(ArrayList<foodDomain>listFood, int position, changeNumberItemsListener changeNumberItemsListener){
        listFood.get(position).setNumberInCart(listFood.get(position).getNumberInCart()+1);
        tinyDB.putListObject("cartList",listFood);
        changeNumberItemsListener.changed();
    }

    public void minusNumberFood(ArrayList<foodDomain> listfood,int position,changeNumberItemsListener changeNumberItemsListener){
        if(listfood.get(position).getNumberInCart()==1){
            listfood.remove(position);
        }else{
            listfood.get(position).setNumberInCart(listfood.get(position).getNumberInCart()-1);
        }
        tinyDB.putListObject("CartList",listfood);
        changeNumberItemsListener.changed();
    }


    public double getTotalFee(){
        ArrayList<foodDomain> listfood=getListCart();
        double fee=0;
        for(int i=0;i<listfood.size();i++){
            fee=fee+(listfood.get(i).getFee()*listfood.get(i).getNumberInCart());
        }
        return fee;
    }
}