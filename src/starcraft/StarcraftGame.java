package starcraft;

public class StarcraftGame {
	Marine marin;
	Tank tank;
	SCV scv;
	DropShip ship;
	
	private StarcraftGame(){
		
	}
	private static StarcraftGame instance = new StarcraftGame();
	
	public static StarcraftGame getInstance() {
		return instance;
	}
	
	public void run() {
		setUnit();
		while(true) {
			play();
		}
	}
	
	private void setUnit() {
		marin = new Marine();
		tank = new Tank();
		scv = new SCV();
		ship = new DropShip();
	}

	private void play() {
		
	}
	
	
	
}
