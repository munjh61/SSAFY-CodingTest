import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int R, C, T;
	static int[][] matrix;
	static int[][] spread;
	static int top = -1;
	static int bottom;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());

		matrix = new int[R][C];

		for (int r = 0; r < R; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < C; c++) {
				matrix[r][c] = Integer.parseInt(st.nextToken());
				if (matrix[r][c] == -1 && top == -1) {
		            top = r;
		        }
			}
		}
		bottom = top + 1;

		// 입력 종료
		int t = 0;
		while (t < T) {
			go();
			t++;
		}
		int sum = 0;
		for (int r = 0; r < R; r++) {
		    for (int c = 0; c < C; c++) {
		        if (matrix[r][c] > 0) sum += matrix[r][c];
		    }
		}
		System.out.println(sum);
	}

	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };

	static void go() {
		spread = new int[R][C];
		// 확산
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				if (matrix[r][c] > 0) {
					int spreadMount = matrix[r][c] / 5;
					int cnt = 0;
					for (int d = 0; d < 4; d++) {
						int nr = r + dr[d];
						int nc = c + dc[d];
						if (bound(nr, nc)) {
							spread[nr][nc] += spreadMount;
							cnt++;
						}
					}
					spread[r][c] -= spreadMount * cnt;
				}
			}
		}
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				matrix[r][c] += spread[r][c];
			}
		}
		// 이동
		// 위쪽(반시계 방향)
		for (int i = top - 1; i > 0; i--) matrix[i][0] = matrix[i - 1][0];
		for (int i = 0; i < C - 1; i++) matrix[0][i] = matrix[0][i + 1];
		for (int i = 0; i < top; i++) matrix[i][C - 1] = matrix[i + 1][C - 1];
		for (int i = C - 1; i > 1; i--) matrix[top][i] = matrix[top][i - 1];
		matrix[top][1] = 0;

		// 아래쪽(시계 방향)
		for (int i = bottom + 1; i < R - 1; i++) matrix[i][0] = matrix[i + 1][0];
		for (int i = 0; i < C - 1; i++) matrix[R - 1][i] = matrix[R - 1][i + 1];
		for (int i = R - 1; i > bottom; i--) matrix[i][C - 1] = matrix[i - 1][C - 1];
		for (int i = C - 1; i > 1; i--) matrix[bottom][i] = matrix[bottom][i - 1];
		matrix[bottom][1] = 0;
		
		matrix[top][0] = -1;
		matrix[bottom][0] = -1;

	}

	static boolean bound(int nr, int nc) {
		if (nr < 0 || nr >= R || nc < 0 || nc >= C || matrix[nr][nc] == -1)
			return false;
		return true;
	}


}
