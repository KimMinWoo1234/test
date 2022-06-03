package com.minwoo_20220521;

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

        File dir = new File("d:\\minwoo");
        String[] filenames = dir.list();

        if(filenames == null) {
            System.out.println("D 드라이브에 minwoo 폴더를 만들어주세요");
            return;
        }

        System.out.println("[메모쓰기]");

        System.out.print("이름: ");
        String name = scanner.next();

        System.out.print("중요도(A, B, C): ");
        String severity = scanner.next();

        if (!severity.equals("A") && !severity.equals("B") && !severity.equals("C")) {
            System.out.println("중요도를 대문자 A, B, C 중 하나로 다시 입력해 주세요.");
            return;
        }

        String lastfile = filenames.length != 0 ? filenames[filenames.length - 1] : "0.txt";

        int saveFileName = Integer.parseInt(lastfile.substring(0, lastfile.length() - 4));

        File file = new File("d:\\minwoo\\"+ (saveFileName + 1) + ".txt");

        // 파일 쓰기
        FileWriter fw = new FileWriter(file);
        PrintWriter writer = new PrintWriter(fw);

        // 현재 날짜/시간
        Date now = new Date();

        // 포맷팅 정의
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy년 MM월 dd일 HH시 mm분");

        // 포맷팅 적용 (현재시간)
        String formatedNow = formatter.format(now);

        // 이름, 중요도, 날짜
        writer.print(name + ", " + severity + ", " + formatedNow + ", ");

        // 내용 입력받기 및 쓰기
        System.out.print("내용(exit:입력종료): ");

        // exit가 나올때까지 내용 넣기
        while (true) {
            String content = scanner.next();

            if (content.equals("exit")) {
                break;
            } else {
                writer.println(content);
            }
        }

        // 닫기
        writer.close();

    }

    // 파일 읽기
    public static void reading() throws IOException {

        System.out.println("[메모읽기]");

        // 파일 리스트 읽어오기 및 파일 선택
        int choice = readList();

        // 예외 처리
        if(choice == 0) {
            return;
        }

        // 선택한 파일 상세보기
        FileReader reader = new FileReader("d:\\minwoo\\" + choice + ".txt");
        BufferedReader buf = new BufferedReader(reader);

        String temp = buf.readLine();

        String[] split = temp.split(",");

        System.out.println("이름   : " + split[0]);
        System.out.println("중요도 : " + split[1]);
        System.out.println("날짜   : " + split[2]);
        System.out.println("내용   : " + split[3]);

        while ((temp = buf.readLine()) != null) {
            System.out.println("         " + temp);
        }

        reader.close();
        buf.close();
    }

    // 파일 삭제
    public static void delete() throws IOException {

        System.out.println("[메모삭제]");

        // 파일 리스트 읽어오기 및 파일 선택
        int choice = readList();

        // 예외 처리
        if(choice == 0) {
            return;
        }

        // 선택한 파일 삭제
        File file = new File("d:\\minwoo\\" + choice + ".txt");

        System.gc();
        if(file.delete()) {

            System.out.println("파일을 삭제하였습니다.");

            // 메모 리스트 읽어오기
            String[] filenames = fileListRead();

            if(filenames == null) {
                return;
            }

            for(int originallName = choice + 1; originallName <= (filenames.length + 1); originallName++) {

                File renameFile = new File("d:\\minwoo\\" + originallName + ".txt");
                renameFile.renameTo(new File("d:\\minwoo\\" + (originallName - 1) + ".txt"));
            }

        } else {
            System.out.println("파일 삭제를 실패하였습니다.");
        }

    }

    // 파일 리스트 읽어오기 및 파일 선택
    public static int readList() throws IOException {

        System.out.println("[번호]     [이름]     [내용(일부분)]");

        // 메모 리스트 읽어오기
        String[] filenames = fileListRead();

        if(filenames == null) {
            return 0;
        }

        for (int number = 1; number <= filenames.length; number++) {

            FileReader reader = new FileReader("d:\\minwoo\\" + number + ".txt");
            BufferedReader buf = new BufferedReader(reader);

            String temp = buf.readLine();

            String[] split = temp.split(",");

            System.out.println(number + "          " + split[0] + "     " + split[3]);

            // 마지막까지 읽고 닫아주기
            if(number == filenames.length) {
                reader.close();
                buf.close();
            }

        }

        System.out.print("파일 번호 선택: ");

        try {
            int choice = scanner.nextInt();

            if(choice <= 0 || filenames.length < choice) {
                throw new Exception();
            }

            return choice;

        } catch (Exception e) {
            System.out.println("없는 파일 입니다.");
        }

        return 0;

    }

    // 메모 리스트 읽어오기
    public static String[] fileListRead() {
        File dir = new File("d:\\minwoo");
        String[] filenames = dir.list();

        if(filenames == null) {
            System.out.println("D 드라이브에 minwoo 폴더를 만들어주세요");
        } else if (filenames.length == 0) {
            System.out.println("메모가 없습니다, 메모를 생성해 주세요");
        } else {
            return filenames;
        }
        return null;
    }

}