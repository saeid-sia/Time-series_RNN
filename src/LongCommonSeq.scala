
object LongCommonSeq {

  def LCS(str1: String, str2: String): String = (str1, str2) match {
    case (s1, s2) if s1.length < 1 || s2.length < 1 => ""
    case (s1, s2) if s1.head == s2.head => s1.head.toString ++ LCS(s1.tail, s2.tail)
    case (s1, s2) =>
      def l1 = LCS(s1, s2.tail)
      def l2 = LCS(s1.tail, s2)
      if (l1.length > l2.length) l1 else l2
  }
}
