import java.io.*;
import java.util.*;

public class Main {
    static int[] board = new int[101];
    static int[] dist = new int[101]; // 최소 주사위 수
    static boolean[] visited = new boolean[101];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= 100; i++) {
            board[i] = i;
        }
        
        int special = N + M;
        for (int i = 0; i < special; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            board[from] = to;
        }

        // BFS
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        visited[1] = true;

        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int dice = 1; dice <= 6; dice++) {
                int next = cur + dice;
                if (next > 100) continue;

                next = board[next];
                if (!visited[next]) {
                    visited[next] = true;
                    dist[next] = dist[cur] + 1;
                    q.add(next);
                }
            }
        }

        System.out.println(dist[100]);
    }
}
