package test2;

import java.util.Scanner;

public class Smartphone {
    String equipmentStr = "\n\n[ 메뉴";
    String function = "1) 기기정보\n2) 전원 ON\n3) 전원OFF\n";

    Scanner scanner = new Scanner(System.in);

    public int choice() {

        System.out.print("선택>");
        int choice = scanner.nextInt();

        return choice;
    }

    public void deviceInformation() {
        System.out.println("1) 기기정보\n2) 기기변경");
    }

    public void change() {
        System.out.println("1-애플\n2-삼성\n3-샤요미");
    }

    public void search() {
        System.out.print("검색단어> ");
        String str = scanner.next();

        System.out.print("결과=> " + str.length() + "글자 입니다.");

    }
}
