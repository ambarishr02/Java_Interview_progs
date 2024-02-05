package TwoPointers;

public class PairAndTargetSum {

    public static int[] pairSum(int arr[], int target) {
        int end = arr.length - 1;
        int left = 0;
        while (left < end) {
            int currentSum = arr[left] + arr[end];
            if (currentSum == target)
                return new int[] { left, end };
            if (currentSum > target) {
                end--;
            }
            if (currentSum < target) {
                left++;
            }
        }
        return new int[] { -1, -1 };
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 6 };
        int result[] = pairSum(arr, 6);
        System.out.println(result[0] + " " + result[1]);
    }
}
