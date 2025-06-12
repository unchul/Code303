package DiceRoll.repository;

import DiceRoll.entity.DiceRollResult;
import java.util.List;
//저장한 객체들을 사용하기 위한 인터페이스의 싱글톤화
public interface DiceRollRepository {
    void save(String player, DiceRollResult result);
    List<DiceRollResult> findByPlayer(String player);
}
