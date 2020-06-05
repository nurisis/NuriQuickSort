import java.util.*



fun main(args: Array<String>) {
//    val arr = arrayOf(33,5,9,66)
//    val arr = arrayOf(8,6,4,2,1,0)
    val arr = arrayOf(99,5,7,8,3,2,111,100,89)

    val arr2 = intArrayOf(3, 30, 34, 5, 9)
//    val arr2 = intArrayOf(6,10,2)
    val newArr2 = arr2.toTypedArray()

    NuriQuickSort(arr, checkPriorityHigh2()).sort(0, arr.size-1)
    println("RESULT >> 정렬 후 arr : ${Arrays.toString(arr)}")
}

// 내림차순
fun checkPriorityHigh2() : (Int, Int) -> Int = { pivot, num ->
    when {
        // pivot 보다 우선순위가 클 때 => 1 리턴
        pivot < num -> 1
        // pivot 보다 우선순위가 작을 때 => -1 리턴
        pivot > num -> -1
        else -> 0
    }
}

fun isPriorityHigh(num1:Int, num2:Int) : Int {
    print("num1:$num1, num2:$num2, ")
    val num1ToString = num1.toString()
    val num2ToString = num2.toString()

    var index = 0
    while (index < num1ToString.length && index < num2ToString.length) {
        if(num1ToString[index] < num2ToString[index]) {
            print("$num1 < $num2 !\n")
            return 1
        }
        else  if(num1ToString[index] > num2ToString[index]) {
            print("$num1 > $num2 !\n")
            return -1
        }

        index++
    }

    if(num1ToString.length > index ) {
        return if(num1ToString[index] == '0') 1
        else -1
    }
    else if(num2ToString.length > index) {
        return if(num2ToString[index] == '0') -1
        else 1
    }

    return 0
}
