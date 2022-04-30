package minwoo_test02_2;

import java.util.LinkedList;
import java.util.Scanner;

public class LinkedListTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedList<Integer> grades = new LinkedList<Integer>();

        for(int i = 0; i<=5; i++) {
            System.out.print(i + "번째 학생의 성적을 입력해 주세요 : ");
            grades.add(scanner.nextInt());
        }

        grades.set(1, 0);
        grades.set(3, 0);
        grades.set(5, 0);

        System.out.println(grades);

        scanner.close();
    }
}
