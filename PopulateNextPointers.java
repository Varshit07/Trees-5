/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/
/**
 * TC: O(N)
 * SC: O(1)
 * LeetCode: Y (https://leetcode.com/problems/populating-next-right-pointers-in-each-node/)
 * Approach: At each level, populate the next pointers of nodes of the level below the current level
             Populating logic: current.left.next = current.right, current.right.next = current.next.left
             Go down one level and poulate the nodes next pointer at the next level
 */
class Solution {
    public Node connect(Node root) {
        // edge case
        if(root == null) {
            return root;
        }
        
        // track the leftmost node of current level
        Node currentLevelVertical = root;
        
        // Go leftmost as down as possible
        while(currentLevelVertical.left != null) {
            // track the current node horizontally
            Node currentNodeHorizontal = currentLevelVertical;
            
            // traverse the current level horizontally
            while(currentNodeHorizontal != null) {
                // populate left child
                currentNodeHorizontal.left.next = currentNodeHorizontal.right;
                
                // check to avoid null pointer exception on the rightmost node
                if(currentNodeHorizontal.next != null) {
                    // populate right child
                    currentNodeHorizontal.right.next = currentNodeHorizontal.next.left;
                }
                // Mobe forward horizontally
                currentNodeHorizontal = currentNodeHorizontal.next;
            }
            // Go down vetically in depth
            currentLevelVertical = currentLevelVertical.left;
        }
        
        return root;
    }
}
