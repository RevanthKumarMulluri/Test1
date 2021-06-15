import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DiceGame {
    public static void main(String[] args) {


        IntStream.range(0, 10000).map(i -> diceGame()).boxed().collect(Collectors.groupingBy());




    }

    public static int diceGame() {
        int startingDiceNumber = 5;
        int dice = startingDiceNumber;
        int score = 0;

        while (dice > 0) {
            List<Integer> result = rollDies(dice).stream().filter(i -> i!=3).collect(Collectors.toList());
            int currentScore;
            if(result.size() == startingDiceNumber) {
                currentScore = result.stream().mapToInt(i -> i).min().getAsInt();
                result = result.stream().filter(i -> i!=currentScore).collect(Collectors.toList());
            }else {
                currentScore = 0;
            }
            System.out.println(currentScore);
            score = score +currentScore;
            dice = result.size();
        }
        return score;
    }

    public static List<Integer> rollDies(int n) {
        return IntStream.range(0, n).map(i -> (int) (Math.random() * 6) + 1).boxed().collect(Collectors.toList());
    }
}
