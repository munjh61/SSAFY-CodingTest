package boj_17144_미세먼지안녕;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int R, C, T, topR, botR;
	static int[][] nowMap, nextMap;
	static int[] dx = { 1, 0, -1, 0 }, dy = { 0, -1, 0, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		topR = -1;
		botR = -1;
		nowMap = new int[R][C];
		nextMap = new int[R][C];
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				int stat = Integer.parseInt(st.nextToken());
				nowMap[i][j] = stat;
				if (stat == -1) {
					if (topR != -1) {
						botR = i;
						continue;
					}
					topR = i;
				}
			}
		}

		// T초 동안
		while (T-- > 0) {
			// 확산
			diffusion();
			// 정화
			purifying();
			nowMap = nextMap;
			nextMap = new int[R][C];
		}
		System.out.println(getSum());
	}

	static void diffusion() {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				int dust = nowMap[i][j];
				if (dust > 0) {
					int split = dust / 5;
					int diffCnt = 0;
					for (int d = 0; split > 0 && d < 4; d++) {
						int nx = j + dx[d];
						int ny = i + dy[d];
						if (bound(nx, ny) && !chkMachine(nx, ny)) {
							nextMap[ny][nx] += split;
							diffCnt++;
						}
					}
					nextMap[i][j] += (dust - (split * diffCnt));
				}
			}
		}
		
	}

	static void purifying() {
		// topR
		int d = 0;
		int before = 0;
		int after = 0;
		int row = topR;
		int col = 1;
		topLoop: 
		while (true) {
			if(row == topR && col == 0) {
				break topLoop;
			}
			after = nextMap[row][col]; 
			nextMap[row][col] = before;
			for(; d<4; d++) {
				int nR = row + dy[d];
				int nC = col + dx[d];
				if(bound(nC, nR)) {
					row = nR;
					col = nC;
					break;
				}
			}
			before = after;
		}

		// botR
		d = 0;
		before = 0;
		after = 0;
		row = botR;
		col = 1;
		botLoop:
		while(true) {
			if(row == botR && col == 0) {
				break botLoop;
			}
			after = nextMap[row][col]; 
			nextMap[row][col] = before;
			for(; d<4; d++) {
				int nR = row + dy[d == 0 ? d :4-d];
				int nC = col + dx[d == 0 ? d :4-d];
				if(bound(nC, nR)) {
					row = nR;
					col = nC;
					break;
				}
			}
			before = after;
		}
	}
	static int getSum() {
		int sum = 0;
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				sum += nowMap[i][j];
			}
		}
		return sum;
	}
	static void printMap() {
		for(int i=0; i<R; i++) {
			System.out.println(Arrays.toString(nextMap[i]));
		}
	}
	static boolean bound(int x, int y) {
		return x >= 0 && y >= 0 && x < C && y < R;
	}
	static boolean chkMachine(int x, int y) {
		return x == 0 && (y == topR || y == botR);
	}
}
