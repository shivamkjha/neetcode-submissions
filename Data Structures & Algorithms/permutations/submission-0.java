class Solution {
    public List<List<Integer>> permute(int[] nums) {
        boolean[] vis = new boolean[nums.length];
        List<List<Integer>> ans = new ArrayList<>();
        permutation(nums,ans,new ArrayList<>(),vis);
        return ans;
    }

    void permutation(int[] nums,List<List<Integer>> ans, List<Integer> curr,boolean[] vis){
        if(curr.size() == nums.length){
            ans.add(new ArrayList(curr));
            return;
        }

        for(int i = 0;i<nums.length;i++){
            if(vis[i]) continue;

            curr.add(nums[i]);
            vis[i] = true;
            permutation(nums,ans,curr,vis);
            vis[i] = false;
            curr.remove(curr.size() -1);
        }
    }
}
