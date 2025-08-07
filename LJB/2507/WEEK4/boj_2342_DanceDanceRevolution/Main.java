package boj_2342_DanceDanceRevolution;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	static ArrayList<Integer> list;
	static int size;
	static int[][][] dp;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		list = new ArrayList<>();
		st = new StringTokenizer(br.readLine());
		while (st.hasMoreTokens())
			list.add(Integer.parseInt(st.nextToken()));
		size = list.size() - 1;

		dp = new int[size][5][5];

		int result = move(0, 0, 0);

		System.out.println(result);
	}

	static int move(int idx, int left, int right) {

		if (idx == size)
			return 0;

		if (dp[idx][left][right] != 0)
			return dp[idx][left][right];

		int next = list.get(idx);
		return dp[idx][left][right] = Math.min(move(idx + 1, next, right) + cost(left, next),
				move(idx + 1, left, next) + cost(right, next));
	}

	static int cost(int from, int to) {
		int cost = 3;
		if (from == 0) {
			cost = 2;
		} else if (from == to) {
			cost = 1;
		} else if (Math.abs(from - to) == 2) {
			cost = 4;
		}
		return cost;
	}
}
