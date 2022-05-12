package blackjack

import java.lang.IllegalStateException
import kotlin.test.Test
import kotlin.test.assertEquals

class GameTests {

    @Test
    fun `The player with the highest score equal or under 21 wins`() {
        val sam = Player("sam")
        val dealer = Player("dealer")
        val cards = listOf("2", "K", "10", "6", "A", "4").map {
            Card(Suit.C, Rank(it))
        }.toMutableList()
        val deck = Deck(cards)

        val winner = Game(sam, dealer, deck).determineWinner()
        assertEquals(dealer, winner)
    }

    @Test
    fun `Drawing over 21 results in losing`() {
        val sam = Player("sam")
        val dealer = Player("dealer")
        val cards = listOf("A", "5", "9", "Q", "8").map {
            Card(Suit.C, Rank(it))
        }.toMutableList()
        val deck = Deck(cards)

        val winner = Game(sam, dealer, deck).determineWinner()
        assertEquals(sam, winner)
    }

    @Test
    fun `Dealer wins when both players start with 22`() {
        val sam = Player("sam")
        val dealer = Player("dealer")
        val cards = mutableListOf(
            Card(Suit.C, Rank("A")),
            Card(Suit.H, Rank("A")),
            Card(Suit.D, Rank("A")),
            Card(Suit.S, Rank("A")),
        )
        val deck = Deck(cards)

        val winner = Game(sam, dealer, deck).determineWinner()
        assertEquals(dealer, winner)
    }

    @Test
    fun `Sam should draw first`() {
        val sam = Player("sam")
        val dealer = Player("dealer")
        val deckWithOneCard = Deck(mutableListOf(Card(Suit.C, Rank("A"))))

        try {
            Game(sam, dealer, deckWithOneCard).determineWinner()
        } catch (ignored: IllegalStateException) {}

        assertEquals(1, sam.hand.size)
        assertEquals(0, dealer.hand.size)
    }
}
