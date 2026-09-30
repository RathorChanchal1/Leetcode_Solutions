class Solution {
    public int lengthOfLongestSubstring(String s) {
        int i=0; int j=0;
        int max = 0;
        Map<Character,Integer> map = new HashMap<>();
        while(i<s.length() && j<s.length()){
            if(map.containsKey(s.charAt(i))){
                while(j<map.get(s.charAt(i))){
                    map.remove(s.charAt(j));
                    j++;
                }
                j++;
            }
            map.put(s.charAt(i),i);
            max = Math.max(max, i-j+1);
            i++;
        }

        return max;
    }
}