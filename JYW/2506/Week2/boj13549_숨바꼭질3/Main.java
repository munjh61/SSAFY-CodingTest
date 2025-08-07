package boj13549_숨바꼭질3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Node{
	int x, time;
	
	Node(int x, int time){
		this.x = x;
		this.time = time;
	}
}

public class Main {
	static int min = Integer.MAX_VALUE;
	static boolean[] visited;
	static int N, K;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String input = br.readLine();
		StringTokenizer st = new StringTokenizer(input);
		
		N = Integer.parseInt(st.nextToken()); //수빈
		K = Integer.parseInt(st.nextToken()); //동생
		
		visited = new boolean[100001];
		
		bfs(N);
		
		bw.write(String.valueOf(min));
		bw.flush();
	}
	
	static void bfs(int tmp) {
		Queue<Node> q = new LinkedList<>();
		q.offer(new Node(tmp, 0)); //시작위치, 시간 큐에 입력
		visited[N] = true; //시작 위치 방문
		
		while(!q.isEmpty()) {
			Node a = q.poll(); //큐에서 하나 꺼내기
			
			//동생 위치에 도달
			//bfs라 먼저 나오는게 가장 빠른 것
			if(a.x == K) {
				min = a.time;
				return;
			}
			//순간이동
			//가장 앞에 놓기(0초 걸리니까)
			if(a.x*2<100001 && !visited[a.x*2]) {
				q.offer(new Node(a.x*2, a.time));
				visited[a.x*2] = true;
			}
			//-1 이동
			if(a.x-1>=0 && !visited[a.x-1]){
                q.offer(new Node(a.x-1, a.time + 1));
                visited[a.x-1] = true;
            }
			//+1 이동
            if(a.x+1<100001 && !visited[a.x+1]){
                q.offer(new Node(a.x+1, a.time + 1));
                visited[a.x+1] = true;
            }
		}
	}
}
