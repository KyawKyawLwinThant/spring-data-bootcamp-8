package org.example;

public class Main {
    public static void main(String[] args) {
        //Product product=new Product("","","","","",5.5,250);
        Product product=new ProductBuilder()
                .create()

                .addVitaminE("E")
                .addVitaminA("CalcA")
                .addName("My Capsule")
                .addVitaminB("B")
                .addVitaminC("C")
                .addVitaminA("A")
                .build();
        System.out.println(product);
    }
}