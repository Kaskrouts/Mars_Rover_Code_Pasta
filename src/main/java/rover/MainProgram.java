package rover;

public class MainProgram extends Rover {

	public static void main(String[] args) {

		if (args.length > 1) {
			long seed = Long.parseLong(args[1]);
			Randomizer.setSeed(seed);
			// System.out.println("Seed: " + seed);
		}
		Initialise();
		String Moveset = args[0];
		MapRender();
		AvoidCollision(Moveset);
	}
	

}
