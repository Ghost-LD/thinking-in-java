package leetcode.ntree;

import java.util.List;

/**
 * n叉树节点
 *
 * @author yitian
 * @date 2020/6/28 10:14
 */
public class NTreeNode {

    private int val;

    private List<NTreeNode> children;

    public NTreeNode(List<NTreeNode> children) {
        this.children = children;
    }

    public NTreeNode(int val) {
        this.val = val;
    }

    public NTreeNode(int val, List<NTreeNode> children) {
        this.val = val;
        this.children = children;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public List<NTreeNode> getChildren() {
        return children;
    }

    public void setChildren(List<NTreeNode> children) {
        this.children = children;
    }
}
