package boj18870_좌표압축;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] curr = new int[N];
		int[] sorted = new int[N];
		
		for(int i=0; i<N; i++) {
			int tmp = Integer.parseInt(st.nextToken());
			curr[i] = tmp;
			sorted[i] = tmp;
		}
		
		Arrays.sort(sorted);
		
		Map<Integer, Integer> map = new HashMap<>();
		int cnt = 0;
		for(int n : sorted) {
			if(!map.containsKey(n)) {
				map.put(n, cnt++);
			}
		}
		
		for(int i=0; i<N; i++) {
			bw.write(String.valueOf(map.get(curr[i])) + " ");
		}
		bw.flush();
	}
}
