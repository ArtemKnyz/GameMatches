package Logic;
import java.util.Scanner;

 class PlayersLogic {
    private int counterMovePlayer;
    int movePlayer() {
        Scanner scanner = new Scanner(System.in);
        boolean checkMovePlayer = false;
        while (!checkMovePlayer) {
            System.out.print(" - Ход игрока. Введите количество спичек: ");
            try {
                counterMovePlayer = scanner.nextInt();
            } catch (Exception ex) {
                scanner.nextLine();
                System.err.print("Ввести нужно цифру! ");
                System.out.println("");
                continue;
            }
            if (checkValue(counterMovePlayer)) {
                System.err.print("Количество спичек должно быть от 1 до 3 ");
                System.out.println("");
                continue;
            }
            checkMovePlayer = true;
        }
        return counterMovePlayer;
    }

    int moveMagistrMatches(int n) {
        switch (n % 4) {
            case 1, 2 -> {
                return 1;
            }
            case 3 -> {
                return 2;
            }
        }
        return 3;
    }

     boolean checkValue(int variable) {
        return (variable < 1 || variable > 3)?true:false;
    }
}


