import java.util.Scanner;

public class b1592 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//사람 수 입력
		int n = sc.nextInt();
		//최대로 공을 받는 횟수. 멈추는 최대 횟수.
		int m = sc.nextInt();
		//공을 옮기는 칸 수 입력
		int l = sc.nextInt();
		
		int[] count = new int[n];
		
		int now = 0; //현재 공을 가지고 있는 사람의 위치
		int i = 0; // 총 공을 던진 횟수
		
		count[now] = 1; //1번 사람이 공을 받고 시작
		
		while(count[now]<m) {//최대 횟수보다 작으면 반복.
			i++; //반복문이 실행될 때마다 공을 던진 횟수 증가
			
			//홀수일 경우 시계방향
			if(count[now]%2 == 1) {
				now = (now + l) % n; //공의 위치
									//사람수 보다 커질 수 있으니 나머지로 조절
			}
			else {//짝수일 경우 반시계방향
				now = (now - l + n) % n; //공의 위치
										//반시계방향 이동 후 음이 될 수 있어서 n 더해서 조절
			}
			count[now]++; //now 자리의 사람이 공을 가진 횟수 증가
		}
		System.out.println(i);
		sc.close();
	}
}