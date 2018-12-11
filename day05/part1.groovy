def input = new File('input.txt').text.trim().toList()

println "Part 1: ${react(input)}"
println "Part 2: ${findUnit(input)}"

private Map findUnit(List<String> input) {
  def unique = new ArrayList<String>(input).unique { a, b -> a.toLowerCase() <=> b.toLowerCase() }.sort()

  def results = [:]
  for (letter in unique) {
    def copy = new ArrayList<String>(input)
    copy.removeAll(letter.toLowerCase())
    copy.removeAll(letter.toUpperCase())

    results[letter] = react(copy)
  }

  return results
}

private int react(List input) {
  int nextMatch

  def copy = new ArrayList(input)
  while ((nextMatch = nextMatchAt(copy)) >= 0) {
    copy.removeAt(nextMatch)
    copy.removeAt(nextMatch)
  }

  return copy.size()
}

private int nextMatchAt(List input) {
  for (int i = 0; i < input.size() - 1; ++i) {
    def curr = input[i].toString()
    def next = input[i + 1].toString()

    def polar = curr.toCharacter().isUpperCase() ^ next.toCharacter().isUpperCase()
    def same  = curr.equalsIgnoreCase(next)
    if (polar && same) {
      return i
    }
  }

  return -1
}