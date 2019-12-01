from math import floor


def get_fuel(mass):
    return floor(mass / 3) - 2


total = 0
with open('input.txt') as file:
    for content in file:
        this = int(content)
        total = total + get_fuel(this)

print(f'Part 1: {total}')
