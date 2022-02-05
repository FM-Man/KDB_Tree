import java.util.ArrayList;

public class Node {
    public int[] coordinates;
    public Node leftChild, rightChild, parent, sibling;
    public boolean isLeftChild;
    public int level;

    public Node(int[] coordinates, Node parent, boolean isLeftChild){
        this.coordinates = coordinates;
        this.parent = parent;
        this.isLeftChild = isLeftChild;

        if(isLeftChild) parent.leftChild = this;
        else parent.rightChild = this;

        level = parent.level+1;
    }

    public Node(int[] coordinates) {
        this.coordinates = coordinates;
    }

    public void setParent(Node parent, boolean isLeftChild){
        this.parent = parent;
        this.isLeftChild = isLeftChild;

        if(isLeftChild) parent.leftChild = this;
        else parent.rightChild = this;

        level = parent.level+1;
    }

    public void setLeftChild(int[] coordinates){
        Node n = new Node(coordinates, this, true);
    }

    public void setRightChild(int[] coordinates){
        Node n = new Node(coordinates, this, false);
    }
}
