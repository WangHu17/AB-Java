import java.util.*;

//AB17 从中序与后序遍历序列构造二叉树
public class Solution {
    
    int postIndex;
    HashMap<Integer, Integer> map;
    public TreeNode buildTree (int[] inorder, int[] postorder) {
        map = new HashMap<>();
        int len = inorder.length;
        postIndex = len - 1;
        for(int i=0; i<len; i++){
            map.put(inorder[i], i);
        }
        return build(inorder, postorder, 0, len - 1);
    }
    public TreeNode build(int[] inorder, int[] postorder, int inLeft, int inRight){
        if(inLeft > inRight)return null;
        int val = postorder[postIndex];
        TreeNode node = new TreeNode(val);
        int index = map.get(val);
        postIndex--;
        node.right = build(inorder, postorder, index + 1, inRight);
        node.left = build(inorder, postorder, inLeft, index - 1);
        return node;
    }
}