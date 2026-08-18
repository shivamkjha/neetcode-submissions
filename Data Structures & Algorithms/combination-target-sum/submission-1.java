class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
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

        if(idx >= nums.length) return;

        // pick
        if(sum + nums[idx] <= target){
            list.add(nums[idx]);
            sum(ans,list,idx,target,sum+nums[idx],nums);
            list.remove(list.size() -1);
        }

        // not pick
        sum(ans,list,idx+1,target,sum,nums);
        
    }
}
