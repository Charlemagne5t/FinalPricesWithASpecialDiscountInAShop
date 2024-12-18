import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int[] finalPrices(int[] prices) {
        int[] res = new int[prices.length];
        Deque<Integer> stack = new ArrayDeque<>();
        res[prices.length - 1] = prices[prices.length - 1];
        stack.push(prices[prices.length - 1]);

        for (int i = prices.length - 2; i >= 0; i--) {
            int disc = 0;
            while (!stack.isEmpty() && stack.peek() > prices[i]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                disc = stack.peek();
            }
            stack.push(prices[i]);
            res[i] = prices[i] - disc;

        }

        return res;
    }
}