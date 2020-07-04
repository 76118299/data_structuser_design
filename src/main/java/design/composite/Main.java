package design.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * 组合模式
 */
abstract class Node{
    abstract public void p();
}

/**
 * 叶子节点
 */
class LeftNode extends  Node{
    String content;
    public void p() {
        System.out.printf(content);
    }
}

/**
 * 子节点
 */
class BranchNoe extends Node{
    String name;
    List<Node> nodes = new ArrayList<Node>();
    public void p() {
        System.out.printf(name);
    }

    public BranchNoe(String name) {
        this.name = name;
    }

    public void add(Node node){
        nodes.add(node);
    }
}
public class Main {

}
