package self.test;

public class FlattenVector {
	int[][]  vector;
	int noOfrows;
	int currRow;
	int currCol;
	
	FlattenVector(int rows){
		vector = new int[rows][];
		noOfrows = rows;
		currRow = 0;
		currCol = 0;
	}
	
	
	boolean hasNext() {
		while(currRow < noOfrows && (vector[currRow]==null||vector[currRow].length==0))
			currRow++;
		if(currRow < noOfrows && currCol < vector[currRow].length)
			return true;
		return false;
	}
	
	int next() {
		int val = vector[currRow][currCol];
		currCol++;
		if(vector[currRow].length==currCol) {
			currRow++;
			currCol = 0;
		}
		return val;
		
	}
}
