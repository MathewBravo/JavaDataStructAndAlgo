public class Arrays {
    public static void bubbleSort(int[] array){
        /*
        * In place sorting algorithm
        * O(n^2) time complexity
        * Do not use in practice under any circumstance unless with a very small STATIC sized array.
        * Decays extremely quickly.
        * 1'000 items takes 1'000'000 runs to sort.
        *
        * Stable
        */
        int count = 0;
        for (int unsorted = array.length - 1; unsorted > 0; unsorted--) {
            for(int i = 0; i < unsorted; i++) {
                if(array[i] > array[i+1]){
                    swap(array, i, i+1);
                }
                count ++;
            }
        }

        //System.out.println(Arrays.toString(array));
        System.out.println("Bubble Sort Passthroughs: " + count);
    }

    public static void SelectionSort(int[] array){
        /*
         * In place sorting algorithm
         * O(n^2) time complexity
         * Do not use in practice under any circumstance unless with a very small STATIC sized array.
         * Decays extremely quickly.
         * 1'000 items takes 1'000'000 runs to sort.
         * USUALLY PERFORMS BETTER THAN BUBBLE SORT
         * However, near sorted arrays will perform better using a bubble algorithm.
         * Regardless both concepts should be avoided in practice.
         *
         * Unstable, you could end up swapping elements that are the same value.
         */
        int count = 0;
        for (int unsorted = array.length - 1; unsorted > 0; unsorted--) {
            int highNum = 0;
            for(int i = 0; i <= unsorted; i++) {
                if(array[i] > array[highNum]){
                    highNum = i;
                }

                swap(array, highNum, unsorted);
                count ++;
            }
        }
        //System.out.println(Arrays.toString(array));
        System.out.println("Selection Sort Passthroughs: " + count);
    }

    public static void InsertionSort(int[] array){
        /*
         * In place sorting algorithm
         * O(n^2) time complexity
         * Do not use in practice under any circumstance unless with a very small STATIC sized array.
         * Decays extremely quickly.
         * 1'000 items takes 1'000'000 runs to sort.
         * USUALLY PERFORMS BETTER THAN BUBBLE SORT
         * However, near sorted arrays will perform better using a bubble algorithm.
         * Regardless both concepts should be avoided in practice.
         *
         * Runs almost linearly if the array is already sorted, so only use if you know the values order ahead of time
         * See Shell Sort
         * Stable
         */

        int count = 0;
        for (int unsorted = 0; unsorted < array.length; unsorted++){
            int elem = array[unsorted];
            int i;
            for (i = unsorted; i > 0 && array[i-1] > elem; i--){
                array[i] = array[i-1];
            }
            array[i] = elem;
            count++;
        }
        System.out.println(java.util.Arrays.toString(array));
        System.out.println("Insertion Sort Passthroughs: " + count);
    }

    public static void ShellSort(int[] array){
        /*
         * In place sorting algorithm
         * O(n^2) time complexity
         * Do not use in practice under any circumstance unless with a very small STATIC sized array.
         * Decays extremely quickly.
         * 1'000 items takes 1'000'000 runs to sort.
         * USUALLY PERFORMS BETTER THAN BUBBLE SORT
         * However, near sorted arrays will perform better using a bubble algorithm.
         * Regardless both concepts should be avoided in practice.
         *
         * Uses a larger gap value than Insertion Sort
         * As we run through the algorithm we lower the gap, in an attempt to reduce amount of movement required to sort.
         * Unstable
         */


        int count = 0;
        for (int gap = array.length / 2; gap > 0;gap /=2){
           for(int i  = gap; i < array.length; i++) {
               int elem = array[i];
               int j = i;
               while(j >= gap && array[j - gap] > elem){
                   array[j]  = array[j-gap];
                   j-=gap;
               }
               array[j] = elem;
               count++;
           }
        }
        System.out.println(java.util.Arrays.toString(array));
        System.out.println("Shell Sort Passthroughs: " + count);
    }

    public static void MergeSort(int[] array, int start, int end){
        if (end - start < 2) {
            return;
        }

        int mid = (start + end) / 2;
        MergeSort(array, start, mid);
        MergeSort(array, mid, end);
        mergeSortedArrays(array, start, mid, end);

        System.out.println(java.util.Arrays.toString(array));

    }

    public static void mergeSortedArrays(int[] array, int start, int mid, int end){
        // if the last element on the left side of the array is less than the first
        // element on the right side we know all the elements are less than
        if (array[mid-1] <= array[mid]) {
            return;
        }

        int i = start, j = mid, tmpIndex = 0;
        int [] temp = new int[end - start];
        while(i < mid && j < end){
            temp[tmpIndex++] = array[i] <= array[j] ? array[i++] : array[j++];
        }

        System.arraycopy(array, i, array, start + tmpIndex, mid - i);
        System.arraycopy(temp, 0, array, start, tmpIndex);

    }
    private static void swap(int[] array, int i, int j){
        if (i == j) {
            return;
        }

        int tempArr = array[i];
        array[i] = array[j];
        array[j] = tempArr;
    }
}
