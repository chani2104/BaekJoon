package 백준_15651;

import java.io.*;
import java.util.*;
import java.lang.StringBuffer;

public class Main {
    static int n, m;
    static int [] arr;
    static StringBuffer sb = new StringBuffer();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());

        n = Integer.parseInt(str.nextToken());
        m = Integer.parseInt(str.nextToken());

        arr = new int [m + 1];

        func(0);
        System.out.print(sb);
    }

    private static void func(int num) {
        if (num == m) {
            for (int i = 0; i < m; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 1; i <= n; i++) {
            arr[num] = i;
            func(num + 1);
        }
    }
}
