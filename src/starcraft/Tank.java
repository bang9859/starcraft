package starcraft;

public class Tank extends GroundUnit implements Repairable{
	private static String name = "TANK";
	private static int hp = 10;
	private int damage = 50;
	
	public Tank() {
		super(name, hp);
	}

	@Override
	public void attack(Unit unit) {
		if(hp==0) {
			System.out.println("체력이 없어 공격할 수 없습니다.");
			return;
		}
		Unit target = (Unit)unit;
		if(target.hp-damage<0) {
			target.hp =0;
		}else {
			target.hp-=damage;
		}
	}

}
