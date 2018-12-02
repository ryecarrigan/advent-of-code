def twoCount   = 0
def threeCount = 0

new File('input.txt').readLines().each { value ->
    def charList = value.toList()
    def twos = charList.findAll { letter -> value.count(letter) == 2}
    if (!twos.empty) {
        twoCount++
    }

    def threes = charList.findAll { letter -> value.count(letter) == 3}
    if (!threes.empty) {
        threeCount++
    }
}

println "Checksum: ${twoCount * threeCount}"
