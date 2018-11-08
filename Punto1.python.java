from random import randint

def bubble_sort(a):
    for i in range(   len(a) - 1):
    
        swapped = False
        
        for j in range(  len(a) - 1):
            if a[j] > a[j+1]:
                swap = a[j]
                a[j] = a[j+1]
                a[j+1] = swap    
                swapped = True       

        if not swapped:
                break            

a = [randint(1,1000) for i in range(200)]
print(a)
bubble_sort(a)
print(a)


def insertion_sort(a):
    for i in range(1,len(a)):
        x = a[i]
        index_hole = i
        
        while index_hole > 0 and a[index_hole - 1] > x:
            a[index_hole] = a[index_hole - 1]
            index_hole -= 1
            
        a[index_hole] = x
        
        
        
def quick_sort(a):
    if len(a) <=1:
        return a
    else:
        pivot = a[0]
        less_subarray = []
        greater_subarray = []
        
        for i in range(1, len(a)):
            if a[i] < pivot:
                less_subarray.append(a[i])
            else:
                greater_subarray.append(a[i])
                
                
        quick_sort(less_subarray)
        quick_sort(greater_subarray)
        
        
        result = less_subarray[:]
        result.append(pivot)
        result.extend(greater_subarray)
    
    return result

def merge_sort(a,n):
    if len(a)==1:
        return a
    else:
        left_subarray=a[0]+a[n/2]
        right_subarray=a[(n/2)+1]+a[n]
        
        sortedL=merge_sort(left_subarray)
        sortedR=merge_sort(right_subarray)
        return merge_sort(sortedL,sortedR)

def merge(a,b):
    l=len(a)+len(b)
    c=len(l)
    indexa=0,indexb=0,indexc=0
    
    while a and b:
        if a[indexa] < b[indexb]:
            c[indexc]=a[indexa]
            indexa=indexa+1
            indexc=indexc+1
    while a:
        c[indexc]=a[indexa]
        indexa=indexa+1
        indexc=indexc+1
    while b:
        c[indexc]=b[indexb]
        indexb=indexb+1
        indexc=indexc+1     
    
       
def binary_search(a,x):
    lowerbound=0
    upperbound=len(a)-1
    index=-1
    
    while lowerbound < upperbound:
        middlepoint=(lowerbound+upperbound)/2
        if x==a[middlepoint]:
            index=middlepoint
            break
        else:
            if x < a[middlepoint]:
                upperbound=middlepoint-1
            else:
                lowerbound=middlepoint+1
    if lowerbound==upperbound and a[lowerbound]==x:
        index=lowerbound
        return index

def bynary_search_recursive(a,x,ib,ub):
    middlepoint=(ib+ub)/2
    if ib==ub:
        if x==a[middlepoint]:
            return middlepoint
        else:
            return -1
    else:
        if x==a[middlepoint]:
            return  middlepoint
        else:
            if x < a[middlepoint]:
                return bynary_search_recursive(a,x,ib,middlepoint)
            else:
                return bynary_search_recursive(a,x,middlepoint+1)
            
def interpolation_search(a,x):
    lowerbound=0
    upperbound=len(a)-1
    index=-1
    
    while lowerbound < upperbound:
        middlepoint=lowerbound+((upperbound-lowerbound)/
        (a[upperbound]-a[lowerbound]))*(x-a[lowerbound])
        if x==a[middlepoint]:
            index=middlepoint
            break
        else:
            if x < a[middlepoint]:
                upperbound=middlepoint-1
            else:
                lowerbound=middlepoint+1
                
    if lowerbound==upperbound and a[lowerbound]==x:
        index=lowerbound
    return index                 