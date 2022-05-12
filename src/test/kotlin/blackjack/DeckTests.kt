package blackjack

import kotlin.test.Test
import kotlin.test.assertEquals

class DeckTests {

    @Test
    fun `A full deck should have 52 cards`() {
        val deck = Deck()
        assertEquals(52, deck.cards.size)
    }
}
