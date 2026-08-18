class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>());
        subset(ans,new ArrayList<>(),0,nums);
        return ans;
    }

    void subset(List<List<Integer>> ans, List<Integer> list,int index,int[] nums){
        if(index >= nums.length){
            return;
        }

        for(int i = index;i<nums.length;i++){

            list.add(nums[i]);
            ans.add(new ArrayList(list));
            subset(ans,list,i+1,nums);
            list.remove(list.size()-1);
        }
        
    }
}
