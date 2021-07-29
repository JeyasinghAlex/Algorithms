public class CountingSort {


    public static void main(String[] args) {
        int[] arr = {1, 100000};
        new CountingSort().countingSort(arr);
    }

    private void countingSort(int[] nums) {

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int n : nums) {
            min = Math.min(min, n);
        }

        if (min < 0) {
            for (int i = 0; i < nums.length; ++i) {
                nums[i] = nums[i] - min;
            }
        }

        for (int n : nums) {
            max = Math.max(max, n);
        }

        int[] count = new int[max + 1];
        for (int n : nums) {
            count[n]++;
        }

        for (int i = 1; i < count.length; ++i) {
            count[i] += count[i - 1];
        }

        int[] temp = new int[nums.length];
        for (int i = nums.length - 1; i >= 0; --i) {
            temp[--count[nums[i]]] = nums[i] + min;
        }
    }
}
