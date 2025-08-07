package boj12865_평범한배낭;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String input = br.readLine();
		StringTokenizer st = new StringTokenizer(input);
		
		int N = Integer.parseInt(st.nextToken()); //총 물품 수
		int K = Integer.parseInt(st.nextToken()); //버틸 수 있는 최대 무게
		
		int[] weight = new int[N+1];
		int[] value = new int[N+1];
		//0번째는 비워두기
		weight[0]=0;
		value[0]=0;
		
		//몇번째 물품까지 계산한 결과 dp로 저장해서 반복 계산 줄이기
		int[][] dp = new int[N+1][K+1]; //[몇번째 물품까지 확인했는지][담을 수 있는 최대 무게]
		//  0 1 2 3 4 5  6  7
		//0 0 0 0 0 0 0  0  0
		//1 0 0 0 0 0 0  13 13
		//2 0 0 0 0 8 8  13 13
		//3 0 0 0 6 8 8  13 14
		//4 0 0 0 6 8 12 13 14
		
		//dp[0][]를 모두 0으로 초기화. 아무것도 선택안하면 가치가 0
		for(int i=0; i<=K; i++) {
			dp[0][i] = 0;
		}
		
		//weight, value 배열에 저장
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			weight[i] = Integer.parseInt(st.nextToken());
			value[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int k=0; k<=K; k++) {//최댓값 늘려가면서 dp 저장
			for(int i=1; i<=N; i++) {//넣을 물품 순서대로 확인
				
				if(weight[i] > k) {//dp에서 정해진 최댓값보다 크면 가방에 못 넣음
					dp[i][k] = dp[i-1][k]; //전 값을 넣음
				}else {
					//전 dp 값과 전에거에 지금꺼를 더한 dp 값 비교
					//dp[i-1][k-weight[i]] -> i번째 물건을 넣지 않았을 때 낼 수 있는 최대 가치
					dp[i][k] = Math.max(dp[i-1][k], dp[i-1][k-weight[i]] + value[i]);
				}
				
			}
		}
		
		bw.write(String.valueOf(dp[N][K]));
		bw.flush();
	}
}
