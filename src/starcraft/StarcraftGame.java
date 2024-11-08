package starcraft;

import java.util.Scanner;

public class StarcraftGame {
	private Scanner sc = new Scanner(System.in);
	
	private final int ATTACK = 1;
	private final int REPAIR = 2;
	private final int TANK = 2;
	private final int SCV = 2;
	private final int SHIP = 2;
	
	
	private Marine marin;
	private Tank tank;
	private SCV scv;
	private DropShip ship;
	
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
		showMenu();
		int sel = input("입력:");
		if(sel==ATTACK) {
			attack();
		}else if(sel == REPAIR) {
			repair();
		}else {
			System.out.println("잘못된 입력값입니다.");
		}
	}
	
	private void repair() {
		showRepairUnit();
		int sel = input("수리할 유닛 입력");
		if(sel==TANK) {
			scv.repair(tank);
		}
		if(sel==SCV) {
			scv.repair(scv);
		}
		if(sel==SHIP) {
			scv.repair(ship);
		}
	}

	private void showRepairUnit() {
		System.out.printf("1)TANK/n",tank.getHp());
		System.out.printf("2)SCV/n",scv.getHp());
		System.out.printf("3)SHIP/n",ship.getHp());
	}

	private void attack() {
		
	}

	private int input(String msg) {
		System.out.print(msg+" : ");
		String input = sc.nextLine();
		int pick = -1;
		if(!input.equals("")){
			try {
				pick = Integer.parseInt(input);
			} catch (Exception e) {
				System.err.println("숫자만 입력가능합니다.");
			}
		}
		return pick;
	}

	private void showMenu() {
		System.out.println("1)attack");
		System.out.println("2)repair");
	}
	
}
