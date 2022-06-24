package 백준_10845;

import java.io.IOException; //
import java.io.BufferedReader; // 문자열을 버퍼 형식으로
// Stream - 시냇물처럼 데이터가 흐르는 형식 -> 문자 스트림과 바이트 스트림으로 나뉨
// 문자스트림 -> Reader / Writer  바이트 스트림 -> InputStream / OutputStream
// Buffered : 어떤 버퍼를 사용하여 받아올 것인가
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList; // 클래스
import java.util.Queue; // 인터페이스 - 구현이 필요하다

public class Main {

    //Queue<Integer> queue = new LinkedList<>();
    // 인터페이스 형식인 Queue의 함수를 쓰는 인스턴스를 만들기 위해 LinkedList 사용 -> 업캐스팅
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        // System.in 은 바이트 단위로 읽어들임 (바이트 스트림) -> InputStream을 문자열 형식으로 변경 -> Buffered Reader로 읽어옴
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

        Queue<Integer> queue = new LinkedList<>();
        int cmd = Integer.parseInt(rd.readLine());
        int cnt = 0;
        while (cmd-- > 0) {
            String input = rd.readLine();
            String[] strArr = input.split(" ");   // : 공백을 기준으로 배열로 나누어서 대입 (Without API)
            switch (strArr[0]){
                case "push" :
                    queue.offer(Integer.parseInt(strArr[1]));
                    cnt = Integer.parseInt(strArr[1]);
                    break;
                case "pop" :
                    if (queue.isEmpty())
                        wr.write(-1 + "\n");
                    else
                        wr.write(queue.poll() + "\n");
                    break;
                case "size" :
                    wr.write(queue.size() + "\n");    // 컬렉션 메소드 size(), 문자열 length(), 배열 length
                    break;
                case "empty" :
                    if (queue.isEmpty())
                        wr.write(1 + "\n");
                    else
                        wr.write(0 + "\n");
                    break;
                case "front" :
                    if (queue.isEmpty())
                        wr.write(-1 + "\n");
                    else
                        wr.write(queue.peek() + "\n"); // peek 으로 가장 첫 원소 출력
                    break;
                case "back" :
                    if (queue.isEmpty())
                        wr.write(-1 + "\n");
                    else
                        wr.write(cnt + "\n");
                    break;
            }
        }
        wr.flush(); // Buffered Writer를 사용할 때는 flush를 사용해야 함
        wr.close();
        rd.close();
    }
}