import java.util.ArrayList;


public class Session {

	private Sequence winnerSequence;
	private ArrayList<Ticket> tickets;
	private MenuState menuState;
	
	
	public Session() {
		winnerSequence = new Sequence();
		tickets = new ArrayList<Ticket>();
		setMenuState(MenuState.MENU1);
	}
	
	public ArrayList<Ticket> getTickets() {
		return tickets;
	}
	
	public MenuState getMenuState() {
		return menuState;
	}

	public void setMenuState(MenuState menuState) {
		this.menuState = menuState;
	}


	private void fillTickets(IOHandler io) {
		do {
			Ticket t = io.enterTicket();
			tickets.add(t);
		} while(io.addAnotherTicket());
	}

	private void drawSequence(IOHandler io) {
		RandomSequenceGenerator rsg = new RandomSequenceGenerator();
		winnerSequence = rsg.generate();
		io.printDrawingResult(winnerSequence);	
	}

	private void showResult(IOHandler io) {
		for(int i=0; i<tickets.size(); i++) {
			tickets.get(i).countHits(winnerSequence);
			tickets.get(i).print();
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		IOHandler io = new IOHandler();
		
		Session session = new Session();
		
		do {
			io.printMenu(session.getMenuState());
			switch(io.getMenuInput()) {
				case 1: // enter ticket
					if(!( session.getMenuState()==MenuState.MENU1) ) session = new Session();
					session.fillTickets(io);
					session.setMenuState(MenuState.MENU2);
					break;
				case 2: // drawing
					session.drawSequence(io);
					session.setMenuState(MenuState.MENU3);
					break;
				case 3: // show result
					session.showResult(io);
					break;
				default:
					break;
			}
		} while(io.getMenuInput() != 0);
		
		io.close();
		System.exit(0);
	}
}
