class Solution {
    public boolean repeatedSubstringPattern(String s) {
        //add both and check 
        String check = s + s;
        //if we check directly without doing something check contains s
        //but what is we remove one char from front and start we can make sure
        //if repeation happened or not
        if(check.substring(1, check.length() - 1).contains(s)) return true;
        return false;

    }
}