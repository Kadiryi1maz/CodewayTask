import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int rounds;
        do {
            System.out.print("Enter Number of Rounds: ");
            rounds = scanner.nextInt();
        } while (rounds < 1 || rounds > 99);

        int[] totalPoints = new int[3];

        for (int round = 1; round <= rounds; round++) {
            int[] diceRolls = new int[3];

            for (int i = 0; i < 3; i++) {
                diceRolls[i] = random.nextInt(6) + 1;
            }

            if (diceRolls[0] == diceRolls[1] && diceRolls[1] == diceRolls[2]) { // 
                for (int i = 0; i < 3; i++) {
                    totalPoints[i] += diceRolls[i];
                }
            } else if (diceRolls[0] != diceRolls[1] && diceRolls[1] != diceRolls[2] && diceRolls[0] != diceRolls[2]) { // 
                for (int i = 0; i < 3; i++) {
                    totalPoints[i] += diceRolls[i];
                }
            } else {
                int sameNumber = diceRolls[0];
                if (diceRolls[1] == sameNumber) {
                    sameNumber = diceRolls[1];
                } else if (diceRolls[2] == sameNumber) {
                    sameNumber = diceRolls[2];
                } else {
                    sameNumber = diceRolls[1];
                }

                for (int i = 0; i < 3; i++) {
                    if (diceRolls[i] == sameNumber) {
                        totalPoints[i] += sameNumber * 2;
                    } else {
                        totalPoints[i] += diceRolls[i];
                    }
                }
            }


            System.out.printf("ROUND | DICE1 | DICE2 | DICE3 | TOTAL1 | TOTAL2 | TOTAL3\n");
            System.out.printf("%5d | %5d | %5d | %5d | %6d | %6d | %6d\n", round, diceRolls[0], diceRolls[1], diceRolls[2], totalPoints[0], totalPoints[1], totalPoints[2]);
        }
    }
}
