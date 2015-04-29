package com.nich01as.gcj2015.r1a;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

//https://code.google.com/codejam/contest/4224486/dashboard#s=p1
public class PB {
	
	private static int[] M = new int[1000];
	
	public static void main(String[] args) throws Exception {
		String file = "B-large-practice";
		Scanner scanner = new Scanner(new File(file + ".in"));
		BufferedWriter writter = new BufferedWriter(new FileWriter(file + ".out"));
		int T = scanner.nextInt();
		for (int testCase = 1; testCase <= T; testCase++) {
			int B = scanner.nextInt();
			int N = scanner.nextInt();
			for (int i = 0; i < B; i++) {
				M[i] = scanner.nextInt();
			}
			
			long l = 0, h = Long.MAX_VALUE/2;
			int ret = -1;
			long serving = 0;
			while (l < h) {
				serving = 0;
				long t = (l+h)/2;
				for (int i = 0; i < B; i++) {
					serving += t/M[i] + 1;
					if (serving > N) {
						break;
					}
				}
				if (serving >= N) {
					h = t;
				} else {
					l = t+1;
				}
			
			}
			
			
			serving = 0;
			for (int i = 0; i < B; i++) {
				serving += (l-1) / M[i] + 1;
			}
			long idx = N - serving;
			for (int i = 0; i < B; i++) {
				
				if (l % M[i] == 0) {
					idx--;
					if (idx == 0) {
						ret = i;
						break;
					}
					
				}
			}
			
			writter.write("Case #" + testCase + ": " + (ret+1) + "\n");
		}
		scanner.close();
		writter.close();
	}

}
