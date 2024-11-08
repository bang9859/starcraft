package starcraft;

import java.util.Scanner;

public class StarcraftGame {
	private Scanner sc = new Scanner(System.in);

	private final int ATTACK = 1;
	private final int REPAIR = 2;
	private final int TANK = 1;
	private final int SCV = 2;
	private final int SHIP = 3;
	private final int MARINE = 4;

	private Marine marine;
	private Tank tank;
	private SCV scv;
	private DropShip ship;

	private StarcraftGame() {

	}

	private static StarcraftGame instance = new StarcraftGame();

	public static StarcraftGame getInstance() {
		return instance;
	}

	public void run() {
		setUnit();
		while (true) {
			play();
		}
	}

	private void setUnit() {
		marine = new Marine();
		tank = new Tank();
		scv = new SCV();
		ship = new DropShip();
	}

	private void play() {
		showMenu();
		int sel = input("입력:");
		if (sel == ATTACK) {
			attack();
		} else if (sel == REPAIR) {
			repair();
		} else {
			System.out.println("잘못된 입력값입니다.");
		}
	}

	private void repair() {
		showRepairUnit();
		int sel = input("수리할 유닛 입력");
		if (sel == TANK) {
			scv.repair(tank);
		}
		if (sel == SCV) {
			scv.repair(scv);
		}
		if (sel == SHIP) {
			scv.repair(ship);
		}
	}

	private void showRepairUnit() {
		System.out.printf("1)TANK\n", tank.getHp());
		System.out.printf("2)SCV\n", scv.getHp());
		System.out.printf("3)SHIP\n", ship.getHp());
	}

	private void attack() {
		showTargetUnitMenu();
		Unit target = inputTarget();
		if (target.equals(null)) {
			System.out.println("잘못된 입력값입니다.");
			return;
		}
		showAttackUnitMenu();
		inputAttacker(target);
		System.out.printf("%s [%d,%d]\n",target.name,target.hp,target.MAX_HP);
		
	}

	private void showTargetUnitMenu() {
		System.out.println("1)TANK");
		System.out.println("2)SCV");
		System.out.println("3)DROPSHIP");
		System.out.println("4)MARINE");
	}

	private Unit inputTarget() {
		int sel = input("타겟 선택");
		if (sel == TANK) {
			return (Unit)tank;
		} else if (sel == SCV) {
			return (Unit)scv;
		} else if (sel == SHIP) {
			return (Unit)ship;
		} else if (sel == MARINE) {
			return (Unit)marine;
		}
		return null;
	}

	private void inputAttacker(Unit target) {
		int sel = input("유닛 선택");
		if (sel == 1) {
			 tank.attack(target);
		} else if (sel == 2) {
			 marine.attack(target);
		} else if (sel == 3) {
			 scv.attack(target);
		}
	}

	private void showAttackUnitMenu() {
		System.out.println("1)TANK");
		System.out.println("2)MARINE");
		System.out.println("3)SCV");
	}

	private int input(String msg) {
		System.out.print(msg + " : ");
		String input = sc.nextLine();
		int pick = -1;
		if (!input.equals("")) {
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
