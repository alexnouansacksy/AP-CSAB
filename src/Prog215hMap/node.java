package Prog215hMap;

import static java.lang.System.out;

public class node {
    private int num;
    private double score1;
    private double score2;
    private double score3;
    private double score4;
    private double score5;
    private double score6;
    private double score7;
    private double score8;
    private double average;

    public node (int cnt, double one, double two, double three, double four, double five, double six, double seven, double eight) {
        num = cnt;
        score1 = one;
        score2 = two;
        score3 = three;
        score4 = four;
        score5 = five;
        score6 = six;
        score7 = seven;
        score8 = eight;
    }

    public void calc() {
        double[] nums = { score1, score2, score3, score4, score5, score6, score7, score8};
        double min = nums[0];
        double max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < min) min = nums[i];
            if (nums[i] > max) max = nums[i];
        }
        for (double a : nums) average += a;
        average -= max;
        average -= min;
        average /= (nums.length - 2);
    }

    public double getAverage() {return average;}

    public String toString() {
        return String.format("Contestant %d\n %.1f %.1f %.1f %.1f %.1f %.1f %.1f %.1f\n", num, score1, score2, score3, score4,
                score5, score6, score7, score8);
    }
}
