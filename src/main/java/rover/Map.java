package rover;

import java.util.Random;

public class Map {
	static Random Randomizer = new Random();
	static int x = 80;
	static int y = 20;
	static char[][] mars = new char[y][x];
	static int roverx = x / 2;
	static int rovery = y / 2;
	
	public static void Initialise() {
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				if (Randomizer.nextDouble() < 0.25 && !(roverx == i && rovery == j))
					mars[j][i] = '#';
				else mars[j][i] = ' ';
			}
		}
		mars[rovery][roverx] = '^';
	}

	public static void MapRender() {
		int MaxX = mars[0].length-1;
		int MaxY = mars.length-1;
		for (int j = 0; j < MaxY; j++) {
			for (int i = 0; i < MaxX; i++) {
				char Object = mars[j][i];
				System.out.print(Object);
			}
			System.out.println();
		}
		for (int i = 0; i < MaxX; i++) {
			System.out.print("=");
		}
		System.out.println();
	}

}
