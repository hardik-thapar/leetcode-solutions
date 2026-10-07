class Solution {
    public boolean canArrange(int[] arr, int k) {
        // use modulo arithmetic -> use a freq map upto len k/2;
        // freq[r] == freq[k-r] 
        // freq[0] == even
        // freq[k/2] == even
        int[] freq = new int[k+1];
        for(int i=0; i<arr.length; i++){
            int num = arr[i];
            num = ((arr[i]%k)+k)%k;
            freq[num]++;
        }
        if(freq[0]%2!=0) return false;
        for(int r=1; r<=k/2; r++){
            if(r==k-r){if(freq[r]%2!=0) return false;}
            if(freq[r]!=freq[k-r]) return false;
        }
        return true;
    }
}