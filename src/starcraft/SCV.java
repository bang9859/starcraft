package starcraft;

public class SCV extends GroundUnit implements Repairable{

	public SCV(String name,int hp){
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
}
