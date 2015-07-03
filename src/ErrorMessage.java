
public enum ErrorMessage {
	// Menu
	WrongMenuInput("Please choose a number from 0 to 3: "),
	EnterTicketsFirst("Before you can do a new drawing, you have to enter some tickets.\n"
			+ "Please enter [0-3]: "),
	NoDrawingYet("There has not been a drawing yet.\nPlease enter [0-3]: "),
		
	// Enter ticket
	NumberOutOfRange("You can only type numbers from 1 to 49: "),
	DuplicateNumber("You have already guessed this number.\nPlease choose another one: "),
	WrongTicketInput("Press 'Y' to add another ticket.\nPress 'N' to return to the main menu.\n");
	
	private String message;
	
	ErrorMessage(String msg) {
		message = msg;
	}
	
	void show() {
		System.out.print(message);
	}
}
