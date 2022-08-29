package ch07.socket2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class ClientFile {

    Socket socket;
    BufferedWriter bw;
    BufferedReader br;
    public ClientFile(){
        try {
            System.out.println("1. 클라이언트 소켓 시작 ------------------");
            socket = new Socket("localhost", 10000);  // 14번 라인 실행시 -> 서버소켓의 accept() 메서드가 호출

            System.out.println("2. 버퍼(write) 연결완료 ------------------");
            bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

            // 키보드 연결
            System.out.println("3. 키보드 스트림 + 버퍼(read) 연결완료 -------------------");
            br = new BufferedReader(new InputStreamReader(System.in));

            while(true) {
                System.out.println("4. 키보드 메시지 입력 대기중 -----------------------");
                String keyboardMsg = br.readLine();
                // 메시지 끝은 알려줘야 한다. \n
                bw.write(keyboardMsg + "\n");
                bw.flush(); // 버퍼가 우리가 생각했던 거보다 엄청나게 크다. 그래서 강제로 버퍼를 비워주려고 flush 라는 메서드 호출
            }
        } catch (Exception e) {
            System.out.println("클라이언트 소켓 에러 발생함 : " + e.getMessage());
        }
    }

    public static void main(String[] args) {
       new ClientFile();
    }
}
