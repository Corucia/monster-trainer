import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class TrainerTest {
	@Test
	public void should_move_south() throws Exception {
		// Arrange
		Trainer trainer = new Trainer("toto", 1, 1, Orientation.SOUTH);
		
		// Act
		trainer.move(Move.FORWARD);
		
		// Assert
		assertThat(trainer.toString()).isEqualTo("toto 1-2 S, 0 monster(s)");
	}
	
	@Test
	public void hunter_should_starts_with_name() throws Exception {
		// Arrange
		Trainer trainer = new Trainer("Michel", 1, 1, Orientation.SOUTH);
		
		// Assert
		assertThat(trainer.toString()).isEqualTo("Michel 1-1 S, 0 monster(s)");
	}
	
	@Test
	public void should_move_north() throws Exception {
		// Arrange
		Trainer trainer = new Trainer("toto", 1, 2, Orientation.NORTH);
		
		// Act
		trainer.move(Move.FORWARD);
		
		// Assert
		assertThat(trainer.toString()).isEqualTo("toto 1-1 N, 0 monster(s)");
	}
	
	@Test
	public void should_move_east() throws Exception {
		// Arrange
		Trainer trainer = new Trainer("toto", 2, 2, Orientation.EAST);
		
		// Act
		trainer.move(Move.FORWARD);
		
		// Assert
		assertThat(trainer.toString()).isEqualTo("toto 3-2 E, 0 monster(s)");
	}
	
	@Test
	public void should_move_west() throws Exception {
		// Arrange
		Trainer trainer = new Trainer("toto", 2, 2, Orientation.WEST);
		
		// Act
		trainer.move(Move.FORWARD);
		
		// Assert
		assertThat(trainer.toString()).isEqualTo("toto 1-2 W, 0 monster(s)");
	}
	
	@Test
	public void should_move_twice() throws Exception {
		// Arrange
		Trainer trainer = new Trainer("toto", 2, 2, Orientation.EAST);
		
		// Act
		trainer.move(Move.FORWARD, Move.FORWARD);
		
		// Assert
		assertThat(trainer.toString()).isEqualTo("toto 4-2 E, 0 monster(s)");
	}
	
	@Test
	public void should_turn_right_facing_south() throws Exception {
		assertTurningRight(Orientation.SOUTH, Orientation.WEST);
	}
	
	@Test
	public void should_turn_right_facing_north() throws Exception {
		assertTurningRight(Orientation.NORTH, Orientation.EAST);
	}
	
	@Test
	public void should_turn_right_facing_east() throws Exception {
		assertTurningRight(Orientation.EAST, Orientation.SOUTH);
	}
	
	@Test
	public void should_turn_right_facing_west() throws Exception {
		assertTurningRight(Orientation.WEST, Orientation.NORTH);
	}
	
	@Test
	public void should_turn_left_facing_south() throws Exception {
		assertTurningLeft(Orientation.SOUTH, Orientation.EAST);
	}
	
	@Test
	public void should_turn_left_facing_west() throws Exception {
		assertTurningLeft(Orientation.WEST, Orientation.SOUTH);
	}
	
	@Test
	public void should_turn_left_facing_north() throws Exception {
		assertTurningLeft(Orientation.NORTH, Orientation.WEST);
	}
	
	@Test
	public void should_turn_left_facing_east() throws Exception {
		assertTurningLeft(Orientation.EAST, Orientation.NORTH);
	}
	
	private void assertTurningRight(Orientation start, Orientation expected) {
		// Arrange
		Trainer trainer = new Trainer("toto", 2, 2, start);
		
		// Act
		trainer.move(Move.TURN_RIGHT);
		
		// Assert
		assertThat(trainer.toString()).isEqualTo("toto 2-2 " + expected.toString() + ", 0 monster(s)");
	}
	
	private void assertTurningLeft(Orientation start, Orientation expected) {
		// Arrange
		Trainer trainer = new Trainer("toto", 2, 2, start);
		
		// Act
		trainer.move(Move.TURN_LEFT);
		
		// Assert
		assertThat(trainer.toString()).isEqualTo("toto 2-2 " + expected.toString() + ", 0 monster(s)");
	}
}
