package boj17144_미세먼지안녕;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int R,C,T;
	static int[][] map;
	static int[] purifier;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		
		map = new int[R][C];
		purifier = new int[2];
		
		int idx = 0;
		for(int r=0; r<R; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=0; c<C; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				if(map[r][c] == -1) {
					purifier[idx++] = r; //공기청정기 위치
				}
			}
		}
		
		while(T>0) {
			
			move(); //먼지의 확산
			
			T--;
		}
		
		
	}
	
	static void move() {
		int[][] tmp = new int[R][C];
		
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if(map[i][j] > 0) {
					int dust = map[i][j] / 5;
					int cnt = 0;
					
					for(int k=0; k<4; k++) {
						int nr = i + dr[k];
						int nc = j + dc[k];
						
						if(nr < 0 || nc < 0 || nr >= R || nc >= C || map[nr][nc] == -1) continue;
						
						tmp[nr][nc] += dust;
						cnt++;
					}
					tmp[i][j] -= dust * cnt;
				}
			}
		}
	}
	
}
