package boj_16724_피리부는사나이;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M;
	public static void main(String[] args) throws IOException {
		// 상 하 좌 우
		int[] dx = {0, 0, -1, 1}, dy = {-1, 1, 0, 0};
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		char[][] map = new char[N][M];
		boolean[][] visited = new boolean[N][M];
		int cnt = 0;
		for(int i=0; i<N; i++) {
			char[] arr = br.readLine().toCharArray();
			map[i] = arr;
		}
		
		Queue<int[]> q = new LinkedList<>();
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(!visited[i][j]) {
					visited[i][j] = true;
					cnt++;
					q.add(new int[] {j, i});
					
					while(!q.isEmpty()) {
						int[] info = q.poll();
						int x = info[0];
						int y = info[1];
						int nextD = map[y][x];
						int nx = x, ny = y;
						
						switch (nextD) {
							case 'U': 
								ny -= 1;
								break;
							case 'D': 
								ny += 1;
								break;
							case 'L': 
								nx -= 1;
								break;
							case 'R': 
								nx += 1;
								break;
						}
						if(!visited[ny][nx]) {
							visited[ny][nx] = true;
							q.add(new int[] {nx, ny});
						}
						
						for(int d = 0; d < 4; d++) {
							int nnx = x + dx[d];
							int nny = y + dy[d];
							if(bound(nnx, nny)) {
								int dd = map[nny][nnx];
								boolean flag = false;
								switch (d) {
								case 0: 
									flag = dd == 'D';
									break;
								case 1:
									flag = dd == 'U';
									break;
								case 2: 
									flag = dd == 'R';
									break;
								case 3: 
									flag = dd == 'L';
									break;
								}
								if(flag && !visited[nny][nnx]) {
									visited[nny][nnx] = true;
									q.add(new int[] {nnx, nny});
								}
							}
						}
					}
				}
			}
		}
		System.out.println(cnt);
	}
	static boolean bound(int x, int y) {
		return x >= 0 && y >= 0 && x < M && y < N;
	}
}
