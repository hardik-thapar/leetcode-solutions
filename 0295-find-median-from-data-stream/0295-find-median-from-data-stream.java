class MedianFinder {
    PriorityQueue<Integer> left = new PriorityQueue<>(Collections.reverseOrder());
    PriorityQueue<Integer> right = new PriorityQueue<>();
    public MedianFinder() {
        
    }
    public void balance(){
        while(left.size() - right.size() > 1){
            right.offer(left.poll());
        }
        while(right.size() - left.size() > 1){
            left.offer(right.poll());
        }
        return;
    }
    public void addNum(int num) {
        if(left.isEmpty() && right.isEmpty()){
            left.offer(num);
        }

        else{
            if(num >= left.peek()) right.offer(num);
            else left.offer(num);
        }
        balance();
        return;
    }
    
    public double findMedian() {
        int l = left.size();
        int r = right.size();
        if(l>r) return (double)left.peek();
        if (r>l) return (double)right.peek();
        int x = left.peek() + right.peek();
        return (double) x/2.0;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */