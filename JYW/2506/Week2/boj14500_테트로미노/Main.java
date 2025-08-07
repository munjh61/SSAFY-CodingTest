package boj14500_테트로미노;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	
	static int max = Integer.MIN_VALUE;
	static int[][] map;
	static boolean[][] visited;
	static int N, M, ans;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String line = br.readLine();
		StringTokenizer st = new StringTokenizer(line);
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		visited = new boolean[N][M];
		
		for(int i=0; i<N; i++) {
			line = br.readLine();
			st = new StringTokenizer(line);
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int r=0; r<N; r++) {
			for(int c=0; c<M; c++) {
				visited[r][c] = true;
				block(r, c, 1, map[r][c]);
				visited[r][c] = false;
			}
		}
		
		bw.write(String.valueOf(ans));
		bw.flush();
	}
	
	static void block(int r, int c, int cnt, int sum) {
		//백트래킹 종료
		if(cnt == 4) {
			ans = Math.max(ans, sum);
			return;
		}
		
		for(int i=0; i<4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			
			if(!bound(nr, nc)) continue;
			if(visited[nr][nc]) continue;
			
			//이상하게 생긴 거일 경우 ㅜ
			if(cnt ==2) {
				visited[nr][nc] = true;
				//두번째 칸에서 백트래킹 다시 시작할 수 있게
				//like 준호오빠 멀티버스
				block(r, c, cnt+1, sum + map[nr][nc]);
				visited[nr][nc] = false;
			}
			
			visited[nr][nc] = true;
			block(nr, nc, cnt+1, sum + map[nr][nc]);
			visited[nr][nc] = false;
		}
	}
	
	static boolean bound(int r, int c) {
		if(r<0 || c<0 || r>=N || c>=M)
			return false;
		
		return true;
	}
	
}
