package labyrinth;

public class Labirynt {

    private int x;
    private int y;
    private int walls;
    private int[][] labirynt;
    private boolean path = true;
    private int choiceStep = 1;
    private final int[] STEPX = { 0, 1, 0, -1 };
    private final int[] STEPY = { 1, 0, -1, 0 };

    Labirynt () {
	this.x = 10;
	this.y = 10;
	this.walls = y / 2;
	createLabirynt(x, y, walls);
    }

    Labirynt (int x, int y) {
	this.x = x + 2;
	this.y = y + 2;
	this.walls = y / 2;
	createLabirynt(x, y, walls);
    }

    private void createLabirynt (int x, int y, int walls) {
	labirynt = new int[x][y];
	while (path) {
	    for (int i = 0; i < x; i++) {
		int wall = 0;
		for (int j = 0; j < y; j++) {
		    if (j == 0 || j == labirynt[j].length - 1 || i == 0 || i == labirynt[i].length - 1) {
			labirynt[i][j] = -1;
		    }
		    if ((i == 1 && j == 1) || (i == x - 2 && j == y - 2)) {
			labirynt[i][j] = 0;
		    } else if (wall != walls && labirynt[i][j] == 0) {
			if ((int) (Math.random() * 100) < 30) {
			    labirynt[i][j] = -1;
			    wall++;
			}
		    }

		}
	    }
	    passageLabirynt(1, 1);
	}
    }

    private boolean passageLabirynt (int xL, int yL) {
	while (true) {
	    labirynt[xL][yL] = choiceStep;
	    if (xL == labirynt[xL].length - 2 && yL == labirynt[yL].length - 2) {
		choiceStep--;
		return path = false;
	    } else {
		for (int i = 0; i <= 3; i++) {
		    if (labirynt[xL + STEPX[i]][yL + STEPY[i]] == 0) {
			choiceStep++;
			passageLabirynt(xL + STEPX[i], yL + STEPY[i]);
		    }
		}
		choiceStep--;
		return path = false;
	    }
	}
    }

    public void printLabirynt () {
	for (int i = 1; i < labirynt[i].length - 1; i++) {
	    for (int j = 1; j < labirynt[j].length - 1; j++) {
		if (j == labirynt[j].length - 2) {
		    System.out.println(labirynt[i][j]);
		} else {
		    System.out.print(labirynt[i][j] + "	");
		}
	    }
	}
	System.out.println("\n\n\n");
    }
}
