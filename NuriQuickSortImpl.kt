import java.util.*

fun main(args: Array<String>) {
    val arr = arrayOf(99,5,7,8,3,2,111,100,89)
    NuriQuickSort(arr, descendingPriority()).sort(0, arr.size-1)
    println("AFTER SORTING : ${Arrays.toString(arr)}")
}

// Descending
fun descendingPriority() : (Int, Int) -> Int = { pivot, num ->
    when {
        pivot < num -> 1
        pivot > num -> -1
        else -> 0
    }
}
