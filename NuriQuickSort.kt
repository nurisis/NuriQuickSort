/**
 * @param array : Array you want to sort
 * @param priorityCheck(pivot, target)
 * When "pivot" has higher priority than "target" => 1
 * When "pivot" has lower priority than "target" => -1
 * "pivot" == "target" => 0
 * */
class NuriQuickSort<T>(
        private val array:Array<T>,
        private val priorityCheck: (T,T) -> Int
) {

    fun sort(left:Int, right:Int):Array<T> {
        if(left <= right) {
            // Divide the array in two (by pivot)
            val pivot = partition(array, left, right)
            // Align left area
            sort(left, pivot-1)
            // Align right area
            sort(pivot+1, right)
        }

        return array
    }

    private fun partition(arr: Array<T>, left:Int, right:Int) : Int{
        val pivot = arr[left]
        var low = left+1
        var high = right

        while (low <= high) {
            // Finding values with a lower priority than pivot
            while (low <= right && priorityCheck(pivot, arr[low]) >= 0)
                low++

            // Finding values with a higher priority than pivot
            while(left < high && priorityCheck(pivot, arr[high]) <= 0)
                high--

            // Exchange low and high if they are not crossed
            if(low <= high)
                swap(arr, low, high)
        }
        // Exchange pivot and high
        swap(arr, left, high)

        return high
    }

    private fun swap(arr:Array<T>, idx1:Int, idx2:Int) {
        val temp = arr[idx1]
        arr[idx1] = arr[idx2]
        arr[idx2] = temp
    }
}
