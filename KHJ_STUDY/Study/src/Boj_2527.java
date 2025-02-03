
public class Boj_2527 {
	public static void main(String[] args) {
		/*
		 * 3,10 50,60 / 100,100 200,300
		 * 첫번째 도형의 두번째 점보다 두번째 도형의 첫번째 점이 더 크다
		 * 도형의 값을 배열에 넣는다고 했을때
		 * 
		 * 1,2 4,7 / 3,5 6,8
		 */
		int[] first = {11,120,120,230};
		int[] second = {50,40,60,440};
		// 점인 경우
		if(first[2] == second[0] && first[3] == second[1] ||
		   second[2] == first[0] && second[3] == first[1]) {
			System.out.println('c');
		}else if(first[2] < second[0] && first[3] < second[1] || // 만나지 않는 경우
				 second[2] < first[0] && second[2] < first[1]	) {
			System.out.println('d');
		}else if(first[0] < second[0] && second[0] < first[2] &&
		   first[1] < second[1] && second[1] < first[3]) {
			System.out.println('a');
		}else if(second[0] < first[0] && first[0] < second[2] &&
		   second[1] < first[1] && first[1] < second[3]) {
			System.out.println('a');
		}else {
			System.out.println('b');
		}
	}
}
