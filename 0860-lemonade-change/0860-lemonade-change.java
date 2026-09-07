class Solution {
    public boolean lemonadeChange(int[] bills) {
        int[] notes = new int[3];
        for(int i=0; i<bills.length; i++){
            // increment note u get
            // for five proceed
            // for 10 -> check if there is a 5 note, then dcecrement it and move foerward, if no five note then return false;
            // if 20 note, increment, then check if one five and 1 10 note then decrement them, otherwise check if there are 3x 5 notes -> then decrement it and proceed, otherwise return false
            if(bills[i]==5) notes[0]++;
            else if(bills[i]==10){
                notes[1]++;
                if(notes[0]<=0) return false;
                notes[0]--;
            }
            else {
                notes[2]++;
                if(notes[0] >0 && notes[1]>0){
                    notes[0]--;
                    notes[1]--;
                }
                else if(notes[0]>=3) notes[0]-=3;
                else return false;
            }

        
        }
        return true;
    }
}