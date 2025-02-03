import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();

        String[] ary = new String[t];
        for (int i = 0; i < t; i++) {
            ary[i] = sc.nextLine();
        }
        sc.close();

        for (int i = 0; i < t; i++) {
            int l = ary[i].length();
            int[] score = new int[l];
            if (ary[i].charAt(0) == 'O') {
                score[0] = 1;
            }
            for (int j = 1; j < l; j++) {
                if (ary[i].charAt(j) == 'O') {
                    score[j] = score[j - 1] + 1;
                }
            }
            int sum = 0;
            for (int j = 0; j < l; j++) {
                sum += score[j];
            }
            System.out.println(sum);
        }
    }
}