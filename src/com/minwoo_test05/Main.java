package com.minwoo_test05;

import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String First =  Scanner();
        String Second = Scanner();

        System.out.println(First + " " + Second);

        scanner.close();

    }

    public static String Scanner() {

        String input = scanner.next();

        return input;
    }

}
