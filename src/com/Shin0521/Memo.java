package com.Shin0521;

import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Scanner;

public class Memo {

    public static void main(String args[]){
        Scanner scan = new Scanner(System.in);
        String input;



        while (true){
            System.out.println("       메모장");
            System.out.println("==================");
            System.out.println("    1.메모 쓰기");
            System.out.println("    2.메모 읽기");
            System.out.println("    3.메모 삭제");
            System.out.println("    4.종료");
            System.out.println("==================");

            input = scan.nextLine();
            System.out.println("선택한 번호는 " + input + "번 입니다");

            if (input.equals("1"))
            {
                System.out.println("[메모 상세보기]");


            }





            if(input.equals("4"))
            {
                System.out.println("종료하였습니다");
                break;
            }

        }


    }

    public void writeFile(String fileName,int numberCount) {
        FileWriter fileWriter=null;
        BufferedWriter bufferedWriter=null;
        try {
            fileWriter=new FileWriter(fileName);
            bufferedWriter=new BufferedWriter(fileWriter);
            for(int loop=0; loop<+numberCount; loop++) {
                bufferedWriter.write(Integer.toString(loop));
                bufferedWriter.newLine();
            }
            System.out.println("write success"); //이부분까지 수정하면 됨

        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (bufferedWriter!=null) {
                try {
                    bufferedWriter.close();
                } catch (IOException ioe) {
                    ioe.printStackTrace();
                }
            }
        }
        if (fileWriter!=null) {
            try{
                fileWriter.close();
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }
    }
}
