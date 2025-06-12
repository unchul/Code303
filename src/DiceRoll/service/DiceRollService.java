package DiceRoll.service;

import DiceRoll.entity.DiceRollResult;
import DiceRoll.entity.GameBoard;

public interface DiceRollService{
    DiceRollResult playDiceTurn(String playerName, int turnNumber);
    String determineWinner(DiceRollResult p1, DiceRollResult p2);
    void showRollResult(String playerName, int diceValue);
}
