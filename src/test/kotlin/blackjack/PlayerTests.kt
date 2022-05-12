package blackjack

import kotlin.test.Test
import kotlin.test.assertEquals

class PlayerTests {

    @Test
    fun `Drawing cards should increase hand size`() {
        val deck = Deck()
        val player = Player("test")

        player.drawCard(deck)
        player.drawCard(deck)
        player.drawCard(deck)

        assertEquals(3, player.hand.size)
    }

    @Test
    fun `Drawing cards should reduce deck size`() {
        val deck = Deck()
        val player = Player("test")

        player.drawCard(deck)
        player.drawCard(deck)

        assertEquals(50, deck.cards.size)
    }

    @Test
    fun `Hand score should be correct`() {
        val hand = mutableListOf(
            Card(Suit.C, Rank("10")),
            Card(Suit.C, Rank("A"))
        )
        val player = Player("test", hand)

        assertEquals(21, player.score())
    }
}
