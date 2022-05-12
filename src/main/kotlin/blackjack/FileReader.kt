package blackjack

import java.io.File
import java.nio.charset.Charset

class FileReader {

    companion object {
        fun read(fileName: String): Deck {
            val cards = File(fileName)
                .readLines(Charset.defaultCharset())
                .first()
                .split(",")
                .map { Card.from(it.trim()) }
                .toMutableList()

            return Deck(cards)
        }
    }
}
