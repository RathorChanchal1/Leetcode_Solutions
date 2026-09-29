class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> res = new ArrayList<>();

        for(int i=0; i<nums.length-1; i++){
            List<List<Integer>> temp = twoSum(nums, i+1,nums.length-1,nums[i]*(-1));
            if(temp.size()>0){
                for(int j=0; j<temp.size(); j++){
                    temp.get(j).add(nums[i]);
                    res.add(temp.get(j));
                }
            }

            while(i<nums.length-1 && nums[i]==nums[i+1]){
                i++;
            }
        }

        return res;
    }

    public List<List<Integer>> twoSum(int[] nums, int i, int j, int target){
        List<List<Integer>> res = new ArrayList<>();
        while(i<j){
            int sum = nums[i]+nums[j];
            if(sum==target){
                List<Integer> ele = new ArrayList<>();
                ele.add(nums[i]);
                ele.add(nums[j]);
                res.add(ele);

                while(i<nums.length-1 && nums[i+1]==nums[i]){
                    i++;
                }

                while(j>0 && nums[j]==nums[j-1]){
                    j--;
                }

                i++;
                j--;
            }else if(sum<target){
                i++;
            }else{
                j--;
            }
        }

        return res;
    }
}