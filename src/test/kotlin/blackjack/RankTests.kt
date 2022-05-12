package blackjack

import org.junit.Test

class RankTests {

    @Test
    fun `Happy case`() {
        Rank("2")
        Rank("K")
    }

    @Test(expected = IllegalArgumentException::class)
    fun `Creating a rank with a number too should be illegal`() {
        Rank("-1")
    }

    @Test(expected = IllegalArgumentException::class)
    fun `Creating a rank with a number too high should be illegal`() {
        Rank("11")
    }

    @Test(expected = IllegalArgumentException::class)
    fun `Creating a rank with invalid value should be illegal`() {
        Rank("H")
    }
}
