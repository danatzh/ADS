# Algorithm Performance Analysis: Sorting and Searching
## A. Project Overview
This project involves a practical study of algorithm efficiency by comparing different sorting and searching techniques. The experiment measures execution times across various dataset sizes and initial orderings.
+ **Purpose**: To understand how input size and data state (random vs. sorted) affect the performance of algorithms in a real-world Java environment.
___
## B. Algorithm Descriptions
1. **Bubble Sort (Basic Sorting)**
+ How it works: A simple comparison-based algorithm that repeatedly steps through the list, compares adjacent elements, and swaps them if they are in the wrong order. Larger elements "bubble up" to their correct positions at the end of the array.
+ Time Complexity: $O(n^2)$ in average and worst cases; $O(n)$ in the best case (when optimized for already sorted arrays).
2. **Merge Sort (Advanced Sorting)**
+ How it works: A "Divide and Conquer" algorithm. It recursively divides the array into two halves, sorts them, and then merges the sorted halves back together.
+ Time Complexity: $O(n \log n)$ consistently for best, average, and worst cases.
3. **Linear Search (Searching)**
+ How it works: Iterates through each element of the array sequentially from the first to the last until the target value is found or the end of the array is reached.
+ Time Complexity: $O(n)$.
___
## C. Experimental Results
| Size          | Data Type     | Bubble Sort(ns)  | Merge Sort (ns) | Linear Search (ns) |
| ------------- |-------------  | ---------------  | --------------- | ------------------ |
| Small (10)    | Random        | 5800 ms          | 4000 ns         | 1800 ns            |
| Small (10)    | Sorted        | 1100 ns          | 2300 ns         | 400 ns             |
| Medium (100)  | Random        | 193400 ns        | 71700 ns        | 2000 ns            |
| Large (1000)  | Random        | 3842300 ns       | 150000 ns       | 2400 ns            |
### Key Observations:
+ Scalability: As the input size increases, Bubble Sort's execution time grows quadratically, while Merge Sort shows much more stable and efficient growth.
+ Sorted vs Unsorted: Bubble Sort performs significantly faster on already sorted data due to the "swapped" flag optimization. Merge Sort remains relatively consistent.
___
## D. Screenshots
  Main Screenshot
![Main code screenshot](docs/screenshots/main.jpg)

  Test Run 1
![Execution Run 1](docs/screenshots/run1.jpg)

  Test Run 2
![Execution Run 2](docs/screenshots/run2.jpg)

  Test Run 3
![Execution Run 3](docs/screenshots/run3.jpg)
___
## E. REflection
Through this experiment, I observed the clear difference between theoretical Big-O complexity and practical execution. While Bubble Sort is easy to implement, its $O(n^2)$ nature makes it impractical for larger datasets, as seen in the dramatic jump in nanoseconds when moving from 100 to 1000 elements. Merge Sort, despite its higher memory overhead, proved to be far superior for scaling.

One of the main challenges was ensuring accurate time measurements using System.nanoTime(), as background system processes can sometimes cause slight fluctuations. I also learned that for very small arrays, the overhead of recursion in Merge Sort can sometimes make simpler algorithms like Bubble Sort competitive, but this advantage disappears quickly as $n$ grows.
___
## Analysis Questions
+ **Which sorting algorithm performed faster?** Merge Sort is much faster for Medium and Large arrays. For example, at 1000 elements, it is ~25 times faster than Bubble Sort.
+ **How does performance change with input size?** Bubble Sort's time grows exponentially (quadratically), jumping from 193k to 3.8M. Merge Sort grows much slower.
+ **Sorted vs Unsorted:** Sorted data makes Bubble Sort extremely fast (5100 ns vs 3.8M ns) because it doesn't need to swap anything.
+ **Does it match Big-O?** Yes. Bubble Sort shows $O(n^2)$ behavior on random data, while Merge Sort stays closer to $O(n \log n)$.
+ **Search efficiency:** Linear Search is very fast but its time stays relatively flat because 1000 elements is still a small number for a simple $O(n)$ check.
+ **Why Binary Search requires sorted array?** It requires sorting because it splits the range in half. If the data isn't ordered, we wouldn't know which half to discard.
