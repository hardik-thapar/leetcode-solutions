class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for(char c: s.toCharArray()){
            if (c == '(' || c == '[' || c == '{'){
                stack.push(c);
            }

            else if (c == ')'){
                if(stack.isEmpty()) return false;
                if (!stack.peek().equals('(')) return false;
                stack.pop();
            }

            else if (c == '}'){
                if(stack.isEmpty()) return false;
                if (!stack.peek().equals('{')) return false;
                stack.pop();
            }

            else if (c == ']'){
                if(stack.isEmpty()) return false;
                if (!stack.peek().equals('[')) return false;
                stack.pop();
            }

            else{
                return false;
            }
        }
        if(stack.isEmpty()) return true;
        return false;
    }
}