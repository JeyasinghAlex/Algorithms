public class RadixSort {

    public void RadixSort(int[] nums) {

        int minValue = getMin(nums);
        if (minValue < 0) {
            for (int i = 0; i < nums.length; ++i) {
                nums[i] -= minValue;
            }
        }

        int maxValue = getMax(nums);
        for (int pos = 1; maxValue / pos > 0; pos *= 10) {
            countSort(nums, pos);
        }

        for (int i = 0; i < nums.length; ++i) {
            nums[i] += minValue;
        }
    }

    private void countSort(int[] arr, int pos) {
        int[] temp = new int[arr.length];
        int[] count = new int[10];
        for (int i = 0; i < count.length; ++i) {
            int index = (arr[i] / pos) % 10;
            ++count[index];
        }

        for (int i = 1; i < count.length; ++i) {
            count[i] += count[i - 1];
        }

        for (int i = arr.length - 1; i >= 0; --i) {
            int rem = (arr[i] / pos) % 10;
            int index = --count[rem];
            temp[index] = arr[i];
        }

        for (int i = 0; i < temp.length; ++i) {
            arr[i] = temp[i];
        }
    }

    private int getMin(int[] nums) {

        int min = 0;
        for (int n : nums) {
            min = Math.min(min, n);
        }
        return min;
    }
    private int getMax(int[] nums) {

        int max = Integer.MIN_VALUE;
        for (int n : nums) {
            max = Math.max(max, n);
        }
        return max;
    }
}
