import java.util.Scanner;

public class MaximumSubarray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int maxSoFar = nums[0];
        int currentMax = nums[0];

        for (int i = 1; i < n; i++) {
            currentMax = Math.max(nums[i], currentMax + nums[i]);
            maxSoFar = Math.max(maxSoFar, currentMax);
        }

        System.out.println(maxSoFar);
        sc.close();
    }
}