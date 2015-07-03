import java.util.ArrayList;
import java.util.Random;


public class RandomSequenceGenerator {
	
	public Sequence generate() {
		Random setter = new Random();
		int n[] = new int[6];
		
		ArrayList<Integer> list = new ArrayList<Integer>(6);
		
		for(int i=0; i<6; i++) {
			Integer number;
			do {
				number = new Integer(setter.nextInt(49) + 1);
			} while(list.contains(number));
			
			list.add(number);
			n[i] = number.intValue();
		}		
		
		return new Sequence(n);
	}
	
	
}
