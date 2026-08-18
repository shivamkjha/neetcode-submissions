class Solution {
    public List<List<Integer>> combinationSum2(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        sum(ans,new ArrayList<>(),0,target,0,nums);
        return ans;
    }

    void sum(List<List<Integer>> ans, List<Integer> list,int idx,int target, int sum,int[] nums){
        
        // base case
        if(sum == target){
            ans.add(new ArrayList(list));
            return;
        }

        for(int i = idx;i<nums.length;i++){
            if(i>idx && nums[i] == nums[i-1]) continue;
            if(sum + nums[i] > target) return;
            
            list.add(nums[i]);
            sum(ans,list,i+1,target,sum+nums[i],nums);
            list.remove(list.size()-1);
        }
    }
}
