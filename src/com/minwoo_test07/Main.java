package com.minwoo_test07;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력받기
        String input = sc.next();
        char[] array = input.toCharArray();

        System.out.print("선택해 주세요 홀수, 짝수 : ");
        String choice = sc.next();

        if(choice.equals("홀수")) {
            for(int i = 0; i < input.length(); i++) {
                if(i % 2 != 0) System.out.println(array[i]);
            }
        } else {
            for(int i = 0; i < input.length(); i++) {
                if(i % 2 == 0) System.out.println(array[i]);
            }
        }

        sc.close();
    }

}
