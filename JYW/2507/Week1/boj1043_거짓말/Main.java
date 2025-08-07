package boj1043_거짓말;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); //사람 수
		int M = Integer.parseInt(st.nextToken()); //파티수
		
		st = new StringTokenizer(br.readLine());
		int truth = Integer.parseInt(st.nextToken());
		List<Integer> tPerson = new ArrayList<>();
		if(truth>0) {
			for(int i=0; i<truth; i++) {
				tPerson.add(Integer.parseInt(st.nextToken()));
			}
		}
		
		int[][] pPerson = new int[M][N];
		for(int i=0; i<M; i++) { // 총 파티 수만큼
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			int[] parties = new int[num];
			
			for(int j=0; j<num; j++) {
				int n = Integer.parseInt(st.nextToken());
				parties[j] = n;
				pPerson[i][j] = n;
			}
			
			for(int p=0; p<num; p++) { // 파티에 온 사람 수
				for(int t=0; t<tPerson.size(); t++) {
					if(tPerson.get(t) == parties[p]) {
						if(parties.length>1) {
							for(int k=0; k<parties.length; k++) {
								if(!tPerson.contains(parties[k])) {
									tPerson.add(parties[k]);
								}
							}
						}
					}
				}
			}
		}
		
		//답구하기
		int ans = M;
		for(int i=0; i<M; i++) {
			boolean flag = false;
			for(int j=0; j<N; j++) {
				for(int k=0; k<tPerson.size(); k++) {
					if(tPerson.get(k) == pPerson[i][j]) {
						ans--;
						flag = true;
					}
					if(flag) {
						break;
					}
				}
				if(flag) {
					break;
				}
			}
		}
		
		bw.write(String.valueOf(ans));
		bw.flush();
	}
}
