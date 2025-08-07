import java.io.*;
import java.util.*;

// 시간 터짐
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        // 인접 리스트 초기화
        List<Set<Integer>> links = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            links.add(new HashSet<>());
        }

        int[] degree = new int[N + 1];

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            links.get(s).add(e);
            links.get(e).add(s);
            degree[s]++;
            degree[e]++;
        }

        boolean[] isAdopter = new boolean[N + 1];
        int adopterCount = 0;

        while (adopterCount < N) {
            int maxIdx = -1;
            int maxDeg = -1;

            // 배열 순회로 가장 연결 많은 노드 찾기
            for (int i = 1; i <= N; i++) {
                if (!isAdopter[i] && degree[i] > maxDeg) {
                    maxDeg = degree[i];
                    maxIdx = i;
                }
            }

            if (maxIdx == -1) break; // 남은 노드 없음

            // 가장 연결 많은 노드 -> 얼리어답터 지정
            isAdopter[maxIdx] = true;
            adopterCount++;

            for (int neighbor : new ArrayList<>(links.get(maxIdx))) {
                links.get(neighbor).remove(maxIdx);
                degree[neighbor]--;

                // 연결이 자기 하나뿐이면 그 이웃도 얼리어답터로 지정
                if (!isAdopter[neighbor] && degree[neighbor] == 1) {
                    isAdopter[neighbor] = true;
                    adopterCount++;
                    for (int n : new ArrayList<>(links.get(neighbor))) {
                        links.get(n).remove(neighbor);
                        degree[n]--;
                    }
                    links.get(neighbor).clear();
                }
            }

            links.get(maxIdx).clear(); // 현재 노드 연결도 제거
        }

        System.out.println(adopterCount);
    }

	static class Node implements Comparable<Node> {
		int person, degree;

		public Node(int person, int degree) {
			this.person = person;
			this.degree = degree;
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(o.degree, this.degree);
		}

	}
}

// 가장 많이 연결된 애를 가져온다
// 걔를 얼리어답터로 만든다
// 주위 중에 연결이 자기 뿐인 애를 얼리어답터로 만든다.
// 주위를 끊어버린다.
// 얼리어답터가 아닌 애가 없어질 때까지 반복