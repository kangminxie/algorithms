# Sort Section

### Basic methods
- bubble sort
- selection sort
- insertion sort (Hill)


### Advanced methods 
- merge sort
- quick sort
- heap sort

### Lomuto vs Hoare

Lomuto: P | <P | S | >=P | r
    P <- A[l]
    S <- l
    for i = l + 1 to r:
        if A[i] < p
            S = S + 1
            swap(A[s], A[i])
    swap(A[l], A[s])
    return S

Hoare: Quick Select
