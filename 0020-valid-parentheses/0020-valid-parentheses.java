class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for(char c: s.toCharArray()){
            if (c == '(' || c == '[' || c == '{'){
                stack.push(c);
            }
            else{
                if (stack.isEmpty()) return false;
                if(c==')'){
                    if(stack.peek()!='(') return false;
                    stack.pop();
                }
                else if(c=='}'){
                    if(stack.peek()!='{') return false;
                    stack.pop();
                }
                else{
                    if(stack.peek()!='[') return false;
                    stack.pop();
                }
            }
        }
        if(!stack.isEmpty()) return false;
        return true;
    }
}