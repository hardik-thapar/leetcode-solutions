class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        int score = 0;
        int x = tokens.length-1;
        int i =0;
        int res = 0;
        if(tokens.length==1 && power<tokens[0]) return 0;
        while(i<=x){
            //case 1: i have sufficient power-> decrement power and add to score
            
            if(power >= tokens[i]){
                power-=tokens[i];
                score++;
                i++;
            }
            // case 2: i dont have sufficient power, take from xth idx and decrement score
            else if(power<tokens[i] && score>=1){
                power+=tokens[x];
                x--;
                score--;
            }
            else{
                break;
            }
            res = Math.max(score, res);
        }
        return res;
    }
}