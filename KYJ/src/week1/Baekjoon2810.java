package week1;

import java.util.Scanner;

public class Baekjoon2810 {
	public static void main(String[] args) {
		
		//컵홀더 문제
		
		Scanner sc = new Scanner(System.in);

		// 좌석의 수를 입력 받는다.
		int num = sc.nextInt();

		// 좌석의 정보를 입력받는다.
		String seat = sc.next();

		// s 개수 새는 식
		// (좌석 정보 변수 seat 길이) - (seat에서 "S"를 없앤 변수의 길이) = S의 갯수
		int sCount = seat.length() - seat.replace("S", "").length();

		// L 개수를 새는 식
		// (좌석 정보 변수 seat 길이) - (seat에서 "L"를 없앤 변수의 길이) = L의 갯수
		int llCount = seat.length() - seat.replace("L", "").length();
		
		// L이 두개 모여야 컵홀더 하나 이므로 /2
		llCount /= 2;

		// 컵홀드 가장 왼쪽은 무조건 카운트 +1
		// S일 경우 - S 하나당 오른쪽에 컵홀드 +1
		// L일 경우 - L 두개당 오른쪽 컵홀드 카운트 +1
		int cupHolders = sCount + llCount + 1;

		// (S 개수) + (LL 개수) +1 의 값이 사람의 수보다 많은 경우 컵홀더의 개수가 아닌 최대 사람의 수 출력
		// 컵을 컵홀더에 놓을 수 있는 최대 사람의 수를 출력해야 하기 때문이다
		if (cupHolders > num) {
			System.out.println(num);

		} else {

			System.out.println(cupHolders);

		}

	}
}

