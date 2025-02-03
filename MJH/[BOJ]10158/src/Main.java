import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int w = sc.nextInt();
		int h = sc.nextInt();
		int dx = 1;
		int dy = 1;
		int x = sc.nextInt();
		int y = sc.nextInt();
		int t = sc.nextInt();
		sc.close();
		for (int i = 0; i < t; i++) {
			if (x == w || x == 0) {
				dx = -dx;
			}
			if (y == h || y == 0) {
				dy = -dy;
			}
			x += dx;
			y += dy;
		}
		System.out.println(x + " " + y);
	}

}
*/
/*
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int w = sc.nextInt();
		int h = sc.nextInt();
		int x = sc.nextInt();
		int y = sc.nextInt();
		int t = sc.nextInt();
		sc.close();
		x = x + t;
		y = y + t;

		x = (x / w) % 2 == 0 ? x % w : (w - x) % w;
		y = (y / h) % 2 == 0 ? y % h : (h - y) % h;
		System.out.println(x + " " + y);
	}

}
*/