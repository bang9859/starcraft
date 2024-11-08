package starcraft;

public class DropShip extends AirUnit implements Repairable{
	protected static String name = "SHIP";
	protected static int hp = 100;
	public DropShip() {
		super(name, hp);
	}
	
}
