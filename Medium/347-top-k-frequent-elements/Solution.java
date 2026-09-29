class Solution {
    class Pair{
        int val;
        int freq;

        Pair(int val, int freq){
            this.val = val;
            this.freq = freq;
        }
        
    }
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Pair> que = new PriorityQueue<>((a,b)->b.freq-a.freq);

        for(int i=0; i<nums.length; i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i], map.get(nums[i])+1);
            }else{
                map.put(nums[i],1);
            }
        }
        for(int key: map.keySet()){
            que.add(new Pair(key,map.get(key)));
        }

        int[] res = new int[k];

        for(int i=0; i<k; i++){
            res[i] = que.poll().val;
        }

        return res;


    }
}