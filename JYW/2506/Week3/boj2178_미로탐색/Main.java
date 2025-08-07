package boj2178_미로탐색;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int dr[] = {1,-1,0,0};
	static int dc[] = {0,0,1,-1};
	static boolean[][] visited;
	static int N,M;
	static int[][] map;
	
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
			for(int j=0; j<M; j++) {
				map[i][j] = line.charAt(j) - '0';
			}
		}
		bfs(0,0);
		bw.write(String.valueOf(map[N-1][M-1]));
		bw.flush();
	}
	
	static void bfs(int x, int y) {
		Queue<Point> q = new LinkedList<>();
		visited[x][y] = true;
		q.add(new Point(x,y));
		
		while(!q.isEmpty()) {
			Point tmp = q.poll();
			
			for(int i=0; i<4; i++) {
				int nr = tmp.x + dr[i];
				int nc = tmp.y + dc[i];
				
				if(nr>=N || nc>=M || nr<0 || nc<0) continue;
				
				if (!visited[nr][nc] && map[nr][nc] == 1) {
                    visited[nr][nc] = true;
                    map[nr][nc] = map[tmp.x][tmp.y] + 1; //거리 늘리기
                    q.add(new Point(nr, nc));
                }
			}
		}
	}
	
}
