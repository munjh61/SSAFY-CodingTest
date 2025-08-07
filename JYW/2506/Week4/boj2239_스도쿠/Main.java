package boj2239_스도쿠;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	
	static int[] dr = {-1,1,0,0,-1,-1,1,1};
	static int[] dc = {0,0,-1,1,-1,1,-1,1};
	static int[][] map;
	static String ans;
			
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		map = new int[9][9];
		
		for(int i=0; i<9; i++) {
			String line = br.readLine();
			for(int j=0; j<9; j++) {
				map[i][j] = line.charAt(j) - '0';
			}
		}
		
		//9 정사각형 검사 - 중간 기준으로 델타
		//가로, 세로 검사 
		
		check();
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<9; i++) {
			for(int j=0; j<9; j++) {
				sb.append(map[i][j]);
			}
			sb.append('\n');
		}
		ans = sb.toString();
		
		bw.write(ans);
		bw.flush();
	}
	
	static boolean check() {
		for(int i=0; i<9; i++) {
			for(int j=0; j<9; j++) {
				//비어있는 숫자일 경우
				if(map[i][j] == 0) {
					
					for(int num = 1; num<=9; num++) {
						//숫자 확인
						if(isPossible(i,j,num)) {
							map[i][j] = num;
							if(check()) {
								return true;
							}
							map[i][j] = 0;
						}
					}
					//맞는 숫자 없으면 백
					return false;
				}
			}
		}
		return true;
	}
	
	static boolean isPossible(int x, int y, int num) {
		//세로 확인
		for(int i=0; i<9; i++) {
			if(map[x][i] == num) {
				return false;
			}
		}
		//가로 확인
		for(int i=0; i<9; i++) {
			if(map[i][y] == num) {
				return false;
			}
		}
		//9칸 정사각형 확인
		int row = (x/3)*3;
		int col = (y/3)*3;
		
		for(int i=row; i<row+3; i++) {
			for(int j=col; j<col+3; j++) {
				if(map[i][j] == num) {
					return false;
				}
			}
		}
		
		return true;
	}
}
