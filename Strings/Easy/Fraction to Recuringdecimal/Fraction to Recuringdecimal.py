def fraction_to_recurring_decimal(numerator, denominator):
if numerator == 0:
return "0"result = ""

# Handle the sign
if (numerator < 0) ^ (denominator < 0):
    result += "-"

# Convert both numerator and denominator to positive
numerator, denominator = abs(numerator), abs(denominator)

# Calculate the integral part
result += str(numerator // denominator)
remainder = numerator % denominator

if remainder == 0:
    return result

result += "."

# Use a dictionary to store the position of each remainder
remainder_positions = {}

while remainder != 0:
    if remainder in remainder_positions:
        # The remainder repeats, so add parentheses and break the loop
        result = result[:remainder_positions[remainder]] + "(" + result[remainder_positions[remainder]:] + ")"
        break

    # Store the current remainder position in the result
    remainder_positions[remainder] = len(result)

    remainder *= 10
    result += str(remainder // denominator)
    remainder %= denominator

return result
numerator = int(input())
denominator = int(input())
result = fraction_to_recurring_decimal(numerator, denominator)
print(f"{numerator}/{denominator} = {result}")
