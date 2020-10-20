import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Testing {

	@Test
	void test() {
		Hero player = new Hero();
		Hero dummy = new Hero(0, 1, 100, 100);
		player.attackOrder(player, dummy);
		assertEquals(dummy.getHealth(), 90);
	}

}
