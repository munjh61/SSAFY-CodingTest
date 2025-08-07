package boj9663_NQEEN;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	
	static int N;
	static int[][] map;
	static int answer=0;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		//0번째 행부터 시작
		queen(0);
		bw.write(String.valueOf(answer));
		bw.flush();
	}
	
	static void queen(int r) {
		//마지막 행에 도달하면
		if(r == N) {
			answer++;
			return;
		}
		//아직 마지막 행이 아니면
		for(int c=0; c<N; c++) {
			if(check(r, c)) {//퀸 놓기 가능한지 확인
				map[r][c] = 1; //퀸 놓기
				queen(r+1); //다음행으로
				map[r][c] = 0; //원상복귀
				
			}
		}
	}
	
	//퀸 놓을 수 있는지 검사
	static boolean check(int r, int c) {
		//같은 열에 퀸이 있음
		for(int i=0; i<r; i++) {
			if(map[i][c] == 1)
				return false;
		}
		//왼 대각선 -1, -1
		for(int i=1; i<=r && i<=c; i++) {
			if(map[r-i][c-i] == 1)
				return false;
		}
		//오 대각선 -1, +1
		for(int i=1; i<=r && c+i<N; i++) {
			if(map[r-i][c+i] == 1)
				return false;
		}
		
		return true;
	}
	
}
