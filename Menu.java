import java.util.Scanner;

class Menu {
    private Scanner scanner = new Scanner(System.in);
    private GameController gameController = new GameController();

    public void showMenu() {
        System.out.println("========MENU========");
        System.out.println("Choose 1 to start the maze game");
        System.out.println("Choose 0 to close the maze game");
        int button = scanner.nextInt();

        switch (button) {
            case 1:
                System.out.println("Move using these commands:");
                System.out.println("\"W\" to move up");
                System.out.println("\"S\" to move down");
                System.out.println("\"A\" to move left");
                System.out.println("\"D\" to move right");
                System.out.println("\"C\" to close the game");
                System.out.println("\"E\" is the exit. Move to this cell to win");
                break;
            case 0:
                System.out.println("enter 1 to play this game pls");
                gameController.setIsGameGoing(false);
                break;
            default:
                System.out.println("you are stupid to play this game, it's so good that you don't have to.");
                gameController.setIsGameGoing(false);
                break;
        }
        gameController.gaming();
    }

}
