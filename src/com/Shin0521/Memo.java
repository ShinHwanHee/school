package com.Shin0521;

import java.io.*;
import java.lang.reflect.Field;
import java.util.Scanner;

public class Memo {

    public static void main(String args[]) throws IOException {
        Scanner scan = new Scanner(System.in);
        String input;
            System.out.println("       메모장");
            System.out.println("==================");
            System.out.println("    1.메모 쓰기");
            System.out.println("    2.메모 읽기");
            System.out.println("    3.메모 삭제");
            System.out.println("    4.종료");
            System.out.println("==================");

            input = scan.nextLine();
            System.out.println("선택한 번호는 " + input + "번 입니다");

            if (input.equals("1")) {

                String text = "Test Message\r\nOK?";

                System.out.print("파일이름을 입력하시오 : ");
                String filename = scan.nextLine();
                FileOutputStream fos = new FileOutputStream(new File("D:/workspace/sch/src/com/notepade/"+filename+".txt"));

                String inputText = "";
                System.out.println("내용을 입력하세요 : ");
                while(true) {
                    inputText = scan.nextLine();
                    if (inputText.equals("exit")) {
                        break;
                    }
                }


               /* fos.write();
                fos.flush(); //버퍼의 내용을 비우는 역할을 한다.
                fos.close();*/

            }





            if(input.equals("4"))
            {
                System.out.println("종료하였습니다");
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
