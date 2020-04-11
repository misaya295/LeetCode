package dayo3

object T {

  def main(args: Array[String]): Unit = {


    var s = "dasdsadasd"
    var m = 0
    val len = s.length
    val map = scala.collection.mutable.HashMap[Char, Int]()
    var start = 0

    var end = 0
    while (true) {


      val alpha = s(end)

      if (map.contains(alpha)) {

        println(map.get(alpha))

        start = math.max(1, 2)


      }


    }

  }
}