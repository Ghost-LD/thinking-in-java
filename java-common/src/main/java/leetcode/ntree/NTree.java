package leetcode.ntree;

import java.util.*;

/**
 * n叉树
 *
 * @author yitian
 * @date 2020/6/28 10:13
 */
public class NTree {

    List<Integer> list = new ArrayList<>();

    /**
     * 前序递归
     * @param nTreeNode
     * @return
     */
    public List<Integer> preoder(NTreeNode nTreeNode){
        helper(nTreeNode);
        return list;
    }

    public void helper(NTreeNode nTreeNode){
        if(nTreeNode == null){
            return;
        }
        list.add(nTreeNode.getVal());
        List<NTreeNode> tempList = nTreeNode.getChildren();
        if(tempList ==null || tempList.size()<=0){
            return;
        }
        for(int i =0;i<nTreeNode.getChildren().size();i++){
            helper(nTreeNode.getChildren().get(i));
        }
    }

    /**
     * 前序迭代
     * @return
     */
    public List<Integer> getList(NTreeNode node) {
        LinkedList<Integer> output = new LinkedList<>();
        if(node == null){
            return output;
        }
        LinkedList<NTreeNode> stack = new LinkedList<>();
        stack.add(node);
        while (!stack.isEmpty()){
            NTreeNode nTreeNode1 = stack.pollLast();
            output.add(nTreeNode1.getVal());
            Collections.reverse(nTreeNode1.getChildren());
            for (NTreeNode nTreeNode2: nTreeNode1.getChildren()){
                stack.add(nTreeNode2);
            }
        }
        return output;
    }

    /**
     * 后序迭代
     * @return
     */
    public List<Integer> getPostList(NTreeNode node) {
        LinkedList<Integer> output = new LinkedList<>();
        if(node == null){
            return output;
        }
        LinkedList<NTreeNode> stack = new LinkedList<>();
        stack.add(node);
        while (!stack.isEmpty()){
            NTreeNode nTreeNode1 = stack.pollLast();
            output.addFirst(nTreeNode1.getVal());
            for (NTreeNode nTreeNode2: nTreeNode1.getChildren()){
                stack.add(nTreeNode2);
            }
        }
        return output;
    }

}
