def twos   = []
def threes = []

new File('input.txt').readLines().each { value ->
    def charList = value.toList()
    def twoChars = charList.findAll { letter -> value.count(letter) == 2}
    if (!twoChars.empty) {
        twos += value
    }

    def threeChars = charList.findAll { letter -> value.count(letter) == 3}
    if (!threeChars.empty) {
        threes += value
    }
}

def possible = twos + threes
println "Possible IDs: ${possible.size()}"
println "Checksum: ${twos.size() * threes.size()}"

def ids = new File('ids.txt')
if (!ids.createNewFile()) {
    ids.text = ''
}

for (id in possible) {
    ids << "${id}\n"
}
