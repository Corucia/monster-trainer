public class Trainer {
	
	private int x;
	private int y;
	private String name;
	private Orientation orientation;
	
	public Trainer(String name, int x, int y, Orientation orientation) {
		this.name = name;
		this.x = x;
		this.y = y;
		this.orientation = orientation;
	}
	
	public void move(Move... moves) {
		for (Move move : moves) {
			switch (move) {
				case TURN_RIGHT:
					orientation = orientation.turnRight();
					break;
				case TURN_LEFT:
					orientation = orientation.turnLeft();
					break;
				case FORWARD:
					moveForward();
					break;
			}
		}
	}
	
	private void moveForward() {
		switch (orientation) {
			case NORTH:
				y--;
				break;
			case SOUTH:
				y++;
				break;
			case EAST:
				x++;
				break;
			case WEST:
				x--;
				break;
		}
	}
	
	@Override
	public String toString() {
		return name + " " + x + "-" + y + " " + orientation + ", 0 monster(s)";
	}
	
}