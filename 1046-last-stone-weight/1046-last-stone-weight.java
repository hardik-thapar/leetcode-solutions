class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int x: stones){
            pq.offer(x);
        }
        int x = 0;
        int y = 0;
        while(pq.size()>1){
            y = pq.poll();
            x=pq.poll();
            if(x!=y) pq.offer(y-x);
        }
        if(pq.isEmpty()) return 0;
        return pq.peek();
    }
}