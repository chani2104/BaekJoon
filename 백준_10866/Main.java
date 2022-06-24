package 백준_10866;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        Deque<Integer> deque = new LinkedList<>();

        int num = Integer.parseInt(rd.readLine());

        while (num-- > 0) {
            StringTokenizer str = new StringTokenizer(rd.readLine(), " ");
            switch (str.nextToken()) {
                case "push_front" :
                    deque.offerFirst(Integer.parseInt(str.nextToken()));
                    break;
                case "push_back" :
                    deque.offerLast(Integer.parseInt(str.nextToken()));
                    break;
                case "pop_front" :
                    if (deque.isEmpty())
                        System.out.println(-1);
                    else
                        System.out.println(deque.pollFirst());
                    break;
                case "pop_back" :
                    if (deque.isEmpty())
                        System.out.println(-1);
                    else
                        System.out.println(deque.pollLast());
                    break;
                case "size" :
                    System.out.println(deque.size());
                    break;
                case "empty" :
                    if (deque.isEmpty())
                        System.out.println(1);
                    else
                        System.out.println(0);
                    break;
                case "front" :
                    if (deque.isEmpty())
                        System.out.println(-1);
                    else
                        System.out.println(deque.peekFirst());
                    break;
                case "back" :
                    if (deque.isEmpty())
                        System.out.println(-1);
                    else
                        System.out.println(deque.peekLast());
            }
        }
        rd.close();
    }
}
