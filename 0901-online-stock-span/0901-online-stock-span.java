class StockSpanner {
    private List<Integer> stock;
    private int len;
    public StockSpanner() {
        this.stock = new ArrayList<>();
        this.len = 0;
    }
    
    public int next(int price) {
        stock.add(price);
        len++;
        int res = 0;
        for(int i=stock.size()-1; i>=0; i--){
            if(stock.get(i)>price) return res;
            res++;
        }
        return res;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */