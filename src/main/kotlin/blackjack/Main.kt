package blackjack

fun main(args: Array<String>) {
    val sam = Player("sam")
    val dealer = Player("dealer")

    val deck = if (args.isNotEmpty()) {
        FileReader.read(fileName = args.first())
    } else {
        Deck()
    }

    val winner = Game(sam, dealer, deck).determineWinner()

    println(winner.name)
    println(sam)
    println(dealer)
}
