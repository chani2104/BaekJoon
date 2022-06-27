package 백준_11651;

import java.io.*;
import java.util.*;
import java.lang.*;

public class Main {
    static int n, x, y;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer str = new StringBuffer();
        Point point = new Point();
        n = Integer.parseInt(br.readLine());
        List<Point> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer tok = new StringTokenizer(br.readLine());
            x = Integer.parseInt(tok.nextToken());
            y = Integer.parseInt(tok.nextToken());
            list.add(new Point(x, y));
        }

        Collections.sort(list, point);

        for (int i = 0; i < n; i++) {
            str.append(list.get(i));
            str.append("\n");
        }
        System.out.print(str);
    }
}

    class Point implements Comparator<Point> {  // 단발성 정렬을 위한 인터페이스 -> 익명 클래스가 유리
        int x, y;

        public Point(int x, int y) {
            this.x = x; this.y = y;
        }

        public Point() {
            return;
        }

        @Override
        public int compare(Point p1, Point p2) {
            if (p1.y > p2.y) {
                return 1;
            }
            else if (p1.y == p2.y) {
                if (p1.x > p2.x)
                    return 1;
            }
            return -1;
        }

        @Override
        public String toString() {
            return (x + " " + y);
        }
    }

