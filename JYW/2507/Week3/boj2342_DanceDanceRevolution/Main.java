package boj2342_DanceDanceRevolution;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	
	static ArrayList<Integer> list;
	static int[][][] dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		//중앙 -> 다른 지점 : 2
		//다른 지점 -> 인접 지점 : 3
		//반대편 : 4
		//같은 지점 : 1
		
		list = new ArrayList<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		while(true) {
			int x = Integer.parseInt(st.nextToken());
			if(x == 0) break;
			list.add(x);
		}
		
		dp = new int[list.size()][5][5];
		int ans = dfs(0,0,0);
		bw.write(String.valueOf(ans));
		bw.flush();
	}
	
	public static int dfs(int idx, int x, int y) {
		if(idx == list.size()) { //모두 처리
			return 0;
		}
		if(dp[idx][x][y] != 0) {
			return dp[idx][x][y];
		}
		
		//좌표 갱신 깊이, 왼, 오
		int left = dfs(idx+1, list.get(idx), y) + move(x, list.get(idx));
		int right = dfs(idx+1, x, list.get(idx)) + move(y, list.get(idx));
		dp[idx][x][y] = Math.min(left, right); //왼쪽, 오른쪽 중 더 작은 값으로
		
		return dp[idx][x][y];
	}
	
	public static int move(int start, int end) {
		if(start == 0) return 2; //처음 시작
		else if(Math.abs(start - end) == 2) return 4; //반대 대각선
		else if(start == end) return 1; //같은 자리
		else return 3; //인접한칸
	}
}
