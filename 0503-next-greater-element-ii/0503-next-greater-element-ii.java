class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int[] res = new int[nums.length];
        Arrays.fill(res, -1);
        int n = nums.length;
        Deque<Integer> st = new ArrayDeque<>();
        for(int i=0; i<2*n; i++){
            int curr = nums[i%n];
            while(!st.isEmpty() && curr > nums[st.peek()]){
                res[st.pop()] = curr;
            }
            if(i<n) st.push(i);
        }
        return res;
    }
}