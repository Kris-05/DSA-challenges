//1110. Delete Nodes And Return Forest

/*
Given the root of a binary tree, each node in the tree has a distinct value.
After deleting all nodes with a value in to_delete, we are left with a forest (a disjoint union of trees).
Return the roots of the trees in the remaining forest. You may return the result in any order.

Input: root = [1,2,3,4,5,6,7], to_delete = [3,5]
Output: [[1,2,null,4],[6],[7]]
*/

class Solution {
    //Global declaration cuz need not pass everytime in recursion calls
    List<TreeNode> res = new ArrayList<>();
    Set<Integer> toDelete = new HashSet<>();

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
    //Set will be easier to use beacuse of .contains(ele)
        for(int ele : to_delete)
            toDelete.add(ele);

        createForest(root, true);
        return res;
    }

    private TreeNode createForest(TreeNode node, boolean isRoot){
        if(node == null) return null;
    
        boolean isDelete = toDelete.contains(node.val);
    //If a node is root then it will be added to res
        if(isRoot && !isDelete) 
            res.add(node);
    //If a node is going to be deleted then their child nodes will be roots.
    //So we pass isDelete to indicate that node will eithr be a root or not 
        node.left = createForest(node.left, isDelete);
        node.right = createForest(node.right, isDelete);

        return isDelete ? null : node;
    }
}
