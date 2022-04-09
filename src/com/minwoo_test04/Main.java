package com.minwoo_test04;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int count =  Scanner();

        // 짝수 리스트
        List<Integer> evenList = new ArrayList<Integer>();
        // 홀수 리스트
        List<Integer> oddList = new ArrayList<Integer>();

        System.out.println("입력받을 개수 : " + count);

        for(int i = 0; i <count; i++) {
            int b = Scanner();

            if(b % 2 == 0) {
                System.out.println(b + "는 짝수 입니다.");
                evenList.add(b);
            } else {
                System.out.println(b + "는 홀수 입니다.");
                oddList.add(b);
            }
        }

        System.out.println("짝수는 : " + evenList);
        System.out.println("홀수는 : " + oddList);

        scanner.close();

    }

    public static int Scanner() {

        int count = scanner.nextInt();

        return count;
    }

}
