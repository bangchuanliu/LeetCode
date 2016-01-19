package leetcode.arraystring;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * 
 *  Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

	For example,
	Given the following matrix:
	
	[
	 [ 1, 2, 3 ],
	 [ 4, 5, 6 ],
	 [ 7, 8, 9 ]
	]
	You should return [1,2,3,6,9,8,7,4,5].
 * 
 * @author admin
 *
 */
public class SpiralMatrix {
	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> result = new ArrayList<Integer>();
		if(matrix == null || matrix.length == 0){
			return result;
		}
		int m = matrix.length;
		int n = matrix[0].length;
		int x = 0;
		int y = 0;
		while(m > 0 && n > 0){
			//if only one row or column left, then retrieve value
			if(m == 1){
				for(int i=0;i<n;i++){
					result.add(matrix[x][y++]);
				}
				break;
			}
			if(n == 1){
				for(int i=0;i<m;i++){
					result.add(matrix[x++][y]);
				}
				break;
			}
			
			//process a circle
			// top - move right
			for(int i=0;i<n-1;i++){
				result.add(matrix[x][y++]);
			}
			
			// right - move down
			for(int i=0;i<m-1;i++){
				result.add(matrix[x++][y]);
			}
			
			// bottom - move left
			for(int i=0;i<n-1;i++){
				result.add(matrix[x][y--]);
			}
			// bottom - move up
			for(int i=0;i<m-1;i++){
				result.add(matrix[x--][y]);
			}
			m -=2;
			n -=2;
			x++;
			y++;
		}
		return result;
	}
	
	public static void main(String[] args){
		SpiralMatrix instance = new SpiralMatrix();
		int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
		List<Integer> result = instance.spiralOrder(matrix);
		System.out.println(Arrays.toString(result.toArray()));
	}
}
