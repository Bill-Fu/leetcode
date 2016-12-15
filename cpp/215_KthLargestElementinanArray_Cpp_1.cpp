/*

Leetcode Problem

215.Kth Largest Element in an Array:

Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.

For example,

Given [3,2,1,5,6,4] and k = 2, return 5.

*/

/*

Solution:

Based on the principle of Heap Sort, a minimum heap is first constructed. 

Then we push the first k elements into the heap. 

After that we compare the rest elements one by one to the head element of the heap.

If it's greater than the head element of the heap, we pop the head element and push the new element to the heap.

After all elements have been traversed, the head element of the heap is the kth largest element in this array. 

And the overall time complexity is approximately O(nlogk).

*/
class Solution {
public:
    int findKthLargest(vector<int>& nums, int k) {
	//Initialize the minumum heap
        priority_queue<int,vector<int>,greater<int>> result;
	//Index for traversing
        int i;
        
	//push the first k elements to the heap
        for(i=0;i<k;++i){
            result.push(nums[i]);
        }
        
	//traverse the rest elements of the array
        for(;i<nums.size();++i){
            if(nums[i]>result.top()){
                result.push(nums[i]);
                result.pop();
            }
        }
        
	//return the result, that is the head element of the heap
        return result.top();
    }
};
