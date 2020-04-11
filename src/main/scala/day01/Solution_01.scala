package day01


import scala.util.control.Breaks._
object Solution_01 {
  def twoSum(nums: Array[Int], target: Int): Array[Int] = {


    val res = new Array[Int](2)

    breakable {

      for( i <- 0 until nums.length) {

        for (j <- i+1 until nums.length) {
          if (nums(i)+nums(j) == target) {

            res(0) = i
            res(1) = j
            break
          }
        }
      }
    }
          res
  }

  def twoSum1(nums: Array[Int], target: Int): Array[Int] = {


    val index = new Array[Int](2)
    val a = nums.zipWithIndex.toMap

    for (x <- nums; y = target - x;if  a.contains(y) && x  !=y) {
      index(0) = a(x)
      index(1) = a(y)
      return index


    }
    var count = 0
    for ( i <- nums.indices; if nums(i) == target /2) {

      index(count) = i
      count += 1

    }

    return  index

  }







    def main(args: Array[String]): Unit = {
    var z = Array(1, 2, 3, 5, 6)
    val solution = Solution_01

//    val res = solution.twoSum(z,4)
      val res = solution.twoSum1(z,4)

      for (res1 <- res) {
      print(res1+" ")
    }


  }

}
