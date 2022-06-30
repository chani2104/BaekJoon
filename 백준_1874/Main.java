package 백준_1874;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        int num = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();
        int pos = 0;

        while (num-- > 0) {
            int input = Integer.parseInt(br.readLine());
                if (stack.empty()){
                    stack.push(++pos);
                    sb.append("+").append("\n");
                }
                if (stack.peek() == input) {
                    stack.pop();
                    sb.append("-").append("\n");
                    continue;
                } else if (input > stack.peek()) {
                    for (int i = pos + 1; i <= input; i++) {
                        stack.push(i);   // 1 2 3 4
                        sb.append("+").append("\n");
                    }
                    pos = input;    // pos = 4
                } else if (input < stack.peek()) {
                    System.out.print("NO");
                    return;
                }
                stack.pop();
                sb.append("-").append("\n");
        }
        System.out.print(sb);
    }
}
