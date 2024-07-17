//2096. Step-By-Step Directions From a Binary Tree Node to Another

/*
You are given the root of a binary tree with n nodes. Each node is uniquely assigned a value from 1 to n. You are also given an integer startValue representing 
the value of the start node s, and a different integer destValue representing the value of the destination node t.

'L' means to go from a node to its left child node.
'R' means to go from a node to its right child node.
'U' means to go from a node to its parent node.

Return the step-by-step directions of the shortest path from node s to node t.
*/

class Solution {
    private boolean DFS(TreeNode node, int target, StringBuilder str){
        if(node.val == target)
            return true;
    //check in the left subtree of the tree 
        if(node.left != null && DFS(node.left, target, str))
            str.append("L");
    //check in the right subtree of the tree
        else if(node.right != null && DFS(node.right, target, str))
            str.append("R");

    //to make sure it goes to the right subtree if the element doesn't exist in the left subtree   
        return str.length() > 0;
    }
    public String getDirections(TreeNode root, int startValue, int destValue) {
        StringBuilder start = new StringBuilder();
        StringBuilder dest = new StringBuilder();

        DFS(root, startValue, start);
        DFS(root, destValue, dest);

        int i = 0;
        int n = start.length(), m = dest.length();
        int count = Math.min(n, m);
    //if they are in the same side they share a common substring in the front
        while(i < count && start.charAt(n-i-1) == dest.charAt(m-i-1))
            i++;
    //change every "L" and "R" from the left to "U"
        String s = "U".repeat(n-i);
    //string starts from bottom. So we reverse it and find the common substring from i, if exists
        String d = dest.reverse().toString().substring(i);

        return s + d;        
    }
}
