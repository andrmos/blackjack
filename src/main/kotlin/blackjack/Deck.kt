package blackjack

class Deck(
    // TODO: Immutable?
    val cards: MutableList<Card> = createDeck()
) {

    companion object {
        private fun createDeck(): MutableList<Card> {
            val ranks = listOf("A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K")

            val deck = mutableListOf<Card>()

            Suit.values().forEach { suite ->
                ranks.forEach { rank ->
                    val card = Card(suite, Rank(rank))
                    deck.add(card)
                }
            }

            deck.shuffle()

            return deck
        }
    }
}
