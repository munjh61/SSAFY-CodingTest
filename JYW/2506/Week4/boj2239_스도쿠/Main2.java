package boj2239_스도쿠;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main2 {

    static int[][] map = new int[9][9];
    static boolean finished = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for(int i = 0; i < 9; i++) {
            String line = br.readLine();
            for(int j = 0; j < 9; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        check(0, 0);

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                sb.append(map[i][j]);
            }
            sb.append('\n');
        }

        bw.write(sb.toString());
        bw.flush();
    }

    static boolean check(int x, int y) {
        //백트래킹
    	if (x == 9) {
            return true;
        }
        
        if (y == 9) {
        	//다음 열 이동
            return check(x + 1, 0);
        }
        //숫자가 있으면 다음칸 확인
        if (map[x][y] != 0) {
            return check(x, y + 1);
        }
        //0이면 가능한 숫자 확인
        for (int num = 1; num <= 9; num++) {
            if (isPossible(x, y, num)) {
                map[x][y] = num;
                if (check(x, y + 1)) {
                    return true;
                }
                map[x][y] = 0;
            }
        }

        return false;
    }

    static boolean isPossible(int x, int y, int num) {
        for (int i = 0; i < 9; i++) {
            if (map[x][i] == num || map[i][y] == num) {
                return false;
            }
        }

        int row = (x/3) * 3;
        int col = (y/3) * 3;
        for (int i = row; i < row + 3; i++) {
            for (int j = col; j < col + 3; j++) {
                if (map[i][j] == num) {
                    return false;
                }
            }
        }

        return true;
    }
}

