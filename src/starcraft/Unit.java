package starcraft;

abstract public class Unit {
	final int MAX_HP;
	int hp;
	String name;
	Unit (String name,int hp){
		MAX_HP = hp;
		this.name = name;
		this.hp = hp;
	}
	
}
