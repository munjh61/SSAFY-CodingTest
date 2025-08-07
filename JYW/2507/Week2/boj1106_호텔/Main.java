package boj1106_호텔;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int C = Integer.parseInt(st.nextToken()); //늘려야 하는 사람 수
		int N = Integer.parseInt(st.nextToken()); // 홍보할 수 있는 도시 개수
		
		// DP
		int dp[] = new int[C+101];
		Arrays.fill(dp, 1000000000);
		dp[0] = 0;
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int cost = Integer.parseInt(st.nextToken());
			int people = Integer.parseInt(st.nextToken());
			
			for(int j=people; j<C+101; j++) {
				dp[j] = Math.min(dp[j], cost + dp[j-people]);
			}
		}
		
		//답
		int ans = 1000000000;
		for(int i=C; i<C+101; i++) {
			ans = Math.min(ans, dp[i]);
		}
		bw.write(String.valueOf(ans));
		bw.flush();
	}
}
