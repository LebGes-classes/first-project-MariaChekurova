import java.util.Scanner;

public class GameController {
    private boolean isGameGoing;
    private int playerX;
    private int playerY;

    public GameController() {
        playerX = 1;
        playerY = 1;
        isGameGoing = true;
    }

    public void setIsGameGoing(boolean isGameGoing) {
        this.isGameGoing = isGameGoing;
    }

    public static void claerConsole() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception E) {
            System.out.println(E);
        }
    }

    public void gaming() {
        char[][] field = MazeGenerator.generateMaze();
        GameField.printField(field);
        while (isGameGoing && !ifWin(playerX, playerY)) {
            Scanner scanner = new Scanner(System.in);
            char move = scanner.next().charAt(0);
            switch (move) {
                case 'w':
                    if (GameField.ifMove(playerX, playerY-1, field)) {
                        GameField.removePlayer(playerX, playerY, field);
                        claerConsole();
                        GameField.movePlayer(playerX,--playerY, field);
                    } else {System.out.println("You can't move here. There is a wall. Try again");}
                    break;
                case 's':
                    if (GameField.ifMove(playerX, playerY+1, field)) {
                        GameField.removePlayer(playerX, playerY, field);
                        claerConsole();
                        GameField.movePlayer(playerX,++playerY, field);
                    } else {System.out.println("You can't move here. There is a wall. Try again");}
                    break;
                case 'a':
                    if (GameField.ifMove(playerX - 1, playerY, field)) {
                        GameField.removePlayer(playerX, playerY, field);
                        claerConsole();
                        GameField.movePlayer(--playerX, playerY, field);
                    } else {System.out.println("You can't move here. There is a wall. Try again");}
                    break;
                case 'd':
                    if (GameField.ifMove(playerX + 1, playerY, field)) {
                        GameField.removePlayer(playerX, playerY, field);
                        claerConsole();
                        GameField.movePlayer(++playerX, playerY, field);
                    } else {System.out.println("You can't move here. There is a wall. Try again");}
                    break;
                case 'c':
                    setIsGameGoing(false);
                    break;
            }
        }
        System.out.println("You won!!! Do you want to play again?");
        System.out.println("Enter \"Y\" to play again");
        System.out.println("You won!!! Do you want to play again?");
        Scanner scanner = new Scanner(System.in);
        char answer = scanner.next().charAt(0);
        switch (answer) {
            case 'y':
                gaming();
                break;
            default:
                break;
        }
    }

    private boolean ifWin(int playerX, int playerY) {
        if (playerX == GameField.getWinX() && playerY == GameField.getWinY()) {return true;}
        else {return false;}
    }
}
