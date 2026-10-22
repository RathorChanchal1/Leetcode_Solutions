class Solution {
    public int firstMissingPositive(int[] nums) {
        int[] res = new int[nums.length];
        int len = nums.length;

        for(int i=0; i<len; i++){
            if(nums[i]>0 && nums[i]<=len){
                res[nums[i]-1] = 1;
            }
        }

        for(int i=0; i<len; i++){
            if(res[i]==0){
                return i+1;
            }
        }
        return len+1;
    }
}