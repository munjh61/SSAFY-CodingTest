package boj16724_피리부는사나이;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	
	static int N,M,ans;
	static char[][] map;
	static int[][] visited;
	//상,하,왼,오
	static int[] dr= {-1,1,0,0};
	static int[] dc= {0,0,-1,1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new char[N][M];
		visited = new int[N][M];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			map[i] = st.nextToken().toCharArray();
		}
		
		ans = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(visited[i][j] == 0) {
					dfs(i,j);
				}
			}
		}
		
		bw.write(String.valueOf(ans));
		bw.flush();
	}
	static void dfs(int x, int y) {
		visited[x][y] = 1;
		
		int next = direction(x, y);
		int nr = x + dr[next];
		int nc = y + dc[next];
		
		if(visited[nr][nc] == 0) {
			dfs(nr, nc);
		} else if(visited[nr][nc] == 1) {
			ans++; //묶음 발견
		}
		visited[x][y] = 2;
	}
	static int direction(int x, int y) {
		if(map[x][y] == 'U') return 0;
		if(map[x][y] == 'D') return 1;
		if(map[x][y] == 'L') return 2;
		if(map[x][y] == 'R') return 3;
		
		return 4;
	}
}
