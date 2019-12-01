from math import floor


def get_fuel(mass):
    return floor(mass / 3) - 2


def get_extra_fuel(mass, overall=0):
    extra_fuel = get_fuel(mass)
    if extra_fuel > 0:
        return get_extra_fuel(extra_fuel, overall + extra_fuel)
    else:
        return overall


total = 0
with open('input.txt') as file:
    for content in file:
        total = total + get_extra_fuel(int(content))

print(f'Part 2: {total}')
