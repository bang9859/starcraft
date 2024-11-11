package starcraft;

abstract public class Unit {
	protected final int MAX_HP;
	int hp;
	String name;
	protected Unit (String name,int hp){
		MAX_HP = hp;
		this.name = name;
		this.hp = hp;
	}
	
}
//