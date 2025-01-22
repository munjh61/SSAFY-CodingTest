import java.util.Scanner;

public class b13300 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//총 인원 입력
		int total = sc.nextInt();
		//한 방 최대 인원 수
		int max = sc.nextInt();
		
		//성별, 학년 배열
		//성별 0, 1
		//학년 0,1,2,3,4,5
		int[][] student = new int[2][6];
		
		//학생 정보 저장
		for(int i=0; i<total; i++) {
			//성별 여학생:0, 남학생:1
			int gender = sc.nextInt();
			//학년
			int grade = sc.nextInt();

			student[gender][grade-1]++; //배열은 0부터 시작하기 때문에 조정
		}
		
		int room = 0;
		//필요한 방 갯수
		for(int i = 0; i<2; i++) {//gender
			for(int j=0; j<6; j++) {//grade
//				room += (student[i][j] +)/max; 필요한 방 갯수 보다 1개 작게 도출
				room += (student[i][j] + max - 1)/max; // 필요한 방 갯수 도출되기 위해 나누는 수 만큼 더하고 1을 빼서 더 크게 안나오게 한다.
			}
		}
		System.out.println(room);
		sc.close();	
	}
}