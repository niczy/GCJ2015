package com.nich01as.gcj2015;

import java.io.BufferedWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

//https://code.google.com/codejam/contest/6224486/dashboard
public class PA {
	
	public static void main(String[] args) throws IOException {
		File file = new File("A-large-practice.in");
		Scanner scanner = new Scanner(file);
		BufferedWriter writer = new BufferedWriter(new FileWriter("A-large-practice.out"));
		int testCount = scanner.nextInt();
		for (int i = 1; i <= testCount; i++) {
			int k = scanner.nextInt();
			String line = scanner.next();
			//System.out.println("debug " + line);
			assert(line.length() == k + 1);
			int ret = 0;
			int standCount = 0;
			for (int j = 0; j <= k; j++) {
				int p = line.charAt(j) - '0';
				if (p > 0 && standCount < j) {
					ret += j - standCount;
					standCount += j - standCount + p;
				} else {
					standCount += p;
				}
			}
			writer.write("Case #" + i + ": " + ret + "\n");
		}
		scanner.close();
		writer.close();
	}

}
