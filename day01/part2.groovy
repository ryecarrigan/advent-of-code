def freq   = 0
def freqs  = new LinkedHashSet()
def values = new File('input.txt').readLines().collect { line -> line.toInteger()}

while (true) {
    for (value in values) {
        freq += value
        if (!freqs.add(freq)) {
            println freq
            return
        }
    }
}
