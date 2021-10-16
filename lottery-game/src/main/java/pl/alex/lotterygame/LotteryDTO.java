package pl.alex.lotterygame;

import java.util.List;

public class LotteryDTO {
    List<Integer> received;
    List<Integer> random;
    List<Integer> winnerNumbers;

    public LotteryDTO(List<Integer> received, List<Integer> random, List<Integer> winnerNumbers) {
        this.received = received;
        this.random = random;
        this.winnerNumbers = winnerNumbers;
    }

    public List<Integer> getReceived() {
        return received;
    }

    public List<Integer> getRandom() {
        return random;
    }

    public List<Integer> getWinnerNumbers() {
        return winnerNumbers;
    }
}
