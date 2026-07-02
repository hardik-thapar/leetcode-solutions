class Solution {
    public int openLock(String[] deadends, String target) {
        HashSet<String> dead_end = new HashSet<>();
        HashSet<String> visited = new HashSet<>();
        for(String word: deadends){
            dead_end.add(word); 
        }
        if(target.equals("0000")) return 0;
        if(dead_end.contains("0000")) return -1;
        Queue<String> q = new LinkedList<>();
        q.add("0000");
        int level = 0;
        while(!q.isEmpty()){
            int size = q.size();
            level++;
            for(int x=0; x<size; x++){
                char[] curr = q.poll().toCharArray();
                
                for(int pos=0; pos<4; pos++){
                    char ch = curr[pos];
                    // -1
                    if(curr[pos]=='0') curr[pos] = '9';
                    else curr[pos]-=1;
                    String next = new String(curr);
                    if (next.equals(target)) return level;
                    if(!dead_end.contains(next) && !visited.contains(next)){
                        q.add(next);
                    }
                    visited.add(next);

                    curr[pos] = ch;
                    // +1
                    if(curr[pos]=='9') curr[pos] = '0';
                    else curr[pos]+=1;
                    next = new String(curr);
                    if (next.equals(target)) return level;
                    if(!dead_end.contains(next) && !visited.contains(next)){
                        q.add(next);
                    }
                    visited.add(next);
                    curr[pos] = ch;
                }
            }
            
        }
        return -1;
    }
}