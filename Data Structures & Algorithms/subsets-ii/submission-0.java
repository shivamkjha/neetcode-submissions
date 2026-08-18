class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums); // for duplicate handling
        ans.add(new ArrayList<>());
        subset(ans,new ArrayList<>(),0,nums);
        return ans;
    }

    void subset(List<List<Integer>> ans, List<Integer> list,int index,int[] nums){

        for(int i = index;i<nums.length;i++){
            // handle duplicates
            if(i>index && nums[i] == nums[i-1]) continue;

            list.add(nums[i]);
            ans.add(new ArrayList(list));
            subset(ans,list,i+1,nums);
            list.remove(list.size()-1);
        }
        
    }
}
