package boj17404_RGB거리2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine()); //집 n개
		int[][] arr = new int[N+1][3];
		int[][] dp = new int[N+1][3];
		
		//비용
		for(int i=1; i<=N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<3; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int ans = Integer.MAX_VALUE;
		
		for(int a=0; a<3; a++) { //첫번째 집 고정
			for(int i=0; i<3; i++) {
				if(i==a) {
					dp[1][i] = arr[1][i];// 첫 집은 a로 고정
				}else {
					dp[1][i] = 1000000000;//나머지 색일 경우, 답이 안되게 큰 값
				}
			}
			
			for(int i=2; i<=N; i++) { //두번째 집부터 ~ 3번째 집 모든 경우
				dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + arr[i][0];
				dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + arr[i][1];
				dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + arr[i][2];
			}
			
			for(int i=0; i<3; i++) {
				//마지막 집, 첫 집 색이 같으면 안됨
				if(i != a) {
					ans = Math.min(ans, dp[N][i]);
				}
			}
		}
		
		bw.write(String.valueOf(ans));
		bw.flush();
	}
}
