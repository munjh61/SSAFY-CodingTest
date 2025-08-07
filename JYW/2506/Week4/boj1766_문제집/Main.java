package boj1766_문제집;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] indegree = new int[N+1];
		ArrayList<ArrayList<Integer>> rel = new ArrayList<>();
		
		for(int i=0; i<=N; i++) {
			rel.add(new ArrayList<>());
		}
		
		//위상정렬
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int first = Integer.parseInt(st.nextToken());
			int last = Integer.parseInt(st.nextToken());
			
			rel.get(first).add(last);
			indegree[last]++; //last보다 먼저 와야하는 문제의 갯수
		}
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		for(int i=1; i<=N; i++) {
			if(indegree[i] == 0) {
				pq.offer(i);
			}
		}
		
		StringBuilder sb = new StringBuilder();
		while(!pq.isEmpty()) {
			int curr = pq.poll();
			sb.append(curr + " ");
			
			for(int next : rel.get(curr)) {
				indegree[next]--;
				
				if(indegree[next] == 0) {
					pq.offer(next);
				}
			}
		}
		bw.write(sb.toString());
		bw.flush();
	}
}
