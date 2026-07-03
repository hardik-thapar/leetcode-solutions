class Solution {
    public int openLock(String[] deadends, String target) {
        if(target.equals("0000")) return 0;
        Set<String> dead_end = new HashSet<>();
        Set<String> visited = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        for(String dead: deadends){
            dead_end.add(dead);
        }
        if(dead_end.contains("0000")) return -1;
        
        q.add("0000");
        int level = 0;
        String next;
        while(!q.isEmpty()){
            int size = q.size();
            level++;
            for(int x=0; x<size; x++){
                String curr = q.poll();
                char[] c = curr.toCharArray();

                for(int a=0; a<4; a++){
                    char ch = c[a];
                    // +1
                    if(c[a]=='9') c[a] = '0';
                    else c[a]+=1;
                    next = new String(c);
                    if (next.equals(target)) return level;
                    if(!dead_end.contains(next) && !visited.contains(next)) q.offer(next);
                    visited.add(next);
                    // -1
                    c[a] = ch;
                    if(ch=='0') c[a] = '9';
                    else c[a]-=1;
                    next = new String(c);
                    if (next.equals(target)) return level;
                    if(!dead_end.contains(next) && !visited.contains(next)) q.offer(next);
                    c[a] = ch;
                    visited.add(next);
                    
                }

            }
            // level++;
        }
        return -1;
    }
}