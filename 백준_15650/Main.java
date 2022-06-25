package 백준_15650;

import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static boolean [] visit;
    static int [] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(rd.readLine(), " ");
        n = Integer.parseInt(str.nextToken());
        m = Integer.parseInt(str.nextToken());

        arr = new int [m + 1];
        visit = new boolean[n + 1];

        func(0, 1);
    }

    static void func(int num, int pos) {
            if (num == m)  {
                for (int i = 0; i < m; i++) {
                        System.out.print(arr[i] + " ");
                }
                System.out.println();

                return;
            }

        for (int i = pos; i <= n; i++) {
           // if (!visit[i]) {
                arr[num] = i;
              //  visit[i] = true;
                func(num + 1, i + 1);
              //  visit[i] = false;
           // }
        }
    }
}
