
public class Main {

	public static void main(String[] args) {
		
		Hero player = new Hero();
		Hero dummy = new Hero(20, 1, 100, 100);
		player.attackOrder(player, dummy);
		player.defenseOrder(player, dummy);
		player.magicAttack(player, dummy);
		System.out.println(player.getHealth());
		System.out.println(dummy.getHealth());
		
	}
}
	
