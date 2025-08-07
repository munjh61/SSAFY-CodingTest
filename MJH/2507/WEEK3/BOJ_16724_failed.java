import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16724_failed {

    static int N, M;
    static char[][] matrix;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        matrix = new char[N][M];
        visited = new boolean[N][M];

        for (int r = 0; r < N; r++) {
            matrix[r] = br.readLine().toCharArray();
        }

        int num = 0;
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                if (visited[r][c]) continue;
                bfs(r, c);
                num++;
            }
        }

        System.out.println(num);
    }

    // 상하좌우
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    // 하상우좌
    static char[] opposite = {'D', 'U', 'R', 'L'};

    static class Node {
        int r, c;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static void bfs(int r, int c) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(r, c));
        visited[r][c] = true;

        while (!q.isEmpty()) {
            Node curr = q.poll();

            int nr = curr.r;
            int nc = curr.c;
            switch (matrix[curr.r][curr.c]) {
                case 'U':
                    nr++;
                    break;
                case 'D':
                    nr--;
                    break;
                case 'L':
                    nc--;
                    break;
                default: // 'R'
                    nc++;
                    break;
            }
            if (bound(nr, nc) && !visited[nr][nc]) {
                q.add(new Node(nr, nc));
                visited[nr][nc] = true;
            }

            for (int d = 0; d < 4; d++) {
                int br = curr.r + dr[d];
                int bc = curr.c + dc[d];
                if (bound(br, bc) && matrix[br][bc] == opposite[d] && visited[br][bc]) {
                    q.add(new Node(br, bc));
                    visited[br][bc] = true;
                }
            }
        }
    }

    static boolean bound(int r, int c) {
        if (r < 0 || c < 0 || r >= N || c >= M)
            return false;
        return true;
    }
}
