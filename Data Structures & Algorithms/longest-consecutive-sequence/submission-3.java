class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        HashSet<Integer> set = new HashSet<>();

        for(int i = 0;i<n;i++){
            set.add(nums[i]);
        }
        
        int count = 0;
        int ans = 0;
        for(int i = 0;i<n; i++){
            if(set.contains(nums[i]-1)) continue;

            int start = nums[i];
            while(set.contains(start)){
                count++;
                start++;
            }

            ans = Math.max(count,ans);
            count = 0;
        }

        return ans;

    }
}
