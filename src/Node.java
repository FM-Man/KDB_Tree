public class Node {
    public String name;
    public int[] coordinates;
    public Node leftChild, rightChild, parent;
    public boolean isLeftChild;
    public int generation;
    public int stringNo;

    public Node(int[] coordinates, Node parent, boolean isLeftChild){
        this.coordinates = coordinates;
        this.parent = parent;
        this.isLeftChild = isLeftChild;
        name = "";

        if(isLeftChild) parent.leftChild = this;
        else parent.rightChild = this;

        generation = parent.generation +1;

        if(isLeftChild) name += " L { ";
        else name += " R { ";
        for (int x:coordinates) {
            name += x+" ";
        }
        name+= "} ";
    }

    public Node(int[] coordinates) {
        this.coordinates = coordinates;
        name = "{ ";
        for (int x:coordinates) {
            name += x+" ";
        }
        name+= "} ";
    }

    public void setParent(Node parent, boolean isLeftChild){
        this.parent = parent;
        this.isLeftChild = isLeftChild;

        if(isLeftChild) parent.leftChild = this;
        else parent.rightChild = this;

        generation = parent.generation +1;
    }

    public void setLeftChild(int[] coordinates){
        Node n = new Node(coordinates, this, true);
    }

    public void setRightChild(int[] coordinates){
        Node n = new Node(coordinates, this, false);
    }

    public Node previousSibling(){
        if(parent == null) return null;
        else if(isLeftChild) return null;
        else return parent.leftChild;
    }
}
