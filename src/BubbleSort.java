public class BubbleSort {

    public void bubbleSort(int[] arr) {

        for (int i = 0; i < arr.length - 1; ++i) {
            boolean flag = true;
            for (int j = i + 1; j < arr.length; ++j) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                    flag = false;
                }
            }
            if (flag) break;
        }
    }
}
