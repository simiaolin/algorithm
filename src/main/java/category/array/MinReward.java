package category.array;

import java.util.ArrayList;

public class MinReward {
    public static int minRewards(int[] scores) {
        // Write your code here.
        int[] rewards = new int[scores.length];
        for (int idx = 1; idx < scores.length; idx++) {
            if (scores[idx] > scores[idx - 1]) {
                rewards[idx] = rewards[idx - 1] + 1;
            }
        }
        for (int idx = scores.length - 2; idx >= 0; idx--) {
            if (scores[idx] > scores[idx + 1]) {
                rewards[idx] = Math.max(rewards[idx], rewards[idx + 1] + 1);
            }
        }
        int sumOfRewards = 0;
        for (int reward : rewards) {
            sumOfRewards += reward;
        }
        sumOfRewards += scores.length;
        return sumOfRewards;

    }

    public static void main(String[] args) {
        int[] scores = new int[]{8, 4, 2, 1, 3, 6, 7, 9, 5};
        int minScore = minRewards(scores);
        System.out.println(minScore);

    }
}
