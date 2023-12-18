import functools as f 


def compare(x,y):   
    return (x<y)-(x>y)


def largestNumber(nums):
    arr=list(map(str,nums))
    arr.sort(key=f.cmp_to_key(lambda x,y:compare(x+y,y+x)))
    return "".join(arr).lstrip("0") or "0"

if __name__=="__main__":
    
    # Convert the input string to a list of integers
    nums=[int(x) for x in input("Enter multiple value: ").split(" ")]

    # Call the function and print the result
    result = largestNumber(nums)
    print(f"The largest number is: {result}")