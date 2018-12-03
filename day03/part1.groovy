def regexp = /#([0-9]+)\s@\s([0-9]+),([0-9]+):\s([0-9]+)x([0-9]+)/
def claims = new File('input.txt').readLines().collect { entry ->
    def m = (entry =~ regexp)
    m.find()

    [
        leftPad: m.group(2) as int,
        upperPad: m.group(3) as int,
        width: m.group(4) as int,
        height: m.group(5) as int,
    ]
}

def fabric = new int[1200][1200]
claims.each { claim ->
    for (int x = claim.leftPad; x < (claim.width + claim.leftPad); x++) {
        for (int y = claim.upperPad; y < (claim.height + claim.upperPad); y++) {
            fabric[x][y]++
        }
    }
}

def multiple = 0
fabric.each { row ->
    row.each { column ->
        if (column >= 2) {
            multiple++
        }
    }
}

println multiple
