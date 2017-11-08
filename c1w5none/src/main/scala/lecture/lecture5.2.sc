def msort(xs: List[Int]): List[Int] = {

  val n = xs.length / 2

  if (n == 0) xs
  else {

    def merge(xs: List[Int], ys: List[Int]): List[Int] = xs match {
      case Nil => ys
      case x :: xs1 => ys match {
        case Nil => xs
        case y :: ys1 =>
          if (x < y) x :: merge(xs1, ys)
          else y :: merge(xs, ys1)
      }
    }

    val (fst, snd) = xs splitAt n
    merge(msort(fst), msort(snd))
  }
}

val list = 3 :: 2 :: 5 :: Nil

msort(list)

def msort2(xs: List[Int]): List[Int] = {

  val n = xs.length / 2

  if (n == 0) xs
  else {

    def merge(xs: List[Int], ys: List[Int]): List[Int] =
      (xs, ys) match {
        case (_, Nil) => xs
        case (Nil, _) => ys
        case (x :: xs1, y :: ys1) =>
          if (x < y) x :: merge(xs1, ys)
          else y :: merge(xs, ys1)
      }

    val (fst, snd) = xs splitAt n
    merge(msort(fst), msort(snd))
  }
}

msort2(list)