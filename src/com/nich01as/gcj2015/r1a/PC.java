package com.nich01as.gcj2015.r1a;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

//https://code.google.com/codejam/contest/4224486/dashboard#s=p2
public class PC {
	private static class Point {
		int x, y;
		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	private static int N;
	private static int findMinimal(int index, List<Point> points) {
		List<Double> atan = new ArrayList<Double>();
		for (int i = 0; i < points.size();i++) {
			if (i != index) {
				double a = Math.atan2(points.get(i).y - points.get(index).y, points.get(i).x - points.get(index).x);
				atan.add(a);
				atan.add(a + 2 * Math.PI);
			}
		}
		Collections.sort(atan);
		int ret = points.size() - 1;
		int i = 0, j = 0;
		while (j < atan.size()) {
			while (j < atan.size() && atan.get(j) - atan.get(i) < Math.PI - 1e-15) {
				j++;
			}
			ret = Math.min(ret, j-i-1);
			i++;
		}
		
		return ret;
	}
	
	public static void main(String[] args) throws Exception {
		String file = "C-large-practice";
		File inputFile = new File(file + ".in");
		Scanner scanner = new Scanner(inputFile);
		BufferedWriter writter = new BufferedWriter(new FileWriter(file + ".out"));
		int T = scanner.nextInt();
		System.out.println("debug T " + T);
		for (int testCase = 1; testCase <= T; testCase++) {
			N = scanner.nextInt();
			List<Point> points = new ArrayList<Point>();
			writter.write("Case #" + testCase + ":\n");
			for (int i = 0; i < N; i++) {
				
				int x = scanner.nextInt();
				
				int y  = scanner.nextInt();
				Point p = new Point(x, y);
				points.add(p);
			}
				for (int i = 0; i < N; i++) {
					writter.write(findMinimal(i, points) + "\n");
			}
		}
		scanner.close();
		writter.close();
	}
}
