# sum-of-given-range-using-segment-tree-in-java

Let us consider the following problem to understand Segment Trees.
We have an array arr[0 . . . n-1]. We should be able to 
1 Find the sum of elements from index l to r where 0 <= l <= r <= n-1
2 Change value of a specified element of the array to a new value x. We need to do arr[i] = x where 0 <= i <= n-1.



if you are going to find the sum normally it will take O(n) time complexity.
and for update it will take O(1).

this is okk if number of query is less.

what if querry > 10^4 

for sum time complexity will be 10^4 * n
          n = length of array
          what is length itself > 10^4
          
          if n = 10^4
          time taken = c * 10^4 * 10^4 unit
                       where c is some constant
           
          for updatation 
                      time taken = 10^4 = no of querry
                  
                  total = c * 10^4 * 10^4  + c * 10^4


if we implement this using segment tree

time complexity to find the sum within the range  10^4 * log₂(n)
                                   n = length of array
                                  
                                  time taken = c * 13 * 10^4 unit
                                              c is some constant
                                              
                      time taken for updation is same as finding sum because we have to update the tree.
                      
                                time taken for updation = c * 13 * 10^4 unit
                            
 this is why segment tree is usefull
 
 
 question:
 
 how to construct segment tree?
 
     visit the website given link below to see the logic behind segment tree

    link : https://cp-algorithms.com/data_structures/segment_tree.html


how to implement?

    Once you understood the logic please try to implement youself.
    
    you can see my code for reference.
    
    
  
    
    thank you.
    
 
 
 
 
                                              
                                         
