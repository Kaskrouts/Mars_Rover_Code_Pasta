package rover;

public class Rover extends Map {

	public static void Vertical_Lateral_Movement(char Direction) {
		char Orientation = mars[rovery][roverx];
		if (Direction == 'f' || Direction == 'b') { 
			mars[rovery][roverx] = ' ';
			switch (Direction) {
			case 'f' :
				switch (Orientation) {
			
				case '^':
					rovery--;
					break;
				case 'V' :
					rovery++;
					break;
				case '>' :
					roverx++;
					break;
				case '<' :
					roverx--;
					break;
				}			
				break;
			
			case 'b' :
				switch(Orientation) {
				case '^' :
					rovery++;
					break;
				case 'V' :
					rovery--;
					break;
				case '>' :
					roverx--;
					break;
				case '<' :
					roverx++;
					break;
				}
				break;
			}
			mars[rovery][roverx] = Orientation;	
		}
		else Rotation_Movement (Direction);
	}

	public static void Rotation_Movement(char Direction) {
		char Orientation = mars[rovery][roverx] ;		
		switch (Direction) {
		case 'l' :
			switch(Orientation) {
			case '^' :
				mars[rovery][roverx] = '<';
				break;
			case 'V' :
				mars[rovery][roverx] = '>';
				break;
			case '>' :
				mars[rovery][roverx] = '^';
				break;
			case '<' :
				mars[rovery][roverx] = 'V';
				break;
			}
			break;
		case 'r' :
			switch(Orientation) {
			case '^' :
				mars[rovery][roverx] = '>';
				break;
			case 'V' :
				mars[rovery][roverx] = '<';
				break;
			case '>' :
				mars[rovery][roverx] = 'V';
				break;
			case '<' :
				mars[rovery][roverx] = '^';
				break;
			}
			break;
		}
	}
	
	// Method used to detect the object located directly in front or behind the rover
	// and checks if the Rover is at the edge of the map
	private static boolean Radar (char Direction, char Orientation) {
		switch(Direction) {
		case 'f':
			switch (Orientation) {
			case '^':
				return (mars[rovery-1][roverx] == '#' || rovery == 0);			
			case 'V' :
				return (mars[rovery+1][roverx] == '#' || rovery == mars.length-1);
			case '>' :
				return (mars[rovery][roverx+1] == '#' || roverx == mars[0].length-1);
			case '<' :
				return (mars[rovery][roverx-1] == '#' || roverx == 0);  
			}
		case 'b':
			switch (Orientation) {
			case '^':
				return (mars[rovery+1][roverx] == '#' || rovery == mars.length - 1);				
			case 'V' :
				return (mars[rovery-1][roverx] == '#' || rovery == 0);
			case '>' :
				return (mars[rovery][roverx-1] == '#' || roverx == 0);
			case '<' :
				return (mars[rovery][roverx+1] == '#' || roverx == mars[0].length-1); 
			}
		}
	return false;
	}
	
	//Method that uses the Radar Method to detect the Object in front of the Rover
	//and skips the set of the same movement leading to a collision
	//the printed messages may help get a better understanding of the Method
	protected static void AvoidCollision(String Moveset) {
		for (int i = 0; i < Moveset.length(); i++) {
			try {
				if (Radar(Moveset.charAt(i), mars[rovery][roverx]) && i != Moveset.length()-1) {
					while (Moveset.charAt(i) == Moveset.charAt(i+1)) i++;
					System.out.print("detected collision when executing the <" + Moveset.charAt(i) + "> Movement"); 
					System.out.println("... Skipping the remaining <" + Moveset.charAt(i) + "> movements");
				}
				else {
					Vertical_Lateral_Movement(Moveset.charAt(i));
					System.out.println("executing the <" + Moveset.charAt(i) + "> movement" );						
					MapRender();
					}
				}
			catch (Exception e) {/*System.out.println("Skipping the remaining <" + Moveset.charAt(i) + "> movements");*/}
			
			}
		}
	
}
