class Solution {
    private int[] sides = new int[4];
    private boolean check = false;
    private int num;
    private int[] sticks;
    private int sum = 0;

    private boolean isValid(int[] sides){
        for(int i=0; i<sides.length; i++){
            if(sides[i]!=sides[0]) return false;
        }
        return true;
    }

    private void dfs(int index){
        if(check==true) return;
        if(index==num){
            if(isValid(sides)) check = true;
            return;
        }
        if(isValid(sides)){
            sides[0]+=sticks[index];
            if(sides[0]>sum/4){
                sides[0]-=sticks[index];
                return;
            }
            dfs(index+1);
            if(check==true) return;
            sides[0]-=sticks[index];
        }
        else {for(int i=0; i<4; i++){
            sides[i]+=sticks[index];
            if(sides[i]>sum/4){
                sides[i]-=sticks[index];
                continue;
            }
            dfs(index+1);
            if(check==true) return;
            sides[i]-=sticks[index];
        }}
        return;
    }
    
    public boolean makesquare(int[] matchsticks) {
        if(matchsticks.length<4) return false;
        num = matchsticks.length;
        sticks = new int[num];
        int max = 0;

        for(int i=0; i<matchsticks.length; i++){
            sticks[i] = matchsticks[i];
            sum+=matchsticks[i];
            max = Math.max(max, matchsticks[i]);
        }
        if(sum%4!=0) return false;
        if(max>sum/4) return false;
        dfs(0);
        return check;

    }
}