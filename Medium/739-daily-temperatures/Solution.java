class Solution {
    public class Pair{
        int val;
        int ind;

        public Pair(int val,int ind){
            this.val = val;
            this.ind = ind;
        }
    }
    public int[] dailyTemperatures(int[] temp) {
        Stack<Pair> st = new Stack<>();
        int[] res = new int[temp.length];

        for(int i=0; i<temp.length; i++){
            while(!st.isEmpty() && st.peek().val<temp[i]){
                res[st.peek().ind] = i - st.pop().ind;
            }
            st.add(new Pair(temp[i],i));
        }

        return res;
    }
}