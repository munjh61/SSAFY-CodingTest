import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int l = sc.nextInt();
		int n = sc.nextInt();
		int [] ary = new int [l+1];
		//희망
		int wishMost = 0;
		int wishWho = 0;
		
		for(int i = 1 ; i <= n ; i ++ ) {
			int start = sc.nextInt();
			int end = sc.nextInt();
			int want = end - start + 1;
			if(wishMost<want) {
				wishMost = want;
				wishWho = i;
			}
			for(int j = start ; j <= end ; j ++) {
				if(ary[j] == 0) {
					ary[j] = i;
				}
			}
		}
		sc.close();
		
		//현실
		int haveMost = 0;
		int haveWho = 0;
		
		int[] persons = new int [n+1];
		for(int i = 1 ; i <= l ; i ++ ) {
			persons[ary[i]]++;
		}
		persons[0] = 0;
		int[] personsSort = Arrays.copyOf(persons, n+1);
		Arrays.sort(personsSort);
		haveMost = personsSort[n];
		for(int i = 1 ; i <= n ; i ++ ) {
			if(persons[i]==haveMost) {
				haveWho=i;
				break;
			}
		}
		System.out.println(wishWho);
		System.out.println(haveWho);
	}
}
