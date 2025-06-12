package DiceRoll.entity;
//주사위 던진걸 객체로 저장
public class DiceRollResult {
    private final int[] dice; // 최대 3개의 주사위
    private int total;
    private String result;

    public DiceRollResult(int[] dice, int total, String result) {
        this.dice = dice;
        this.total = total;
        this.result = result;
    }

    public int[] getDice() {
        return dice;
    }

    public int getTotal() {
        return total;
    }

    public String getResult() {
        return result;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
