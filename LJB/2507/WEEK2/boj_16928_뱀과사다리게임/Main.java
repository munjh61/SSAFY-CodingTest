package boj_16928_뱀과사다리게임;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int[] mapInfo;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int sum = 0;
		while(st.hasMoreTokens()) {
			sum += Integer.parseInt(st.nextToken());
		}
		mapInfo = new int[101];
		visited = new boolean[101];
		
		for(int i=1; i<=100; i++) {
			mapInfo[i] = i;
		}
		
		for(int i=0; i<sum; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			mapInfo[from] = to;
		}
		
		int min = Integer.MAX_VALUE;
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {1, 0});
		while(!q.isEmpty()) {
			int[] info = q.poll();
			int num = info[0];
			int turn = info[1];
			if(num == 100) {
				min = Math.min(min, turn);
			}
			
			for(int i=1; i<=6; i++) {
				int next = num + i;
				if(next<=100 && !visited[next]) {
					visited[next] = true;
					q.add(new int[] {mapInfo[next], turn+1});
				}
			}
		}
		
		System.out.println(min);
	}
}
