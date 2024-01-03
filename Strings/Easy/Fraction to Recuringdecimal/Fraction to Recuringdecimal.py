def fraction_to_recurring_decimal(numerator, denominator):
    if numerator == 0:
        return "0"

    result = []

    # Handle the sign
    if (numerator < 0) ^ (denominator < 0):
        result.append("-")

    # Take the absolute values
    numerator, denominator = abs(numerator), abs(denominator)

    # Add the integer part
    result.append(str(numerator // denominator))
    remainder = numerator % denominator

    if remainder == 0:
        return ''.join(result)

    result.append(".")
    seen_remainders = {}

    while remainder != 0:
        if remainder in seen_remainders:
            # Recurring part found
            index = seen_remainders[remainder]
            result.insert(index, "(")
            result.append(")")
            break

        seen_remainders[remainder] = len(result)
        remainder *= 10
        result.append(str(remainder // denominator))
        remainder %= denominator

    return ''.join(result)

if __name__ == "__main__":
    numerator = int(input("Enter the numerator: "))
    denominator = int(input("Enter the denominator: "))

    result = fraction_to_recurring_decimal(numerator, denominator)

    print(f"The recurring decimal representation is: {result}")
