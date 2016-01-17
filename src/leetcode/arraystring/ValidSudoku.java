package leetcode.arraystring;

/**
 * Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.
 * 
 * The Sudoku board could be partially filled, where empty cells are filled with
 * the character '.'.
 * 
 * @author BangChuan Liu <liubangchuan1100@gmail.com>
 *
 * @date Feb 3, 2015
 */
public class ValidSudoku {
	public boolean isValidSudoku(char[][] board) {

		if (board == null || board.length != board[0].length || board.length != 9) {
			return false;
		}

		int len = board.length;

		for (int i = 0; i < len; i++) {
			boolean[] u1 = new boolean[len + 1];
			boolean[] u2 = new boolean[len + 1];
			for (int j = 0; j < len; j++) {
				if (board[i][j] != '.') {
					if (u1[board[i][j] - '0']) {
						return false;
					} else {
						u1[board[i][j] - '0'] = true;
					}
				}

				if (board[j][i] != '.') {
					if (u2[board[j][i] - '0']) {
						return false;
					} else {
						u2[board[j][i] - '0'] = true;
					}
				}
			}
		}

		for (int i = 0; i < len; i = i + 3) {
			for (int j = 0; j < len; j = j + 3) {
				boolean[] u = new boolean[len + 1];
				for (int m = i; m < i + 3; m++) {
					for (int n = j; n < j + 3; n++) {
						if (board[m][n] != '.') {
							if (u[board[m][n] - '0']) {
								return false;
							} else {
								u[board[m][n] - '0'] = true;
							}
						}
					}
				}
			}
		}

		return true;
	}

	public static void main(String[] args) {
		char[][] sudo = { { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
				{ '6', '.', '.', '1', '9', '5', '.', '.', '.' }, { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
				{ '8', '.', '.', '.', '6', '.', '.', '.', '3' }, { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
				{ '7', '.', '.', '.', '2', '.', '.', '.', '6' }, { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
				{ '.', '.', '.', '4', '1', '9', '.', '.', '5' }, { '.', '.', '.', '.', '8', '.', '.', '7', '9' } };

		char[][] sudo2 = { { '.', '.', '4', '.', '.', '.', '.', '6', '3' },
				{ '.', '.', '.', '.', '.', '.', '.', '.', '.' }, { '5', '.', '.', '.', '.', '.', '.', '9', '.' },
				{ '.', '.', '.', '5', '6', '.', '.', '.', '.' }, { '4', '.', '3', '.', '.', '.', '.', '.', '1' },
				{ '.', '.', '.', '7', '.', '.', '.', '.', '.' }, { '.', '.', '.', '5', '.', '.', '.', '.', '.' },
				{ '.', '.', '.', '.', '.', '.', '.', '.', '.' }, { '.', '.', '.', '.', '.', '.', '.', '.', '.' } };
		ValidSudoku instance = new ValidSudoku();
		System.out.println(instance.isValidSudoku(sudo2));

	}
}
