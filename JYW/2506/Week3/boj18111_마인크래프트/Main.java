package boj18111_마인크래프트;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	
	static int N,M,B;
	static int[][] map;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		
		int min = Integer.MAX_VALUE;
		int max = 0;
		
		map = new int[N][M];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				min = Math.min(min, map[i][j]);
				max = Math.max(max, map[i][j]);
			}
		}
		
		int time = Integer.MAX_VALUE;
		int height = -1;
		
		//평탄화하려는 높이를 i로 놓고 반복
		for(int i=min; i<=max; i++) {
			int remove=0; //제거 블록 갯수
			int add = 0; //추가 블록 갯수
			
			for(int j=0; j<N; j++) {
				for(int k=0; k<M; k++) {
					int d = map[j][k] - i; //평탄화 기준 높이와 차
					if(d > 0) {
						remove += d;//블록 빼기
					}else{
						add -= d;//블록 넣기
					}
				}
			}
			
			//제거하고 인벤토리에 들어오는 블럭 + 원래 가지고 있는 블럭 >= 설치에 필요한 수
			if(remove + B >= add) {
				int t = remove * 2 + add;
				//속도가 더 빠르거나 속도는 같은데 높이가 더 빠른 경우 갱신
				if(t< time || (t == time && i > height)) {
					time = t;
					height = i;
				}
			}
		}
		
		bw.write(String.valueOf(time)+" "+String.valueOf(height));
		bw.flush();
	}
}
