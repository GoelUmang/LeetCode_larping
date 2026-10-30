class Solution {
    public String resultingString(String s) {
        //stack
        //pop till the constraints allow so
            //constrains are 
            // (peek == peek - 1 or peek = peek + 1 or )
        // return the s in rev
        Stack<Character> stack = new Stack<>();

        for(char c : s.toCharArray()){
            //c - a // normalises to 1 - 26 
            //-1 for prev and +1 for next
            // + 26, so a - a - 1 = -1 hell nah 26 makes wrap 
            // % 26 wrapping and then casting
            char prevChar = (char) (((c - 'a' - 1 + 26) % 26) + 'a');
            char nextChar = (char) (((c - 'a' + 1) % 26) + 'a');
            //boolean flag = true;

            if(!stack.isEmpty() && (stack.peek() == prevChar || stack.peek() == nextChar)){
                stack.pop();
                
            }
            else stack.push(c);
        }
        StringBuilder sb = new StringBuilder();
        for(char c : stack){
            sb.append(c);
        }
        //sb.reverse();
        return sb.toString();
    }
}