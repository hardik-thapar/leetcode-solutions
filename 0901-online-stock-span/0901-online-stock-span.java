class StockSpanner {
    class Pair{
        int val;
        int span;
        Pair(int val, int span){
            this.val = val;
            this.span = span;
        }
    }
    private Deque<Pair> st;
    public StockSpanner() {
        this.st = new ArrayDeque<>();
    }
    
    public int next(int price) {
        if(st.isEmpty()){
            st.push(new Pair(price, 1));
            return 1;
        }
        int span = 1;
        while(!st.isEmpty() && price >= st.peek().val){
            span += st.pop().span;
        }
        st.push(new Pair(price, span));
        return span;
    }
    
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */