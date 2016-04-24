package leetcode.hash;

import java.util.HashMap;
import java.util.Map;

class Point {
	int x;
	int y;

	Point() {
		x = 0;
		y = 0;
	}

	Point(int a, int b) {
		x = a;
		y = b;
	}
}

public class MaxPointsonaLine {
	public int maxPoints(Point[] points) {
		if (points == null || points.length == 0) {
			return 0;
		}

		Map<Double, Integer> numMap = new HashMap<>();
		int max = Integer.MIN_VALUE;

		for (int i = 0; i < points.length; i++) {
			int duplicate = 1;
			int vertical = 0;
			for (int j = i + 1; j < points.length; j++) {
				if (points[i].x == points[j].x) {
					if (points[i].y == points[j].y) {
						duplicate++;
					} else {
						vertical++;
					}
				} else {
					double factor = points[j].y == points[i].y ? 0.0
							: 1.0 * (points[j].y - points[i].y) / (points[j].x - points[i].x);
					if (numMap.containsKey(factor)) {
						numMap.put(factor, numMap.get(factor) + 1);
					} else {
						numMap.put(factor, 1);
					}
				}
			}

			for (Integer num : numMap.values()) {
				max = Math.max(duplicate + num, max);
			}
			max = Math.max(max, vertical + duplicate);
			numMap.clear();
		}

		return max;

	}

	public static void main(String[] args) {
		MaxPointsonaLine instance = new MaxPointsonaLine();
		Point p1 = new Point(0, 0);
		Point p2 = new Point(-1, -1);
		Point p3 = new Point(2, 2);
		Point[] points = { p1, p2 };
		System.out.println(instance.maxPoints(points));
	}
}