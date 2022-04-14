package com.minwoo_test01;

import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    static String choice;
    static int num1;
    static int num2;

    public static void main(String[] args) {

        // 0을 입력하기 전까지 무한반복
        while (true) {

            System.out.print("종료 = 0, 더하기 = 1, 빼기 = 2, 곱하기 = 3, 나누기 = 4 : ");
            choice = scanner.next();

            switch (choice) {
                case "0":
                    System.out.println("시스템을 종료하였습니다.");
                    scanner.close();
                    return;
                case "1":
                    Input();
                    System.out.println(num1 + num2);
                    break;
                case "2":
                    Input();
                    System.out.println(num1 - num2);
                    break;
                case "3":
                    Input();
                    System.out.println(num1 * num2);
                    break;
                case "4":
                    Input();
                    System.out.println(num1 / num2);
                    break;
                default:
                    System.out.println("올바른 숫자를 입력해 주세요");
                    break;
            }
        }
    }

    // 입력 받기
    public static void Input() {

        System.out.print("첫번째 숫자를 입력해 주세요 : ");
        num1 = scanner.nextInt();

        System.out.print("두번째 숫자를 입력해 주세요 : ");
        num2 = scanner.nextInt();

    }
}
