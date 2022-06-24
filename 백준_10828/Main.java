package 백준_10828;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(rd.readLine());
        Stack<Integer> stack = new Stack<>();

        while (num-- > 0) {
            String input = rd.readLine();
            String[] strArr = input.split(" ");
            switch (strArr[0]) {
                case "push" :
                    stack.push(Integer.parseInt(strArr[1]));
                    break;
                case "pop" :
                    if (stack.isEmpty())
                        wr.write(-1 + "\n");
                    else
                        wr.write(stack.pop() + "\n");
                    break;
                case "size" :
                    wr.write(stack.size() + "\n");
                    break;
                case "empty" :
                    if (stack.isEmpty())
                        wr.write(1 + "\n");
                    else
                        wr.write(0 + "\n");
                    break;
                case "top" :
                    if (stack.isEmpty())
                        wr.write(-1 + "\n");
                    else
                        wr.write(stack.peek() + "\n");
                    break;
            }
        }
        wr.flush();
        rd.close();
        wr.close();
    }
}
