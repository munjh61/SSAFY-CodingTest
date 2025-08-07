package boj2096_내려가기;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][3];
		
		for(int i=0; i<N; i++) {
			String line = br.readLine();
			StringTokenizer st = new StringTokenizer(line);
			for(int j=0; j<3; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[] max = new int[3];
		int[] min = new int[3];
		
		for(int i=0; i<3; i++) {
			max[i] = map[0][i];
			min[i] = map[0][i];
		}
		
		//두번째 줄 도달했을 때부터 계산
		for(int i=1; i<N; i++) {
			int[] newMax = new int[3];
			int[] newMin = new int[3];
			
			//0, 1 중 큰 값에 현재 값을 더한것 
			newMax[0] = Math.max(max[0], max[1]) + map[i][0];
			//이전 0,1,2 중 큰 값에 현재값을 더한 것
			newMax[1] = Math.max(Math.max(max[0], max[1]), max[2]) + map[i][1];
			//이전 1,2 중 큰 값에 현재 값을 더한 것
            newMax[2] = Math.max(max[1], max[2]) + map[i][2];

            newMin[0] = Math.min(min[0], min[1]) + map[i][0];
            newMin[1] = Math.min(Math.min(min[0], min[1]), min[2]) + map[i][1];
            newMin[2] = Math.min(min[1], min[2]) + map[i][2];
            
            //max, min 배열 갱신
            max = newMax;
            min = newMin;
		}
		
		int maxResult = Math.max(Math.max(max[0], max[1]), max[2]);
        int minResult = Math.min(Math.min(min[0], min[1]), min[2]);
        bw.write(String.valueOf(maxResult)+" "+String.valueOf(minResult));
        bw.flush();
		
	}
}
