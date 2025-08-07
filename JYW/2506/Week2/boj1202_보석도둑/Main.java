package boj1202_보석도둑;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node implements Comparable<Node>{
	int weight, cost;
	public Node(int weight, int cost) {
		this.weight = weight;
		this.cost = cost;
	}
	@Override
	public int compareTo(Node o) {
		return this.weight - o.weight; //무게 기준 오름차순
	}
}

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String line = br.readLine();
		StringTokenizer st = new StringTokenizer(line);
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		//보석
		Node[] jewel = new Node[N];
		for(int i=0; i<N; i++) {
			line = br.readLine();
			st = new StringTokenizer(line);
			
			int weight = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			jewel[i] = new Node(weight, cost);
		}
		
		//가방
		int[] bag = new int[K];
		for(int i=0; i<K; i++) {
			line = br.readLine();
			bag[i] = Integer.parseInt(line);
		}
		
		//무게, 가방 오름차순으로 정렬
		Arrays.sort(jewel);
		Arrays.sort(bag);
		
		//내림차순으로 정렬 - 최댓갑 찾기
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		long total = 0;
		int k = 0;
		
		for(int i=0; i<K; i++) {
			int capa = bag[i];
			
			while(k<N && jewel[k].weight <= capa) {
				pq.offer(jewel[k].cost); //넣을 수 있는 보석을 모두 넣기
				k++;
			}
			
			if(!pq.isEmpty()) {
				total += pq.poll();//가능한 보석 중 가장 값이 큰 보석
			}
		}
		
		bw.write(String.valueOf(total));
		bw.flush();
		
		
	}
}
