
public class Game {

	int grid[][] = new int[10][10];
	int state = 0;

	public Game() {

		grid[5][5] = 1;
		grid[5][3] = 1;
		grid[5][4] = 1;

		System.out.println("Intial State");
		printGrid();
		state++;
	}

	void nextState() {
		checkResize();
		int newGrid[][] = new int[grid.length][grid.length];
		for (int i = 1; i < grid.length - 1; i++) {
			for (int j = 1; j < grid.length - 1; j++) {

		
				switch (numOfNeighbours(i, j)) {
				case 0:
					newGrid[i][j] = 0;
					break;
				case 1:
					newGrid[i][j] = 0;
					break;
				case 2:
					if (grid[i][j] == 1)
						newGrid[i][j] = 1;
					break;
				case 3:
					newGrid[i][j] = 1;
					break;
				case 4:
					newGrid[i][j] = 0;
					break;
				default:
					newGrid[i][j] = 0;

				}

			}

		}

		grid = newGrid;
		printGrid();
		state++;
	}

	int numOfNeighbours(int i, int j) {

		int neighbours = 0;

		for (int x = i - 1; x <= i + 1; x++) {
			for (int y = j - 1; y <= j + 1; y++) {
				if (grid[x][y] == 1)
					neighbours++;
			}
		}
		if (grid[i][j] == 1)
			neighbours--; // Ensures an alive cell itself is not counted as a neighbour
		return neighbours;
	}

	void printGrid() {
		System.out.println("State " + state);
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid.length; j++) {
				if (grid[i][j] == 0)
					System.out.print(" + ");
				else
					System.out.print(" • ");
			}
			System.out.println();
		}
		System.out.println();

	}

	void checkResize() {
		for (int i = 0; i < grid.length; i++) {

			for (int j = 0; j < grid[i].length; j++) {
				if ((i == 0 || j == 0 || i == grid.length - 1 || j == grid[i].length - 1) && grid[i][j] == 1) {
					System.out.println("Resize needed");
					resize();

				}
			}
		}

	}

	void resize() {
		int newSize = grid.length + 2;
		int newGrid[][] = new int[newSize][newSize];

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid.length; j++) {
				newGrid[i + 1][j + 1] = grid[i][j];
			}

		}
		grid = newGrid;
	}

}
