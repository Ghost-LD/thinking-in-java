package leetcode.ntree;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

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





}
