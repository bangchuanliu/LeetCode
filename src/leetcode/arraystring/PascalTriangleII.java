package leetcode.arraystring;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalTriangleII {
	public List<Integer> getRow(int rowIndex) {
		List<Integer> row = new ArrayList<>();
		if (rowIndex < 0) {
			return row;
		}
		row.add(1);
		int i = 0;
		while (i < rowIndex) {
			row.add(1);

			for (int j = i; j > 0; j--) {
				row.set(j, row.get(j) + row.get(j - 1));
			}
			i++;
		}
		return row;
	}

	public static void main(String[] args) {
		PascalTriangleII instance = new PascalTriangleII();
		System.out.println(Arrays.toString(instance.getRow(1).toArray()));
		System.out.println(Arrays.toString(instance.getRow(2).toArray()));
		System.out.println(Arrays.toString(instance.getRow(3).toArray()));
		System.out.println(Arrays.toString(instance.getRow(4).toArray()));
	}
}
