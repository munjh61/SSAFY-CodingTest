package boj15686_치킨배달;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Node{
	int x, y;
	Node(int x, int y){
		this.x = x;
		this.y = y;
	}
}

public class Main {
	
	static int N,M;
	static int ans = Integer.MAX_VALUE;
	static int[][] map;
	static boolean[] visited;
	static List<Node> home = new ArrayList<>();
	static List<Node> chicken = new ArrayList<>();
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String line = br.readLine();
		StringTokenizer st = new StringTokenizer(line);
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		for(int i=0; i<N; i++) {
			line = br.readLine();
			st = new StringTokenizer(line);
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				
				//home, chicken 배열에 좌표 입력
				if(map[i][j] == 1) {
					home.add(new Node(i, j));
				}else if(map[i][j] == 2) {
					chicken.add(new Node(i, j));
				}
			}
		}
		
		visited = new boolean[chicken.size()];
		
		dfs(0,0);
		bw.write(String.valueOf(ans));
		bw.flush();
	}
	
	public static void dfs(int x, int depth) {
		if(depth == M) {
			int min = calculateDistance();
			ans = Math.min(ans, min);
			return;
		}
		
		//백트래킹
		for(int i=x; i<chicken.size(); i++) {
			if(!visited[i]) {
				visited[i] = true;
				dfs(i+1, depth+1);//다음 치킨집
				visited[i] = false;
			}
		}
	}
	
	public static int calculateDistance() {
		int sum = 0;
		for(Node h : home) {//치킨집과 모든 집 거리 계산
			int distance = Integer.MAX_VALUE;
			
			//선택 된 M개의 치킨 집 중 해당 집과 가장 가까운 치킨집 찾기
			for(int i=0; i<chicken.size(); i++) {
				if(visited[i]) {
					Node c = chicken.get(i);
					int tmp = Math.abs(h.x - c.x) + Math.abs(h.y - c.y);
					distance = Math.min(distance, tmp);
				}
			}
			sum += distance;
		}
		return sum;
	}
	
}
