package boj1043_거짓말;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main2 {
	
	static int[] parent;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); //사람 수
		int M = Integer.parseInt(st.nextToken()); //파티수
		
		parent = new int[N+1];
		for(int i=1; i<N+1; i++) {
			parent[i] = i;
		}
		
		st = new StringTokenizer(br.readLine());
		int truthCount = Integer.parseInt(st.nextToken());// 진실을 알고 있는 사람수
		
        Set<Integer> truthSet = new HashSet<>();
        for (int i = 0; i < truthCount; i++) {
        	//진실을 알고 있는 사람 번호
            truthSet.add(Integer.parseInt(st.nextToken()));
        }
        
        List<List<Integer>> parties = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            
            List<Integer> party = new ArrayList<>();
            for (int j = 0; j < num; j++) {
                party.add(Integer.parseInt(st.nextToken()));
            }
            // 같은 파티 내 인원들 모두 union으로 연결 처리
            for (int j = 0; j < party.size() - 1; j++) {
                union(party.get(j), party.get(j + 1));
            }
            parties.add(party);
        }
        
        //진실을 아는 사람이 속한 파티를 저장
        //여기에 연결된 모든 사람들은 진실을 알게 됨
        Set<Integer> truthParents = new HashSet<>();
        for (int t : truthSet) {
            truthParents.add(find(t)); //초기 진실을 아는 사람들
        }

        int answer = 0;
        for (List<Integer> party : parties) {
            boolean canLie = true;
            for (int person : party) {
            	//파티 참가자 중 진실을 아는 사람이 있으면 거짓말 못함
                if (truthParents.contains(find(person))) {
                    canLie = false;
                    break;
                }
            }
            if (canLie) answer++;
        }
        
        bw.write(String.valueOf(answer));
        bw.flush();
        
	}
	
	//x가 속한 집합의 대표를 찾음
	static int find(int x) {
		if(x == parent[x]) return x;
		return parent[x] = find(parent[x]);
	}
	
	//파티원들 연결하기
	static void union(int a, int b) {
		int pa = find(a);
		int pb = find(b);
		if(pa != pb) { // 두 원소의 대표가 같지 않으면 연결하기
			parent[pb] = pa;
		}
	}
}
