//1530. Number of Good Leaf Nodes Pairs

/*
You are given the root of a binary tree and an integer distance. A pair of two different leaf nodes of a binary tree is said to be good
if the length of the shortest path between them is less than or equal to distance.

Input: root = [1,2,3,4,5,6,7], distance = 3
Output: 2
Explanation: The good pairs are [4,5] and [6,7] with shortest path = 2. The pair [4,6] is not good because the length of ther shortest path between them is 4.
*/

class Solution {
    List<TreeNode> leaves = new ArrayList<>();          //to store all the leaves 
    Map<TreeNode, List<TreeNode>> map = new HashMap();  //to store the path from node to root

    public int countPairs(TreeNode root, int distance) {
        findLeaves(root, new ArrayList<>());
        int res = 0;

        for(int i=0; i<leaves.size(); i++){
            for(int j=i+1; j<leaves.size(); j++){
            //to check one leaf node with the other. here iterating by comparing adjacent ones
                List<TreeNode> iComp = map.get(leaves.get(i));
                List<TreeNode> jComp = map.get(leaves.get(j));
            //to check common ancestors
                for(int k=0; k<Math.min(iComp.size(), jComp.size()); k++){
                    if(iComp.get(k) != jComp.get(k)){
                    //to remove the common nodes we must remove it from both
                        int length = (iComp.size() - k) +(jComp.size() - k);
                        if(length <= distance)
                            res++;
                        break;
                    }
                }
            }
        }
        return res;
    }
    private void findLeaves(TreeNode node, List<TreeNode> path){
        if(node == null) return;
        List<TreeNode> temp = new ArrayList<>(path); //to store the path from root
        temp.add(node);

        if(node.left == null && node.right == null){
            leaves.add(node);       //add all leaf nodes 
            map.put(node, temp);    //add curr node & it's path from root
            return;
        }
        findLeaves(node.left, temp);
        findLeaves(node.right, temp);
    }
}
