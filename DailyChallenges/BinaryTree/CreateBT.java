//2196. Create Binary Tree From Descriptions

/*
You are given a 2D integer array descriptions where descriptions[i] = [parenti, childi, isLefti] indicates that parenti is the parent of childi 
in a binary tree of unique values. Furthermore,

If isLefti == 1, then childi is the left child of parenti.
If isLefti == 0, then childi is the right child of parenti.

Construct the binary tree described by descriptions and return its root.
*/

class Solution {
    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer, TreeNode> map = new HashMap<>();   //to store Key: nodeValue ; Value: TreeNode
        Set<Integer> children = new HashSet<>();        //to keep track of children nodes

        for(int[] arr : descriptions){
            int parent = arr[0], child = arr[1], isLeft = arr[2];
            children.add(child);
        //check whether the parent is present or new to be created
            TreeNode node = map.getOrDefault(parent, new TreeNode(parent));

        //check whether the child id presemt or new to be created
            if(isLeft == 1){
                node.left = map.getOrDefault(child, new TreeNode(child));
                map.put(child, node.left);
            }
            else{
                node.right = map.getOrDefault(child, new TreeNode(child));
                map.put(child, node.right);
            }
            map.put(parent, node);
        }

    //iterate through description if it is not present in children map then return it
        int root = -1;
        for(int[] arr : descriptions){
            if(!children.contains(arr[0])){
                root = arr[0];
                break;
            }
        }

        return map.getOrDefault(root, null);
    }
}
