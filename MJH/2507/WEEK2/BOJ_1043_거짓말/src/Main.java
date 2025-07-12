import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static boolean[] knows;      // 진실을 아는 사람
    static List<Integer>[] parties;   // 각 파티에 누가 참여했는지
    static List<Integer>[] persons; // 각 사람이 어떤 파티에 참여했는지

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 사람 수
        M = Integer.parseInt(st.nextToken()); // 파티 수

        knows = new boolean[N + 1]; // 진실을 아는지
        parties = new ArrayList[M];  // 파티 기준 사람
        persons = new ArrayList[N + 1]; // 사람 기준 파티

        for (int i = 0; i <= N; i++) persons[i] = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < t; i++) {
            int person = Integer.parseInt(st.nextToken());
            knows[person] = true;
            queue.offer(person);
        }

        for (int i = 0; i < M; i++) {
            parties[i] = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            int count = Integer.parseInt(st.nextToken());
            for (int j = 0; j < count; j++) {
                int person = Integer.parseInt(st.nextToken());
                parties[i].add(person);
                persons[person].add(i);
            }
        }

        // 진실 아는 사람 모임
        boolean[] visited = new boolean[N + 1];
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            if (visited[curr]) continue;
            visited[curr] = true;

            for (int partyIdx : persons[curr]) {
                for (int participant : parties[partyIdx]) {
                    if (!knows[participant]) {
                        knows[participant] = true;
                        queue.offer(participant);
                    }
                }
            }
        }

        // 진실을 모르는 파티 수 세기
        int result = 0;
        for (int i = 0; i < M; i++) {
            boolean liePossible = true;
            for (int person : parties[i]) {
                if (knows[person]) {
                    liePossible = false;
                    break;
                }
            }
            if (liePossible) result++;
        }

        System.out.println(result);
    }
}
