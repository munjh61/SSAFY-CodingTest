import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16724 {

    static int N, M;
    static char[][] matrix;
    static int[][] party;
    static int num = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        matrix = new char[N][M];
        party = new int[N][M];

        for (int r = 0; r < N; r++) {
            matrix[r] = br.readLine().toCharArray();
        }

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                if (party[r][c] == 0) {
                    num++;
                    dfsF(r, c);
                    dfsB(r, c);
                }
            }
        }
        System.out.println(num);
    }

    // 상하좌우
    static char[] arrow = {'U', 'D', 'L', 'R'};
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    // 하상우좌 뒤로가기
    static char[] opp = {'D', 'U', 'R', 'L'};

    // 지도 밖으로 나가는 방향의 입력은 주어지지 않는다
//    static boolean bound(int r, int c) {
//        if (r < 0 || c < 0 || r >= N || c >= M)
//            return false;
//        return true;
//    }

    // 앞으로
    static void dfsF(int r, int c) {
        if (party[r][c] != 0) {
            return;
        }

        party[r][c] = num;
        for (int d = 0; d < 4; d++) {
            if (matrix[r][c] == arrow[d]) {
                int nr = r + dr[d];
                int nc = c + dc[d];
                // System.out.println("nr "+nr+", nc "+nc);
                // 지도 밖으로 나가는 방향의 입력은 주어지지 않는다
                dfsF(nr, nc);
            }
        }
    }

    static void dfsB(int r, int c) {
        if (party[r][c] != 0) {
            return;
        }
        party[r][c] = num;
        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];

            if (!bound(nr, nc)) continue;
            if (matrix[nr][nc] == opp[d]) dfsB(nr, nc);
        }
    }

    static boolean bound(int r, int c) {
        if (r < 0 || c < 0 || r >= N || c >= M)
            return false;
        return true;
    }

}
