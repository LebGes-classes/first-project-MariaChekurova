class GameField {
    private static char wall = '*';
    private static char pass = ' ';
    private static char player = '@';
    private static int height = 11;
    private static int width = 12;
    private static int winX = 1;
    private static int winY = 10;

    public static int getWinX() {
        return winX;
    }

    public static int getWinY() {
        return winY;
    }

    public static int getHeight() {
        return height;
    }

    public static int getWidth() {
        return width;
    }

    public static void printField(char[][] field) {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print(field[i][j]);
            }
            System.out.println();
        }
    }

    public static void removePlayer(int playerX, int playerY, char[][] field) {
        field[playerY][playerX] = pass;
    }

    public static boolean ifMove(int playerX, int playerY, char[][] field) {
        if (playerX < width && playerY < height && field[playerY][playerX] == pass) {return true;}
        else {return false;}
    }

    public static void movePlayer(int playerX, int playerY, char[][] field) {
        field[playerY][playerX] = player;
        printField(field);
    }

}
