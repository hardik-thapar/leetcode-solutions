class KthLargest {
    int K;
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    public void check(){
        while(pq.size()>K){
            pq.poll();
        }
    }
    public KthLargest(int k, int[] nums) {
        this.K = k;
        for(int x: nums){
            pq.offer(x);
        }
        check();
    }
    
    public int add(int val) {
        pq.offer(val);
        check();
        return pq.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */