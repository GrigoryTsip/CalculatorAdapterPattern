package ru.netology;

public class Main {
    public static void main(String[] args) {

        Ints intsCalc = new IntsCalculator();

        System.out.println(intsCalc.sum(234,345));
        System.out.println(intsCalc.mult(34567,867345));
        System.out.println(intsCalc.pow(10, 5));
    }
}