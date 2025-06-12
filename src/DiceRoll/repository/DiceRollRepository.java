package DiceRoll.repository;

import DiceRoll.entity.DiceRollResult;
import java.util.List;

public interface DiceRollRepository {
    void save(String player, DiceRollResult result);
    List<DiceRollResult> findByPlayer(String player);
}
