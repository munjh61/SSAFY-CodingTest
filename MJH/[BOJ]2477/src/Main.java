import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		int x = 0;
		int y = 0;
		int[][] table = new int[6][2];
		int maxX = 0;
		int maxY = 0;
		int minX = 0;
		int minY = 0;

		Scanner sc = new Scanner(System.in);
		int harvest = sc.nextInt();
		for (int i = 0; i < 6; i++) {
			int direction = sc.nextInt();
			int distance = sc.nextInt();
			switch (direction) {
			case 1:
				x += distance;
				break;
			case 2:
				x -= distance;
				break;
			case 3:
				y -= distance;
				break;
			case 4:
				y += distance;
				break;
			}

			table[i][0] = x;
			table[i][1] = y;

			maxX = Math.max(maxX, x);
			maxY = Math.max(maxY, y);
			minX = Math.min(minX, x);
			minY = Math.min(minY, y);
		}
		sc.close();
		int[] middle = new int[2];
		for (int[] position : table) {
			if (position[0] != maxX && position[0] != minX && position[1] != maxY && position[1] != minY) {
				middle = position;
			}
		}
		int[][] corner = new int[4][2];
		corner[0] = new int[] { minX, minY };
		corner[1] = new int[] { minX, maxY };
		corner[2] = new int[] { maxX, minY };
		corner[3] = new int[] { maxX, maxY };
		boolean[] exist = new boolean[4];
		int[] notexist = new int[2];
		for (int j = 0; j < 4; j++) {
			for (int i = 0; i < 6; i++) {
				if (table[i][0] == corner[j][0] && table[i][1] == corner[j][1]) {
					exist[j] = true;
				}
			}
		}
		for (int i = 0; i < 4; i++) {
			if (!exist[i]) {
				notexist = corner[i];
			}
		}
		int dx = maxX - minX;
		int dy = maxY - minY;
		int except = Math.abs(notexist[0] - middle[0]) * Math.abs(notexist[1] - middle[1]);
		int area = dx * dy - except;
		System.out.println(area * harvest);
	}
}
