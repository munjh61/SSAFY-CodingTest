package boj_11404_플로이드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	static int n, m, INF = Integer.MAX_VALUE;
	static List<Node>[] adj;
	static int[][] dist; 
	
	static class Node implements Comparable<Node> {
		public Node(int end, int cost) {
			this.end = end;
			this.cost = cost;
		}
		int end, cost;
		@Override
		public int compareTo(Node o) {
			return this.cost-o.cost;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		
		adj = new ArrayList[n+1];
		
		for(int i=1; i<=n; i++) {
			adj[i] = new ArrayList<>();
		}
		
		dist = new int[n+1][n+1];
		for(int i=1; i<=n; i++) {
			Arrays.fill(dist[i], INF);
		}
		StringTokenizer st = null;
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			adj[from].add(new Node(to, cost));
		}
		
		for(int i=1; i<=n; i++) {
			dijkstra(i);
		}
		StringBuilder sb = new StringBuilder();
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				if(i == j) {
					sb.append(0);
				} else {
					sb.append(dist[i][j] == INF ? 0 : dist[i][j]);
				}
				sb.append(" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
		
	}
	static void dijkstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
        dist[start][start] = 0;
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            int now = cur.end;
            int cost = cur.cost;

            if (dist[start][now] < cost) continue;

            for (Node next : adj[now]) {
                if (dist[start][next.end] > cost + next.cost) {
                    dist[start][next.end] = cost + next.cost;
                    pq.offer(new Node(next.end, dist[start][next.end]));
                }
            }
        }
		
	}
}






















