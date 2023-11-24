class NumberConverter() {
    private fun getNumberNameWithFinalCharsLowerCase(number: Int): String {
        val units = arrayOf(
            "нулевой",
            "первый",
            "второй",
            "третий",
            "четвертый",
            "пятый",
            "шестой",
            "седьмой",
            "восьмой",
            "девятый",
            "десятый"
        )
        val teens = arrayOf(
            "одиннадцатый",
            "двенадцатый",
            "тринадцатый",
            "четырнадцатый",
            "пятнадцатый",
            "шестнадцатый",
            "семнадцатый",
            "восемнадцатый",
            "девятнадцатый"
        )
        val tens = arrayOf(
            "",
            "",
            "двадцать",
            "тридцать",
            "сорок",
            "пятьдесят",
            "шестьдесят",
            "семьдесят",
            "восемьдесят",
            "девяносто"
        )
        val tensZero = arrayOf(
            "",
            "",
            "двадцатый",
            "тридцатый",
            "сороковой",
            "пятьдесятый",
            "шестьдесятый",
            "семьдесятый",
            "восемьдесятый",
            "девяностый"
        )
        val hundreds = arrayOf(
            "",
            "сто",
            "двести",
            "триста",
            "четыреста",
            "пятьсот",
            "шестьсот",
            "семьсот",
            "восемьсот",
            "девятьсот"
        )
        val hundredsZero = arrayOf(
            "",
            "сотый",
            "двухсотый",
            "трехсотый",
            "четырехсотый",
            "пятисотый",
            "шестисотый",
            "семисотый",
            "восьмисотый",
            "девятисотый"
        )

        if (number < 0 || number > 999) {
            return "Неверное число для преобразования"
        }
        return when {
            number == 0 -> units[number]
            number in 1..10 -> units[number]
            number in 11..19 -> teens[number - 11]
            number in 20..99 -> {
                val digit1 = number / 10
                val digit2 = number % 10
                if (digit2 == 0) {
                    tensZero[digit1]
                } else {
                    "${tens[digit1]} ${units[digit2]}"
                }
            }

            number >= 100 -> {
                val digit1 = number / 100
                val digit2 = (number / 10) % 10
                val digit3 = number % 10
                println("digit1: $digit1")
                println("digit2: $digit2")
                println("digit3: $digit3")
                if (digit2 == 0 && digit3 == 0) {
                    hundredsZero[digit1]
                } else if (digit2 == 0) {
                    "${hundreds[digit1]} ${units[digit3]}"
                } else if (digit3 == 0) {
                    "${hundreds[digit1]} ${tensZero[digit2]}"
                } else {
                    "${hundreds[digit1]} ${tens[digit2]} ${units[digit3]}"
                }
            }

            else -> "Неверное число для преобразования"
        }
    }

    fun getNumberNameWithFinalChars(number: Int): String {
        val text = getNumberNameWithFinalCharsLowerCase(number)
        val firstCharUp = text[0].uppercase()
        val otherCharsLC = text.substring(1)
        return "$firstCharUp $otherCharsLC"
    }
}