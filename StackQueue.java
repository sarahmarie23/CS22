import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;
public class StackQueue {
    public static void main(String[] args) {
        Integer[] nums = {1, 2, -4, 10, -8, -17, 3}; //ints for splitStack
        Integer[] nums2 = {3, 5, 4, 17, 6, 83, 1, 84, 16, 37}; //ints for rearrange
        Stack<Integer> numStack = new Stack<Integer>();
        Queue<Integer> numQueue = new LinkedList<Integer>();
        
        for (Integer value : nums) {
            numStack.push(value);
        }
        
        for (Integer value : nums2) {
            numQueue.add(value);
        }
        
        splitStack(numStack);
        rearrange(numQueue);
    }
    public static void splitStack(Stack<Integer> numStack) {
        Queue<Integer> tempQueue = new LinkedList<Integer>();
        System.out.println("Original Stack: " + numStack);
        while (!numStack.isEmpty()) { //put all ints in temp queue. stack is now empty
            tempQueue.add(numStack.pop());
        }
        int oldQueueSize = tempQueue.size();
        for(int iterate = 0; iterate < oldQueueSize; iterate++) { //for loop as big as old size of queue
            int test = tempQueue.remove(); //remove value, if negative push to stack, if not add back to queue
            if (test > 0) {
                tempQueue.add(test);
            } else {
                numStack.push(test);
            }
        }
        
        while (!tempQueue.isEmpty()) { //push that queue (which only has positive ints) back on the stack
            numStack.push(tempQueue.remove());
        }
        System.out.println("Stack after: " + numStack);
        System.out.println("Pop the top value: " + numStack.pop());
    }
    public static void rearrange(Queue<Integer> numQueue) {
        Stack<Integer> tempStack = new Stack<Integer>();
        System.out.println("Original Queue: " + numQueue);
        int oldQueueSize = numQueue.size();
        for(int iterate = 0; iterate < oldQueueSize; iterate++) {
            int test = numQueue.remove();
            if (test %2==0) { //if the value is even, put it back in the queue
                numQueue.add(test);
            } else { //if odd, put it in the temporary stack
                tempStack.push(test);
            }
        }
        
        while (!tempStack.isEmpty()) { //add the odd values in the stack to the back of the queue
            numQueue.add(tempStack.pop());
        }
        System.out.println("Queue after: " + numQueue);
        System.out.println("Peek the front value: " + numQueue.peek());
    }
}