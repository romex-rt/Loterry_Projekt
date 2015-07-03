import java.util.Scanner;

public class IOHandler {
	
	private Scanner sc;
	private int menuInput;
	
	private ErrorMessage err;
	
	public IOHandler() {
		sc = new Scanner(System.in);
		menuInput = 0;
	}
	
	// --- Getters & Setters ---
	
	public int getMenuInput() {
		return menuInput;
	}

	public void setMenuInput(int menuInput) {
		this.menuInput = menuInput;
	}
	
	// --- Getters & Setters --- End
	
	
	public void printMenu(MenuState menuState) {
		System.out.println(" --- Lottery ---");
		System.out.println("1 Enter ticket");
		System.out.println("2 Drawing");
		System.out.println("3 Show result");
		System.out.println("0 Quit");
		System.out.print("Please enter [0-3]: ");
		setMenuInput(sc.nextInt());
		sc.nextLine();
		
		while( isFaulty(menuInput, menuState) ) {
			printErrorMessage();
			setMenuInput(sc.nextInt());
			sc.nextLine();
		}
	}

	public Ticket enterTicket() {
		Ticket t = new Ticket();
		t.setName(scanTicketName());
		t.setSequence(scanTicketNumbers());
		return t;
	}
	
	public boolean addAnotherTicket() {
		System.out.print("Do you want to add another ticket? [Y/N]: ");
		String input = sc.nextLine();
		if(input.equalsIgnoreCase("Y")) return true;
		else if(input.equalsIgnoreCase("N")) return false;
		else {
			err = ErrorMessage.WrongTicketInput;
			err.show();
			return addAnotherTicket();
		}
	}
	
	private String scanTicketName() {
		System.out.print("Name: ");
		String name = sc.nextLine();
		if(name.length()>35) name.substring(0, 34);
		return name;
	}
	
	private Sequence scanTicketNumbers() {
		
		int n[] = new int[6];
		for(int i=0; i<6; i++) {
			String s = "";
			if(i==0) s = "st";
			else if(i==1) s = "nd";
			else if(i==2) s = "rd";
			else s = "th";
			
			System.out.print( (i+1) + s + " number: " );
			int number = sc.nextInt();
			sc.nextLine();
			while( isOutOfRange(number) || duplicate(number,n) ) {
				err.show();
				number = sc.nextInt();
				sc.nextLine();
			}
			
			n[i] = number;
		}
		
		return new Sequence(n);
	}
	
	public void printDrawingResult(Sequence s) {
		Thread t = new Thread();
		int n[] = s.getNumbers();
		System.out.print("\nwinning numbers:\t");
		
		for(int i=0; i<6; i++) {
			try { 
				t.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.print(n[i]);
			if(i<5) System.out.print("\t");
			else System.out.println();
		}		
		
		System.out.println("\nPress ENTER to return to the main menu...");
		sc.nextLine();
	}
	
	private boolean isOutOfRange(int number) {
		if( number < 1 || number > 49 ) {
			err = ErrorMessage.NumberOutOfRange;
			return true;
		}
		else return false;
	}
	
	private boolean duplicate(int number, int n[]) {
		for(int i=n.length-1; i>=0; i--) {
			if( number == n[i] ) {
				err = ErrorMessage.DuplicateNumber;
				return true;
			}
		}
		return false;
	}

	private void printErrorMessage() {
		err.show();
	}

	private boolean isFaulty(int mI, MenuState mS) {
		if( mI < 0 || mI > 3 ) {
			err = ErrorMessage.WrongMenuInput;
			return true;
		}
		else {
			switch(mS) {
				case MENU1:
					if(mI==2 || mI==3) {
						if(mI==2) err = ErrorMessage.EnterTicketsFirst;
						else err = ErrorMessage.NoDrawingYet;
						return true;
					}
					else break;
				case MENU2:
					if(mI==3) {
						err = ErrorMessage.NoDrawingYet;
						return true;
					}
					else break;
				case MENU3:
					if(mI==2) {
						err = ErrorMessage.EnterTicketsFirst;
						return true;
					}
					else break;
				default:
					System.out.println("Faulty menu stage!");
					break;
			}
			return false;
		}
	}
	
	public void close() {
		sc.close();
	}
}