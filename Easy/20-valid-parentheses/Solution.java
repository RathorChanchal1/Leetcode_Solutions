class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        HashMap<Character,Character> map = new HashMap<>();
        map.put(')','(');
        map.put('}','{');
        map.put(']','[');

        int len = s.length();

        for(int i=0; i<len; i++){
            if(!st.isEmpty() && st.peek().equals(map.get(s.charAt(i)))){
                st.pop();
            }else{
                st.add(s.charAt(i));
            }
        }

        return st.isEmpty();
    }
}