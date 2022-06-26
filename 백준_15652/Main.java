package 백준_15652;

import java.io.*;
import java.util.*;
import java.lang.StringBuffer;

public class Main {

    static int m, n;
    static int [] arr;

    static StringBuffer sb = new StringBuffer();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());

        n = Integer.parseInt(str.nextToken());
        m = Integer.parseInt(str.nextToken());

        arr = new int [m];
        func(0, 1);
        System.out.print(sb);
    }

    private static void func (int a, int b) {
        if (a == m) {
            for (int i = 0; i < m; i++)
                sb.append(arr[i]).append(" ");
            sb.append("\n");
            return;
        }

        for (int i = b; i <= n; i++) {
            arr[a] = i;
            func(a + 1, i);
        }
    }
}
