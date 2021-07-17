public class MergeSort {

    public void mergeSort(int[] arr) {
        int n = arr.length;
        if (n < 2) {
            return ;
        }
        int mid = n >> 1;
        int[] left = new int[mid];
        int[] right = new int[n - mid];

        for (int i = 0; i < mid; ++i)
            left[i] = arr[i];
        for (int i = mid; i < n; ++i)
            right[i - mid] = arr[i];

        mergeSort(left);
        mergeSort(right);
        merge(arr, left, right);
    }

    public void merge(int[] arr, int[] left, int[] right) {

        int i = 0;
        int j = 0;
        int k = 0;
        while (i < left.length && j < right.length) {

            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }

        while (i < left.length) {
            arr[k++] = left[i++];
        }
        while (j < right.length) {
            arr[k++] = right[j++];
        }
    }
}
