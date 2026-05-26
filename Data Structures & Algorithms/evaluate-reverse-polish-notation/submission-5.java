class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].equals("+")) {
                int input = stack.pop() + stack.pop();
                stack.push(input);
            } else if (tokens[i].equals("-")) {
                int input = stack.pop() - stack.pop();
                stack.push(input * -1);
            } else if (tokens[i].equals("*")) {
                int input = stack.pop() * stack.pop();
                stack.push(input);
            } else if (tokens[i].equals("/")) {
                int top = stack.pop();
                int input = stack.pop() / top;
                stack.push(input);
            } else {
                stack.push(Integer.parseInt(tokens[i]));
            }
        }
        return stack.pop();
    }
}
