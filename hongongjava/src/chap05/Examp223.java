package chap05;

public class Examp223 {

	public static void main(String[] args) {
		int[][] array = {
				{95, 86},
				{83,92,96},
				{78, 83, 93, 87, 88}
		};
		
		int sum = 0;
		double avg = 0.0;
		int num = 0;
		
		//일반for
		for(int i=0; i<array.length; i++) {
			for(int j=0; j<array[i].length; j++) {
				num++;
				sum += array[i][j];				
			}
		}
		
		//향상된for
		for(int[] row : array) {
			for(int j : row) {
				num++;
				sum += j;
			}
			System.out.println();
		}
		avg = (double)sum/num;
		
		System.out.println("sum : "  + sum);
		System.out.println("avg : "  + avg);

	}

}
