package 백준_15649;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int [] arr;
    static boolean [] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(rd.readLine(), " ");

        n = Integer.parseInt(str.nextToken());
        m = Integer.parseInt(str.nextToken());
        arr = new int [m + 1];
        visit = new boolean [n + 1];

        backTracking(0);
    }

    static void backTracking(int count) {   // 특정 조건일 때 돌아오게 하는 BackTracking
        if (count == m) {
            for (int i = 0; i < m; i++)
                System.out.print(arr[i] + " ");
            System.out.println();
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (!visit[i]) {
                arr[count] = i;
                visit[i] = true;
                backTracking(count + 1);
                visit[i] = false;
            }
        }
    }
}
