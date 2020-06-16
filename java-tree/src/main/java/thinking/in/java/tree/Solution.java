package thinking.in.java.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Stream;

/**
 * TODO
 *
 * @author yitian
 * @date 2020/6/11 14:07
 */
public class Solution {

    public static List<Integer> inorderTraversal(TreeNode root) {
        List < Integer > res = new ArrayList<>();
        helper(root, res);
        return res;
    }

    public static void helper(TreeNode root, List<Integer> res) {
        if (root != null) {
            if (root.left != null) {
                helper(root.left, res);
            }
            res.add(root.val);
            if (root.right != null) {
                helper(root.right, res);
            }
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode root_right = new TreeNode(2);
        TreeNode left = new TreeNode(3);
        root.setLeft(null);
        root.setRight(root_right);
        root_right.setLeft(left);

        List<Integer> i = inorderTraversal(root);
        i.stream().forEach(integer -> System.out.println(integer));



    }

    /**
     * 基于栈的遍历
     * @param root
     * @return
     */
    public static List <Integer> inorderTraversal1(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            res.add(curr.val);
            curr = curr.right;
        }
        return res;
    }

    /**
     * 莫里斯遍历
     * @param root
     * @return
     */
    public static List <Integer> inorderTraversal2(TreeNode root) {
        List < Integer > res = new ArrayList < > ();
        TreeNode curr = root;
        TreeNode pre;
        while (curr != null) {
            if (curr.left == null) {
                res.add(curr.val);
                // move to next right node
                curr = curr.right;
            } else {
                // has a left subtree
                pre = curr.left;
                while (pre.right != null) {
                    // find rightmost
                    pre = pre.right;
                }
                // put cur after the pre node
                pre.right = curr;
                // store cur node
                TreeNode temp = curr;
                // move cur to the top of the new tree
                curr = curr.left;
                // original cur left be null, avoid infinite loops
                temp.left = null;
            }
        }
        return res;
    }


    class ColorNode {
        TreeNode node;
        String color;

        public ColorNode(TreeNode node,String color){
            this.node = node;
            this.color = color;
        }
    }
    public List<Integer> inorderTraversal4(TreeNode root) {
        if(root == null) {
            return new ArrayList<Integer>();
        }

        List<Integer> res = new ArrayList<>();
        Stack<ColorNode> stack = new Stack<>();
        stack.push(new ColorNode(root,"white"));

        while(!stack.empty()){
            ColorNode cn = stack.pop();

            if(cn.color.equals("white")){
                if(cn.node.right != null){
                    stack.push(new ColorNode(cn.node.right,"white"));
                }
                stack.push(new ColorNode(cn.node,"gray"));
                if(cn.node.left != null){
                    stack.push(new ColorNode(cn.node.left,"white"));
                }
            }else{
                res.add(cn.node.val);
            }
        }

        return res;
    }


    银行柜台的取款和存款函数设计
        重点考虑并发控制及边界判断




}
