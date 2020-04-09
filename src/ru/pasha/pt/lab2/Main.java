package ru.pasha.pt.lab2;

public class Main {
    public static void main(String[] args) {
        try{
            new App().run();
        }catch (Exception e){
            System.err.println();
            System.err.println("Great error happened!");
            System.err.println(e.getMessage());
        }
    }
}
