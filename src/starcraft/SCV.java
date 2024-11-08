package starcraft;

public class SCV extends GroundUnit implements Repairable{
	protected static String name = "SCV";
	protected static int hp = 80;
	private int damage = 10;
	public SCV(){
		super(name,hp);
	}
	
	public void repair(Repairable unit) {
		if(unit instanceof Unit) {
			Unit target = (Unit)unit;
			while(target.hp>target.MAX_HP) {
				String msg = String.format("%s [%d/%d] 수리중...", target.name,target.hp++,target.MAX_HP);
				System.out.println(msg);
				try {
					Thread.sleep(300);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			System.out.printf("%s 수리완료!\n",target.name);
		}
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
