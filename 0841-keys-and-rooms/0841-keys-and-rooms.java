class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] key = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        for(int x: rooms.get(0)){
            q.add(x);
        }
        key[0] = true;
        // int level = 1;
        while(!q.isEmpty()){
            int node = q.poll();
            key[node] = true;
            for(int x: rooms.get(node)){
            if(!key[x]) q.add(x);
            }

        }

        for(boolean x: key){
            if(x==false) return false;
        }
        return true;
    }
}