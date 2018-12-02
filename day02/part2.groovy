def ids = new File('ids.txt').readLines()
for (i in 0..ids.first().length() - 1) {
    idsMissingCharI = ids.collect { id -> new StringBuilder(id).deleteCharAt(i).toString() }

    while (!idsMissingCharI.empty) {
        def next = idsMissingCharI.pop()
        if (idsMissingCharI.count(next) > 1) {
            println next
        }
    }
}
