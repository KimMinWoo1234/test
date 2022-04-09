package com.minwoo_test06;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력받기
        String input = sc.next();

        // 길이 출력
        System.out.println(input.length());

        // 마지막 글자와 첫글자 출력
        System.out.println(input.substring(0,1));
        System.out.println(input.substring(input.length() - 1, input.length()));

        sc.close();
    }

}
