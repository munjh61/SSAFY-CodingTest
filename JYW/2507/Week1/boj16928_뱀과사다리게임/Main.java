package boj16928_뱀과사다리게임;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M, cnt;
	static int[] map;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[101];
		visited = new boolean[101];
		
		for(int i=0; i<N+M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			map[a] = b;
		}
		
		bfs(1);
		bw.write(String.valueOf(cnt));
		bw.flush();
	}
	
	static void bfs(int x) {
		Queue<Integer> q = new LinkedList<>();
		q.add(x);
		visited[x] = true;
		
		while(!q.isEmpty()) {
			int size = q.size();
			cnt++;
			
			for(int i=0; i<size; i++) {
				int curr = q.poll();
				
				for(int j=1; j<=6; j++) {
					int next = curr + j;
					if(next > 100) continue;
					
					if(visited[next]) continue;
					
					if(map[next] != 0) {
						next = map[next];
					}
					if(next == 100) return;
					visited[next] = true;
					
					q.add(next);
				}
			}
		}
	}
}
