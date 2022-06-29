package 백준_1966;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        int test = Integer.parseInt(br.readLine());

        while (test-- > 0) {
            StringTokenizer tk = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(tk.nextToken());
            int m = Integer.parseInt(tk.nextToken());
            int count = 0;

            tk = new StringTokenizer(br.readLine());
            LinkedList<Data> list = new LinkedList<>();

            for (int i = 0; i < n; i++) {
                int data = Integer.parseInt(tk.nextToken());
                list.offer(new Data(data, i));
            }
            while (!list.isEmpty()){
                Data head = list.poll();
                boolean notMax = false;

                for (int j = 0; j < list.size(); j++) {
                    int data = list.get(j).data;
                    if (head.data < data) {
                        list.offer(head);
                        notMax = true;
                        break;
                    }
                }
                if (notMax)
                    continue;
                else {
                    count++;
                }

                if (head.index == m)
                    break;
            }
            sb.append(count).append("\n");
        }
        System.out.print(sb);
    }
}

class Data {
    int data, index;

    public Data(int data, int index) {
        this.data = data; this.index = index;
    }
}
