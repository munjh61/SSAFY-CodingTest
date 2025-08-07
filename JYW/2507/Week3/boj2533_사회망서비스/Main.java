package boj2533_사회망서비스;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static boolean[] visited;
	static List<Integer>[] graph;
	static int[][] dp;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		dp = new int[N+1][2];
		visited = new boolean[N+1];
		graph = new ArrayList[N+1];
		
		for(int i=1; i<=N; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for(int i=1; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			graph[start].add(end);
			graph[end].add(start);
		}
		
		dfs(1);
		int ans = Math.min(dp[1][0], dp[1][1]);
		bw.write(String.valueOf(ans));
		bw.flush();
	}
	
	static void dfs(int x) {
		visited[x] = true;
		dp[x][0] = 0;
		dp[x][1] = 1;
		
		for(int num : graph[x]) {
			if(!visited[num]) {
				dfs(num);
				dp[x][0] += dp[num][1];
				dp[x][1] += Math.min(dp[num][0], dp[num][1]);
			}
		}
	}
}
