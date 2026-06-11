class Solution {
    public void comparision(Stack<Integer> st, int[] target){

    }
    public List<String> buildArray(int[] target, int n) {
        List<String> res = new ArrayList<>();
        int temp = 0;
        for(int i=1;i<=target[target.length-1];i++){
            if(i==target[temp]){
                res.add("Push");
                temp++;
            }
            else{
            res.add("Push");
            res.add("Pop"); }
        }
        return res;
    }
}