class Solution {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] r = new int[len];
        int[] l = new int[len];
        for(int i=0; i<len; i++){
            if(i==0){
                l[i]=1;
                r[len-i-1]=1;
            }else{
                l[i] = nums[i-1]*l[i-1];
                r[len-i-1] = nums[len-i]*r[len-i];
            }
        }

        for(int i=0; i<len; i++){
            l[i] = l[i]*r[i];
        }

        return l;
    }
}