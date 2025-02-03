package week1;

import java.util.Arrays;
import java.util.Scanner;

public class Baekjoon3052 {

	public static void main(String[] args) {

		// 나머지 문제

		Scanner sc = new Scanner(System.in);


		// 입력받은 수 저장하는 배열
		int[] nums = new int[10];

		// 입력받은 수 42로 나눈 나머지를 저장하는 배열
		int[] remain = new int[10];

		// n과 n+1를 비교하는 변수
		boolean bl;

		// 같지 않은 숫자를 세는 변수
		int count = 0;

		// 숫자 10개를 입력 받는 반복문
		for (int i = 0; i < 10; i++) {

			// 10개의 수를 입력받아 nums 배열에 저장한다
			nums[i] = sc.nextInt();

			// 입력받은 수 하나하나를 42로 나누어 나머지 값을 remain 배열에 저장한다
			remain[i] = nums[i] % 42;

		}
		// depth1 depth2
		// nums[0] -> nums[1] ~ nums[9]
		// nums[1] -> nums[2] ~ nums[9]
		// .
		// .
		// nums[9] -> nums[10]
		// 비교하는 반복문
		for (int index = 0; index < 10; index++) {

			bl = false; // false로 초기화

			for (int indexTwo = index + 1; indexTwo < 10; indexTwo++) {

				// 앞의 값과 뒤의 값이 같으면 bl은 true가 되고 depth2반복문을 나와 depth1 반복문을 돌린다
				// 하나라도 같은 수가 나온다면 그건 더이상 확인할 필요가 없는 숫자이기 때문이다
				if (remain[index] == remain[indexTwo]) {

					bl = true;
					break;
				}

			}

			// 앞의 값과 뒤의 값이 다르면 이 숫자는 다른 어떤 수와도 같지 않다는 뜻이므로 count +1 한다
			if (bl == false) {

				count++;

			}

		}

		System.out.println(count);

	}

}