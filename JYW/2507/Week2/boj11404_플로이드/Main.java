package boj11404_플로이드;

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
		
		int n = Integer.parseInt(br.readLine()); //도시
		int m = Integer.parseInt(br.readLine()); //버스
		
		int[][] dist = new int[n+1][n+1];
		
		int max = 1000000000;
		
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				dist[i][j] = max;
				if(i==j) {
					dist[i][j] = 0;
				}
			}
		}
		
		for(int i=0; i<m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int finish = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());
			
			dist[start][finish] = Math.min(dist[start][finish], value);
		}
		//다익스트라 x
		//플로이드워셜
		for(int t=1; t<=n; t++) {//들리는 곳
			for(int i=1; i<=n; i++) {
				for(int j=1; j<=n; j++) {
					if(dist[i][t] + dist[t][j] < dist[i][j]) {
						dist[i][j] = dist[i][t] + dist[t][j];
					}
				}
			}
		}
		
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				if(dist[i][j] == max) {
					bw.write("0 ");
				}else {
					bw.write(dist[i][j]+" ");
				}
			}
			bw.write("\n");
		}
		bw.flush();
	}
}
