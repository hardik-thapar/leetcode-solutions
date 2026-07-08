class Solution {
    private Set<String> dead_ends = new HashSet<>();
    private Set<String> visited = new HashSet<>();
    public int openLock(String[] deadends, String target) {
        if(target.equals("0000")) return 0;
        for(String dead: deadends){
            dead_ends.add(dead);
        }
        if(dead_ends.contains("0000")) return -1;
        if(dead_ends.contains(target)) return -1;
        Queue<String> q = new LinkedList<>();
        q.add("0000");
        int level = 0;

        while(!q.isEmpty()){
            int size = q.size();
            for(int x=0; x<size; x++){
                String node = q.poll();
                char[] curr = node.toCharArray();

                for(int k=0; k<4; k++){
                    char ch = curr[k];
                    // next +1
                    if(ch=='9') curr[k]='0';
                    else curr[k]+=1;
                    String next = new String(curr);
                    if(next.equals(target)) return level+1;
                    if(!dead_ends.contains(next) && !visited.contains(next)){
                        q.offer(next);
                        visited.add(next);
                        }
                    
                    curr[k] = ch;
                    // next -1
                    if(ch=='0') curr[k]='9';
                    else curr[k] -=1;
                    next = new String(curr);
                    if(next.equals(target)) return level+1;
                    if(!dead_ends.contains(next) && !visited.contains(next)){
                        q.offer(next);
                        visited.add(next);
                        }
                    
                    curr[k] = ch;
                }
            }
            level++;    
        }
        return -1;
    }
}