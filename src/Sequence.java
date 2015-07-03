
public class Sequence {
	private int numbers[];
	
	public Sequence() {
		numbers = new int[6];
	}
	
	public Sequence(int[] n) {
		numbers = n;
	}
	
	public int[] getNumbers() {
		return numbers;
	}
	
	public void print() {
		for(int i=0; i<numbers.length; i++) {
			System.out.printf("%02d", numbers[i]);
			if(i<numbers.length-1) System.out.print("-");
		}
	}
}
