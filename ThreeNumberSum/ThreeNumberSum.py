#  Copyrights to venkys.io
#  For more programs visit venkys.io 
#  Python program for Three Number Sum

# Twopointer Approach

def VSDthreesum(n,arr,target):
    ans=[]#the variable ans is initialized as an empty list.
    arr.sort()#input array ‘arr’ is sorted in ascending order using the sort() method.  
    for i in range(n-2):
        if (i==0 or (i>0 and arr[i]!=arr[i-1])):
            low=i+1
            high=n-1
            s=target-arr[i]
            while(low<high):
                if arr[low]+arr[high]==s:
                    ans.append([arr[i],arr[low],arr[high]])
                    while(low<high and arr[low]==arr[low+1]):
                        low+=1
                    while(low<high and arr[high]==arr[high-1]):
                        high-=1
                    low+=1
                    high-=1
                elif (arr[low]+arr[high])<s:
                    low+=1
                else:
                    high-=1
    if len(ans)>0:
        print("Resultant Triplets are: ",*ans)           
    else:
        print("No triplets")

if __name__=="__main__":#the function ‘VSDthreesum’ takes three parameters: n (length of the array), arr (the array of integers), and target (the target sum).
    n=int(input())
    arr=int(input())
    target=int(input())
    VSDthreesum(n,arr,target)
