package leetcode.arraystring;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
	public List<List<Integer>> generate(int numRows) {
		
		List<List<Integer>> list = new ArrayList<>();

		if (numRows <= 0) {
			return list;
		}

		List<Integer> row = new ArrayList<>();
		row.add(1);
		list.add(row);
		int i = 2;
		while (i <= numRows) {
			List<Integer> nextRow = new ArrayList<>();

			nextRow.add(row.get(row.size() - 1));

			for (int j = row.size() - 1; j > 0; j--) {
				nextRow.add(row.get(j) + row.get(j - 1));
			}

			nextRow.add(row.get(0));
			list.add(nextRow);
			row = nextRow;
			i++;
		}

		return list;
	}

}
