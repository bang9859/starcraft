package starcraft;

public class DropShip extends AirUnit implements Repairable{
	private static String name = "SHIP";
	private static int hp = 100;
	
	public int getHp() {
		return hp;
	}
	
	public DropShip() {
		super(name, hp);
	}
	
}
//