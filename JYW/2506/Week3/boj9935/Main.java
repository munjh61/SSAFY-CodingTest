package boj9935;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String line = br.readLine();
		String bomb = br.readLine();
		
		Stack<Character> stack = new Stack<>();
		
		for(int i=0; i<line.length(); i++) {
			stack.push(line.charAt(i));
			
			if(stack.size() >= bomb.length()) {
				boolean flag = true;
				for(int k=0; k<bomb.length(); k++) {
					//bomb 범위만큼 뺀 곳에서 시작하고 거기에 k번째와 비교
					if(stack.get(stack.size() - bomb.length() + k) != bomb.charAt(k)) {
						flag = false;
						break;
					}
				}
				if(flag) {
					//일치하면 스택에서 제외
					for(int j=0; j<bomb.length(); j++) {
						stack.pop();
					}
				}
			}
		}
		
		
		if(stack.isEmpty()) {
			bw.write("FRULA");
		}else {
			StringBuilder sb = new StringBuilder();
			for(char c : stack) {
				sb.append(c);
			}
			bw.write(sb.toString());
		}
		bw.flush();
	}
	
	
}
