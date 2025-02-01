import java.util.Random;

public class MazeGenerator {

    private static int height = 11;
    private static int width = 12;
    private static char wall = '*';
    private static char pass = ' ';
    private static char player = '@';
    private static char finish = 'E';

    public static char[][] generateMaze() {
        char[][] maze = new char[height][width];
        Random random = new Random();
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                maze[y][x] = wall;
            }
        }
        maze[0][0] = player;
        maze[1][0] = pass;
        maze[height - 1][width - 1] = finish;
        return generatePath(1, 1, maze);
    }

    private static char[][] generatePath(int x, int y, char[][] maze) {
        Random rand = new Random();
        int[] dirs = {0, 1, 2, 3};
        shuffle(dirs);

        for (int dir : dirs) {
            int nx = x, ny = y;
            switch (dir) {
                case 0: nx = x - 2; break;
                case 1: ny = y + 2; break;
                case 2: nx = x + 2; break;
                case 3: ny = y - 2; break;
            }

            if (isInBounds(nx, ny) && maze[nx][ny] == wall) {
                maze[nx][ny] = pass;
                maze[(x + nx) / 2][(y + ny) / 2] = pass;
                generatePath(nx, ny, maze);
            }
        }
        return maze;
    }

    private static void shuffle(int[] dirs) {
        Random rand = new Random();
        for (int i = dirs.length - 1; i > 0; i--) {
            int j = rand.nextInt(i + 1);
            int temp = dirs[i];
            dirs[i] = dirs[j];
            dirs[j] = temp;
        }
    }
    private static boolean isInBounds(int x, int y) {
        return x > 0 && x < width - 1 && y > 0 && y < height - 1;
    }

}
