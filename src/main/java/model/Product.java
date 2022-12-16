/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author user
 */
public class Product {
    //variabel string id dan name
    private String id;
    private String name;
    private int price;
    private int number;
    private int total;
    
    //konstruktor untuk melakukan set dan get data
    public String getId(){
        return id;
    }
    public void setId(String id){
        this.id = id;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getTotal() {
        //total = price * number;
        return total;
    }

    public void setTotal() {
        //total = price * number;
        this.total = price * number;
    }
    
    
}
