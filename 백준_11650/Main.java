package 백준_11650;

import java.io.*;
import java.util.*;
import java.lang.*;

public class Main {
    static int n, x, y;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer str = new StringBuffer();

        n = Integer.parseInt(br.readLine());

        List<Point> list = new ArrayList<>();
        // 리스트는 인터페이스이므로 그 함수를 대용할 객체인 배열 리스트로 객체 생성
        // 각 인덱스마다 x, y 좌표가 같이 들어가야 하므로 객체를 넣는 리스트를 사용

        for (int i = 0; i < n; i++) {
            StringTokenizer tok = new StringTokenizer(br.readLine());
            x = Integer.parseInt(tok.nextToken());
            y = Integer.parseInt(tok.nextToken());
            list.add(new Point(x, y));
        }
        Collections.sort(list);

        for (int i = 0; i < n; i++) {
            str.append(list.get(i));
            str.append("\n");
        }
        System.out.print(str);
    }
}

class Point implements Comparable<Point> {  // 객체를 비교할 수 있게 Comparable 을 사용한다.
    int x, y;

    public Point(int x, int y) {
        this.x = x; this.y = y;
    }

    @Override
    public int compareTo(Point p) {
        if (x > p.x) {
            return 1;
        } else if (x == p.x) {
            if (y > p.y)
                return 1;
        }
        return -1;
    }

    @Override
    public String toString() {    // 객체를 출력하기 위해 오버라이딩 하는 오브젝트  메소드
        return (x + " " + y);
    }
}

