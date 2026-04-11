class Solution {
    public boolean isValid(String s) {
        List<Character> list = new ArrayList<>();
        for (char c : s.toCharArray()){
            if (c==')'){
                if(list.isEmpty()){
                    return false;
                }
                if(list.get(list.size()-1)!='('){
                    return false;
                }
                list.remove(list.size()-1);
            }

            else if (c=='}'){
                if(list.isEmpty()){
                    return false;
                }
                if(list.get(list.size()-1)!='{'){
                    return false;
                }
                list.remove(list.size()-1);
            }

            else if (c==']'){
                if(list.isEmpty()){
                    return false;
                }
                if(list.get(list.size()-1)!='['){
                    return false;
                }
                list.remove(list.size()-1);
            }

            else{
                list.add(c);
            }
        }
    if (!list.isEmpty()) return false;
    return true;
    }
}