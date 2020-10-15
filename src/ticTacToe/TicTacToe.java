package self.test;

public class TicTacToe {
	char[][] matrix;
	int[] rows;
	int[] cols;
	int dc1;
	int dc2;
	int n;
	
	TicTacToe(int n){
		this.n = n;
		rows = new int[n];
		cols = new int[n];
		matrix = new char[n][n];
		dc1 = 0;
		dc2 = 0;
	}
	
	int move(int row, int col, int player) {
		int val = player==1?1:-1;
		char c = player==1?'O':'X';
		matrix[row][col] = c;
		rows[row]+=val;
		cols[col]+=val;
		if(row==col)
			dc1+=val;
		if(col==n-row-1)
			dc2+=val;
		if(Math.abs(rows[row])==n||Math.abs(cols[col])==n||Math.abs(dc1)==n||Math.abs(dc2)==n) {
			return player;
		}
		return 0;
	}
	
	void display() {
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				System.out.print(matrix[i][j]+' ');
			}
			System.out.println("");
		}
	}
}
