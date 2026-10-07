class Solution {
    public String removeKdigits(String num, int k) {
        Deque<Integer> st = new ArrayDeque<>();
        char[] digits = num.toCharArray();
        for(int i=0; i<num.length(); i++){
            int n = digits[i] - '0';
            while(!st.isEmpty() && n < st.peek() && k>0){ 
                st.pop();
                k-=1;
            }
            st.push(n);
        }
        while(k>0){
            st.pop();
            k-=1;
        }
        StringBuilder sb = new StringBuilder();
        for(int d: st){
            sb.append(d);
        }
        sb.reverse();
        int start = 0;
        while(start < sb.length() && sb.charAt(start)=='0') start++;
        String s = sb.substring(start);
        return s.isEmpty() ? "0": s;
    }
}