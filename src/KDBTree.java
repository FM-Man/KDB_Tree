import java.util.Scanner;

public class KDBTree {
    public Node root;
    public int dimension;

    public KDBTree(Node root, int dimension) {
        this.root = root;
        this.dimension = dimension;

    }
    public void insert(){
        Scanner scanner = new Scanner(System.in);
        int[] arr = new int[dimension];
        for (int i=0; i<dimension; i++){
            arr[i] = scanner.nextInt();
        }
        insert(arr);
    }
    public void insert(int[] coordinates){
        int currentLevel = 0;
        Node node = root;
        while(true){
            if(node.coordinates[currentLevel] > coordinates[currentLevel]){
                if(node.leftChild != null){
                    currentLevel = (currentLevel+1)%dimension;
                    node = node.leftChild;
                }
                else {
                    node.setLeftChild(coordinates);
                    node = node.leftChild;
                    break;
                }
            }
            else {
                if (node.rightChild != null){
                    currentLevel = (currentLevel+1)%dimension;
                    node = node.rightChild;
                }
                else {
                    node.setRightChild(coordinates);
                    node = node.rightChild;
                    break;
                }
            }
        }

        while (true){
            for (int a: node.coordinates) {
                System.out.print(a+",");
            }
            if(node.parent != null){
                if(node.isLeftChild)
                    System.out.print("L -> ");
                else
                    System.out.print("R -> ");

                node = node.parent;
            }
            else break;
        }
        System.out.println();
    }
}
