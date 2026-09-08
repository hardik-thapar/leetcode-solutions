class Solution {
    public boolean checkValidString(String s) {
        Deque<Integer> open = new ArrayDeque<>();
        Deque<Integer> ast = new ArrayDeque<>();
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)==')'){
                // if opening
                if(!open.isEmpty()) open.pop();
                else if(!ast.isEmpty()) ast.pop();
                else return false;
            }
            else if (s.charAt(i)=='(') open.push(i);
            else ast.push(i);
        }

        while(!open.isEmpty() && !ast.isEmpty()){
            if(open.peek() > ast.peek()) return false;
            open.pop();
            ast.pop();
            
        }
        if(!open.isEmpty()) return false;
        return true;
    }
}