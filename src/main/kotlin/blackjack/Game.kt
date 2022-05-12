package blackjack

class Game(
    private val sam: Player,
    private val dealer: Player,
    private val deck: Deck
) {

    fun determineWinner(): Player {
        sam.drawCard(deck)
        dealer.drawCard(deck)
        sam.drawCard(deck)
        dealer.drawCard(deck)

        if (sam.hasBlackjack()) return sam
        if (dealer.hasBlackjack()) return dealer
        if (sam.hasLost() || dealer.hasLost()) return dealer

        while (sam.score() < 17) {
            sam.drawCard(deck)
            if (sam.hasLost()) return dealer
        }

        while (dealer.score() <= sam.score()) {
            dealer.drawCard(deck)
            if (dealer.hasLost()) return sam
        }

        return if (sam.score() > dealer.score()) sam else dealer
    }
}
