public class Experiment {
    private Sorter sorter = new Sorter();
    private Searcher searcher = new Searcher();

    public long measureSortTime(int[] arr, String type) {
        if (arr == null) {
            return 0;
        }
        int[] arrCopy = arr.clone();
        long startTime = System.nanoTime();

        if (type.equalsIgnoreCase("basic")) {
            sorter.basicSort(arrCopy);
        } else if (type.equalsIgnoreCase("advanced")) {
            sorter.advancedSort(arrCopy);
        }

        long endTime = System.nanoTime();
        return endTime - startTime;
    }
    public long measureSearchTime(int[] arr, int target) {
        if (arr == null) {
            return 0;
        }
        long startTime = System.nanoTime();
        searcher.search(arr, target);
        long endTime = System.nanoTime();
        return endTime - startTime;
    }
    public void runAllExperiments() {
        System.out.println("Algorithm Performance Experiment\n");

        int[] sizes = {10, 100, 1000};
        String[] sizeLabels = {"Small", "Medium", "Large"};

        for (int i = 0; i < sizes.length; i++) {
            int size = sizes[i];
            String label = sizeLabels[i];
            System.out.println(label + " Array Size (" + size + " elements)");
            int[] randomArray = sorter.generateRandomArray(size);
            int[] sortedArray = randomArray.clone();
            sorter.advancedSort(sortedArray);
            int target = sortedArray[sortedArray.length / 2];

            long basicTimeRandom = measureSortTime(randomArray, "basic");
            long basicTimeSorted = measureSortTime(sortedArray, "basic");

            long advancedTimeRandom = measureSortTime(randomArray, "advanced");
            long advancedTimeSorted = measureSortTime(sortedArray, "advanced");

            long searchTimeRandom = measureSearchTime(randomArray, target);
            long searchTimeSorted = measureSearchTime(sortedArray, target);
            System.out.printf("Bubble Sort - Random: %8d ns, Sorted: %8d ns%n",
                    basicTimeRandom, basicTimeSorted);
            System.out.printf("Merge Sort  - Random: %8d ns, Sorted: %8d ns%n",
                    advancedTimeRandom, advancedTimeSorted);
            System.out.printf("Linear Search - Random: %8d ns, Sorted: %8d ns%n%n",
                    searchTimeRandom, searchTimeSorted);
        }
        System.out.println("!Performance Analysis");
        System.out.println("1. Bubble Sort (O(n^2)):");
        System.out.println("   - Performs worse on large datasets due to nested loops");
        System.out.println("   - Best case O(n) when already sorted");
        System.out.println("   - Worst case O(n^2) when reverse sorted");
        System.out.println();
        System.out.println("2. Merge Sort (O(n log n)):");
        System.out.println("   - Consistent performance regardless of initial order");
        System.out.println("   - Divide and conquer approach provides better scalability");
        System.out.println("   - Requires O(n) additional space for merging");
        System.out.println();
        System.out.println("3. Linear Search (O(n)):");
        System.out.println("   - Checks each element sequentially");
        System.out.println("   - Performance depends on position of target element");
        System.out.println("   - Same performance for sorted and unsorted arrays");
        System.out.println();
    }
}