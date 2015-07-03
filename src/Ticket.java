import java.util.ArrayList;


public class Ticket {
	
	private String name;
	private Sequence sequence;
	private int hits;
		
	// --- Constructors ---
	
	public Ticket() {
		name = "";
		sequence = new Sequence();
		hits = 0;
	}
	
	public Ticket(String n, Sequence s) {
		name = n;
		sequence = s;
		hits = 0;
	}
		
	// --- Getters & Setters --- Start
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Sequence getSequence() {
		return sequence;
	}

	public void setSequence(Sequence sequence) {
		this.sequence = sequence;
	}

	public int getHits() {
		return hits;
	}

	public void setHits(int hits) {
		this.hits = hits;
	}
	
	// --- Getters & Setters --- End

	public void print() {
		System.out.print(getName()+"\t\t\t");
		getSequence().print();
		System.out.println("\t\t"+getHits()+" hits");
	}
	
	public void countHits(Sequence s) {
		int count = 0;
		int n_winner[] = s.getNumbers();
		int n_this[] = getSequence().getNumbers();
		
		for(int i=0; i<6; i++) {
			for(int j=0; j<6; j++) {
				if(n_this[i] == n_winner[j]) count++;
			}
		}
		
		setHits(count);
	}
}
