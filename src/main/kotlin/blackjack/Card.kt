package blackjack

data class Card(
    val suit: Suit,
    val rank: Rank,
) {

    companion object {
        fun from(input: String): Card {
            val suite = input.first().let {
                Suit.valueOf(it.toString())
            }
            val rank = Rank(input.last().toString())

            return Card(suite, rank)
        }
    }

    fun value(): Int {
        if (rank.value == "A") return 11
        return rank.value.toIntOrNull() ?: 10
    }

    override fun toString(): String {
        return "$suit${rank}"
    }
}

class Rank(val value: String) {
    init {
        assertValid()
    }

    private fun assertValid() {
        val isValidFaceRank = listOf("A", "K", "Q", "J").contains(value)

        if (!isValidFaceRank) {
            val number = value.toIntOrNull() ?: throw IllegalArgumentException("Invalid rank $value")
            val isInvalidNumber = number < 2 || number > 10

            if (isInvalidNumber) {
                throw IllegalArgumentException("Invalid rank $value")
            }
        }
    }

    override fun toString() = value
}

enum class Suit {
    C, D, H, S
}
