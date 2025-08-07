import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		// dp 배열 첫 번째 숫자 : 마지막 집에서 색칠할 색. 그러므로 첫 번째 가격이 무한대로
		// dp 배열 두 번째 숫자 : 현재 몇 번째인가.
		// dp 배열 세 번째 숫자 : 현재 색칠할 색
		int [][][] dp = new int[3][N + 1][3];

		int p0, p1, p2;
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		p0 = Integer.parseInt(st.nextToken());
		p1 = Integer.parseInt(st.nextToken());
		p2 = Integer.parseInt(st.nextToken());
		for (int i = 0; i < 3; i++) {
			dp[i][1][0] = p0;
			dp[i][1][1] = p1;
			dp[i][1][2] = p2;
		}
		dp[0][1][0] = Integer.MAX_VALUE;
		dp[1][1][1] = Integer.MAX_VALUE;
		dp[2][1][2] = Integer.MAX_VALUE;

		for (int i = 2; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			p0 = Integer.parseInt(st.nextToken());
			p1 = Integer.parseInt(st.nextToken());
			p2 = Integer.parseInt(st.nextToken());
			for (int j = 0; j < 3; j++) {
				dp[j][i][0] = Math.min(dp[j][i - 1][1], dp[j][i - 1][2]) + p0;
				dp[j][i][1] = Math.min(dp[j][i - 1][0], dp[j][i - 1][2]) + p1;
				dp[j][i][2] = Math.min(dp[j][i - 1][1], dp[j][i - 1][0]) + p2;
			}
		}
		
		int ans = Integer.MAX_VALUE;
		for (int i = 0; i < 3; i++) {
			ans = Math.min(ans, dp[i][N][i]);
		}

		System.out.println(ans);
	}
}
