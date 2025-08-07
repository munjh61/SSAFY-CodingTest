import java.io.*;
import java.util.*;

public class Main {
	static final int INF = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		List<Integer> moves = new ArrayList<>();
		while (true) {
			int v = Integer.parseInt(st.nextToken());
			if (v == 0)
				break;
			moves.add(v);
		}
		int n = moves.size();
		// 첫 번째 : 현재
		// 두 번째 : 왼쪽
		// 세 번째 : 오른쪽
		int[][][] dp = new int[n + 1][5][5];
		for (int i = 0; i <= n; i++)
			for (int l = 0; l < 5; l++)
				for (int r = 0; r < 5; r++)
					dp[i][l][r] = INF;

		dp[0][0][0] = 0;

		for (int i = 0; i < n; i++) {
			int next = moves.get(i);
			for (int l = 0; l < 5; l++) {
				for (int r = 0; r < 5; r++) {
					int cur = dp[i][l][r];
					if (cur == INF)
						continue;
					// 왼발이 움직이면
					if (next != r) {
						dp[i + 1][next][r] = Math.min(dp[i + 1][next][r], cur + moveCost(l, next));
					}
					// 오른발이 움직이면
					if (next != l) {
						dp[i + 1][l][next] = Math.min(dp[i + 1][l][next], cur + moveCost(r, next));
					}
				}
			}
		}

		int answer = INF;
		for (int l = 0; l < 5; l++) {
			for (int r = 0; r < 5; r++) {
				answer = Math.min(answer, dp[n][l][r]);
			}
		}
		System.out.println(answer);
	}

	static int moveCost(int from, int to) {
		if (from == to)
			return 1;
		if (from == 0)
			return 2;
		if ((from + to) % 2 == 0)
			return 4; // 반대 방향
		return 3;
	}
}
