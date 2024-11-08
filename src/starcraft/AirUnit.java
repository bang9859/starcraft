package starcraft;

abstract public class AirUnit extends Unit implements Repairable{
	AirUnit(String name, int hp){
		super(name,hp);
	}
}
