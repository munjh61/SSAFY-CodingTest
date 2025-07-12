package boj_1043_거짓말;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Main {
	static int[] parent;
	static boolean[] pplWhoKnow;
	static List<Integer>[] parties;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt(); // 사람 수
		int m = sc.nextInt(); // 파티 수

		parent = new int[n + 1];
		pplWhoKnow = new boolean[n + 1];
		parties = new ArrayList[m];

		// Union-Find 초기화
		for (int i = 1; i <= n; i++) {
			parent[i] = i;
		}

		int t = sc.nextInt(); // 진실을 아는 사람 수
		List<Integer> know = new ArrayList<>();
		for (int i = 0; i < t; i++) {
			int idx = sc.nextInt();
			pplWhoKnow[idx] = true;
			know.add(idx);
		}

		for (int i = 0; i < m; i++) {
			int count = sc.nextInt();
			parties[i] = new ArrayList<>();
			if (count > 0) {
				int first = sc.nextInt();
				parties[i].add(first);
				for (int j = 1; j < count; j++) {
					int next = sc.nextInt();
					union(first, next);
					parties[i].add(next);
				}
			}
		}

		Set<Integer> root = new HashSet<>();
		for (int person : know) {
			root.add(find(person));
		}

		int result = 0;
		for (int i = 0; i < m; i++) {
			boolean possible = true;
			for (int person : parties[i]) {
				if (root.contains(find(person))) {
					possible = false;
					break;
				}
			}
			if (possible)
				result++;
		}

		System.out.println(result);
	}

	static int find(int x) {
		if (parent[x] != x) {
			parent[x] = find(parent[x]);
		}
		return parent[x];
	}

	static void union(int x, int y) {
		int px = find(x);
		int py = find(y);
		if (px != py) {
			parent[py] = px;
		}
	}
}
