package com.nich01as.gcj2015.qualification;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

//https://code.google.com/codejam/contest/6224486/dashboard#s=p2
public class PC {
	
	private static final int I = 2;
	private static final int J = 3;
	private static final int K = 4;
	
	private static final Integer[][] map = new Integer[][] {
		{0, 0, 0, 0, 0},
		{0, 1, I, J, K},
		{0, I, -1, K, -J},
		{0, J, -K,-1, I},
		{0, K, J, -I, -1}
	};
	
	private static int mult(int a, char b) {
		int n = b - 'i' + 2;
		if (a * n < 0) {
			return -map[Math.abs(a)][Math.abs(n)];
		} else {
			return map[Math.abs(a)][Math.abs(n)];
		}
	}
	
	private static final int solve(String s) {
		int cur1 = 1;
		for (int i = 0; i < s.length(); i++) {
			cur1 = mult(cur1, s.charAt(i));
			if (Math.abs(cur1) == I) {
				int cur2 = 1;
				for (int j = i+1; j < s.length(); j++) {
					cur2 = mult(cur2, s.charAt(j));
					if (Math.abs(cur2) == J) {
						int cur3 = 1;
						for (int k = j+1; k < s.length(); k++) {
							cur3 = mult(cur3, s.charAt(k));
						}
						if (Math.abs(cur3) == K) {
							if (cur1 * cur2 * cur3 > 0) {
								return 1;
							} else {
								return -1;
							}
						} else {
							return 0;
						}
					}
				}
			}
		}
		return 0;
	}
	
	private static final boolean solve(String s, long X) {
		if (X == 1) {
			return solve(s) == 1;
		} else if (X == 2) {
			return solve(s + s) == 1;
		} else if (X == 3) {
			return solve(s + s + s) == 1;
		} else if (X == 4) {
			return solve(s + s + s + s) == 1;
		} else {
			switch ((int) (X % 4)) {
			case 0:
				return solve(s + s + s + s) == 1;
			case 1:
				return solve(s + s + s + s + s) == 1;
			case 2:
				return solve(s + s + s + s + s + s) == 1;
			case 3:
				return solve(s + s + s + s + s + s + s) == 1;
			default:
				return false;
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		File file = new File("C-large-practice.in");
		File outFile = new File("C-large-practice.out");
		Scanner scanner = new Scanner(file);
		BufferedWriter writter = new BufferedWriter(new FileWriter(outFile));
		int T = scanner.nextInt();
		for (int testCase = 1; testCase <= T; testCase++) {
			scanner.nextLong();
			long X = scanner.nextLong();
			String s = scanner.nextLine();
			s = scanner.nextLine();
			//System.out.println("debug " + s);
			writter.write("Case #" + testCase + ": " + (solve(s, X) ? "YES" : "NO") + "\n");
		}
		scanner.close();
		writter.close();
	}

}
