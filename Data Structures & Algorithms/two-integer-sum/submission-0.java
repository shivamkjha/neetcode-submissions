class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int[] ans = new int[2];

        for(int i =0;i<nums.length;i++){
            int reqd = target - nums[i];

            if(map.containsKey(reqd)){
                int idx = map.get(reqd);
                ans[0] = idx;
                ans[1] = i;
                break;
            }

            map.put(nums[i],i);
        }

        return ans;
    }
}
