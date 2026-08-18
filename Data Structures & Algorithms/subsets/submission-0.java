class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        subset(ans,new ArrayList<>(),0,nums);
        return ans;
    }

    void subset(List<List<Integer>> ans, List<Integer> list,int index,int[] nums){
        if(index >= nums.length){
            ans.add(new ArrayList<>(list));
            return;
        }

        // Add the current index element eg. [1] for [1,2,3]
        list.add(nums[index]);

        //pick the current element and move ahead [1]
        subset(ans,list,index+1,nums);

        // don't pick the current element and move ahead []
        list.remove(list.size()-1);
        subset(ans,list,index+1,nums);
    }
}
