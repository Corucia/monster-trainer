
public enum Orientation {
	NORTH, EAST, SOUTH, WEST;
	public String toString() {
		return "" + name().charAt(0);
	}
	
	Orientation turnRight() {
		return values()[(ordinal() + 1) % values().length];
	}
	
	Orientation turnLeft() {
		return values()[(ordinal() - 1 + values().length) % values().length];
	}
}