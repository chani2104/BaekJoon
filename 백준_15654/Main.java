package 백준_15654;

import java.io.*;
import java.util.*;
import java.lang.StringBuffer;

public class Main {

    static int m, n;
    static int [] arr, arr2;
    static boolean [] visit;

    static StringBuffer sb = new StringBuffer();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());

        n = Integer.parseInt(str.nextToken());
        m = Integer.parseInt(str.nextToken());

        arr = new int [n];
        arr2 = new int [m + 1];
        visit = new boolean [n + 1];

        StringTokenizer str2 = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(str2.nextToken());
        }

        Arrays.sort(arr);
        func(0);
        System.out.print(sb);
    }

    private static void func (int a) {
        if (a == m) {
            for (int i = 0; i < m; i++)
                sb.append(arr2[i]).append(" ");
            sb.append("\n");
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (!visit[i]) {
                visit[i] = true;
                arr2[a] = arr[i - 1];
                func(a + 1);
                visit[i] = false;
            }
        }
    }
}

