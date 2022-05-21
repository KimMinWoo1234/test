package minwoo_202220521;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

         while (true) {

             System.out.println("[메모장]");
             System.out.println("=========================");
             System.out.println("          1. 메모 쓰기");
             System.out.println("          2. 메모 읽기");
             System.out.println("          3. 메모 삭제");
             System.out.println("          4. 종료");
             System.out.println("=========================");
             System.out.print("선택: ");

             String choice = scanner.next();


             if (choice.equals("1")) {
                 writing();

             } else if (choice.equals("2")) {
                 reading();

             } else if (choice.equals("3")) {
                 delete();

             } else if (choice.equals("4")) {
                 System.out.println("시스템을 종료하였습니다.");
                 scanner.close();
                 break;

             } else {
                 System.out.println("1, 2, 3, 4 중 하나를 입력해 주세요.");

             }
        }
    }

    // 1. 메모 쓰기
    public static void writing() throws IOException {

        System.out.println("[메모쓰기]");

        System.out.print("이름: ");
        String name = scanner.next();

        // 이름으로 파일 만들기
        File file = new File("d:\\minwoo\\"+ name +".txt");

        // 파일 존재여부 체크 및 생성
        if (!file.createNewFile()) {
            System.out.println("이미 존재하는 파일입니다 다른이름을 입력해주세요.");
            return;
        }

        System.out.print("중요도(A, B, C): ");
        String severity = scanner.next();

        if (!severity.equals("A") && !severity.equals("B") && !severity.equals("C")) {
            System.out.println("중요도를 대문자 A, B, C 중 하나로 다시 입력해 주세요.");
            return;
        }

        // 파일 쓰기
        FileWriter fw = new FileWriter(file);
        PrintWriter writer = new PrintWriter(fw);

        // 현재 날짜/시간
        Date now = new Date();

        // 포맷팅 정의
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy년 MM월 dd일 HH시 mm분");

        // 포맷팅 적용 (현재시간)
        String formatedNow = formatter.format(now);

        // 중요도, 날짜
        writer.println(severity + ", " + formatedNow);

        // 내용 입력받기 및 쓰기
        System.out.print("내용(exit:입력종료): ");

        while (true) {
            String content = scanner.nextLine();

            if (content.equals("exit")) {
                break;
            } else {
                // 내용 넣기
                writer.println(content);
            }
        }

        // 닫기
        writer.close();

    }

    // 파일 읽기
    public static void reading() throws IOException {

        System.out.println("[메모읽기]");
        System.out.println("[번호]     [이름]     [내용(일부분)]");

        File dir = new File("d:\\minwoo");
        String[] filenames = dir.list();
        
        // 확장자 빼고 가져오기!!!
        
        int number = 0;
        for (String name : filenames) {
            number++;
            System.out.println(number + "          " + name);
        }

        FileReader reader = new FileReader("d:\\minwoo\\1.txt");
        int ch;
        while ((ch = reader.read()) != -1) {
            System.out.print((char) ch);
        }


    }

    public static void delete() {

    }

}