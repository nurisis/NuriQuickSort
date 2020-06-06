# NuriQuickSort
A project that implements quicksort directly using Kotlin.  
You can sort using NuriQuickSort by simply passing a function that checks the priority for sorting.  

## How to use
```
val arrToSort = arrayOf(99,1,3,5)
NuriQuickSort(arrToSort, descendingPriority()).sort(0, arrToSort.size-1)
println("AFTER SORTING : ${Arrays.toString(arr)}") // AFTER SORTING : [99,5,3,1]

// Function that checks the priority for sorting => Descending
fun descendingPriority() : (Int, Int) -> Int = { pivot, num ->
    when {
        // When "num" has higher priority than "pivot"
        pivot < num -> 1
        // When "num" has lower priority than "pivot"
        pivot > num -> -1
        else -> 0
    }
}
```
