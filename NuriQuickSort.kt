
/**
 * @param array : Array you want to sort
 * @param priorityCheck(pivot, target) : When "pivot" has higher priority than "target" => 1 / same : 0 / other : -1
 * */
class NuriQuickSort<T>(
    private val array:Array<T>,
    private val priorityCheck: (T,T) -> Int
) {

    fun sort(left:Int, right:Int):Array<T> {
        if(left <= right) {
            // 배열을 둘로 나눠서 (pivot 기준으로)
            val pivot = partition(array, left, right)
            // 왼쪽 영역 정렬
            sort(left, pivot-1)
            // 오른쪽 영역 정렬
            sort(pivot+1, right)
        }

        return array
    }

    private fun partition(arr: Array<T>, left:Int, right:Int) : Int{
        val pivot = arr[left]
        var low = left+1
        var high = right

        while (low <= high) {
            // pivot보다 우선순위가 작은 값을 찾는 과정
            while (low <= right && priorityCheck(pivot, arr[low]) >= 0)
                low++

            // pivot보다 우선순위가 큰 값을 찾는 과정
            while(left < high && priorityCheck(pivot, arr[high]) <= 0)
                high--

            // low와 high가 교차되지 않았으면 서로 교환(swap)!
            if(low <= high)
                swap(arr, low, high)
        }
        // pivot과 high 교환
        swap(arr, left, high)

        return high
    }

    private fun swap(arr:Array<T>, idx1:Int, idx2:Int) {
        val temp = arr[idx1]
        arr[idx1] = arr[idx2]
        arr[idx2] = temp
    }
}