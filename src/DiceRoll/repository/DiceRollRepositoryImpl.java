package DiceRoll.repository;

import DiceRoll.entity.DiceRollResult;
import java.util.*;

public class DiceRollRepositoryImpl implements DiceRollRepository {
    private final Map<String, List<DiceRollResult>> storage = new HashMap<>();

    @Override
    public void save(String player, DiceRollResult result) {
        storage.computeIfAbsent(player, k -> new ArrayList<>()).add(result);
    }

    @Override
    public List<DiceRollResult> findByPlayer(String player) {
        return storage.getOrDefault(player, Collections.emptyList());
    }
}
