import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		/*
		 * 6( ( (n-1)^2 + (n-1) ) / 2 )< input -1 <= 6( ( n^2 + n ) / 2 ) 만족하는 n 값 구하기
		 */
		Scanner sc = new Scanner(System.in);
		int k = sc.nextInt();
		sc.close();
		int n = 0;
		while (k > 3 * (Math.pow(n, 2) + n) + 1) {
			n++;
		}
		System.out.println(n + 1);
	}

}
