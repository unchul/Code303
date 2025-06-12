package DiceRoll.service;

import DiceRoll.entity.DiceRollResult;
import DiceRoll.entity.GameBoard;
import java.util.Random;

public class DiceRollServiceImpl implements DiceRollService {

    private static DiceRollServiceImpl instance;
    private final Random rand = new Random();

    private DiceRollServiceImpl() {}

    public static DiceRollServiceImpl getInstance() {
        if (instance == null) {
            instance = new DiceRollServiceImpl();
        }
        return instance;
    }

    @Override
    public DiceRollResult playDiceTurn(String playerName, int turnNumber) {
        int[] rolls = new int[turnNumber];
        int total = 0;
        String result = "OK";

        for (int i = 0; i < turnNumber; i++) {
            rolls[i] = rand.nextInt(6) + 1;
            showRollResult(playerName, rolls[i]);
            total += rolls[i];
        }

        if (turnNumber == 3) {
            if (rolls[2] == 3) result = "Stole";
            else if (rolls[2] == 4) {
                result = "Dead";
                total = rolls[0] + rolls[1]; // Only first two dice
            }
        }

        return new DiceRollResult(rolls, total, result);
    }

    @Override
    public void showRollResult(String playerName, int diceValue) {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println(playerName + " 주사위 결과 ▶ " + diceValue);
    }

    @Override
    public String determineWinner(DiceRollResult p1, DiceRollResult p2) {
        if (p1.getResult().equals("Dead")) return "플레이어 2의 승리!";
        if (p2.getResult().equals("Dead")) return "플레이어 1의 승리!";

        return p1.getTotal() > p2.getTotal() ? "플레이어 1의 승리!" :
                p2.getTotal() > p1.getTotal() ? "플레이어 2의 승리!" : "무승부!";
    }
}
