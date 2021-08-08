public class QuickSort {

    public void quickSort(int[] nums, int start, int end) {

        if (start < end) {
            int point = partition(nums, start, end);
            quickSort(nums, start, point - 1);
            quickSort(nums, point + 1, end);
        }
    }

    private int partition(int[] nums, int lo, int hi) {

        int startIdx = lo;
        int start = lo;
        int end = hi;
        int pivot = nums[lo];
        while (start < end) {

            while (start <= hi && nums[start] <= pivot) {
                ++start;
            }
            while (end >= lo && nums[end] > pivot) {
                --end;
            }

            if (start < end) {
                swap(nums, start, end);
            }
        }
        swap(nums, startIdx, end);
        return end;
    }

    private void swap(int[] nums, int start, int end) {

        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
    }
}
