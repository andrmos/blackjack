package blackjack

class Player(
    val name: String,
    val hand: MutableList<Card> = mutableListOf()
) {

    fun drawCard(deck: Deck) {
        val card = deck.cards.removeFirstOrNull()
            ?: throw IllegalStateException("Cannot draw from empty deck")

        hand.add(card)
    }

    fun score(): Int {
        return hand.sumOf { it.value() }
    }

    fun hasBlackjack(): Boolean {
        return score() == 21
    }

    fun hasLost(): Boolean {
        return score() > 21
    }

    override fun toString(): String {
        return "$name: ${hand.joinToString(", ")}"
    }
}
