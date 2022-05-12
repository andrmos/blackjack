package blackjack

import kotlin.test.Test
import kotlin.test.assertEquals

class CardTests {

    @Test
    fun `Numeral cards should count as their point value`() {
        (2..10).forEach { rank ->
            val card = Card(Suit.C, Rank(rank.toString()))
            assertEquals(rank, card.value())
        }
    }

    @Test
    fun `Ace should count as 11`() {
        val card = Card(Suit.C, Rank("A"))
        assertEquals(11, card.value())
    }

    @Test
    fun `Face cards should count as 10`() {
        listOf(
            Card(Suit.C, Rank("K")),
            Card(Suit.C, Rank("Q")),
            Card(Suit.C, Rank("J")),
        ).forEach {
            assertEquals(10, it.value())
        }
    }
}
