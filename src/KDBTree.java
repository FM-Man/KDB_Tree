import java.util.ArrayList;
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

    }


    public void print(){
        if(root == null) return;
        System.out.print("[ ");
        for (int x:root.coordinates) {
            System.out.print(x+" ");
        }
        System.out.println("]");
        print("----L: ", root.leftChild);
        print("----R: ", root.rightChild);
    }
    public void print(String s, Node node){
        if(node == null) return;
        System.out.print(s+"[ ");
        for (int x:node.coordinates) {
          System.out.print(x+" ");
        }
        System.out.println("]");
        print(s.substring(0,s.length()-3)+"----L: ", node.leftChild);
        print(s.substring(0,s.length()-3)+"----R: ", node.rightChild);
    }


    public void search(int[] coordinates){
        boolean flag = false;
        int currentLevel = 0;
        Node node = root;
        while(true){
            if(match(node.coordinates, coordinates)){
                System.out.println("Node found");
                printNodeLineage(node);
                flag = true;
                break;
            }
            else if(coordinates[currentLevel] < node.coordinates[currentLevel]){
                if(node.leftChild != null){
                    currentLevel = (currentLevel+1)%dimension;
                    node = node.leftChild;
                }
                else
                    break;
            }
            else {
                if (node.rightChild != null){
                    currentLevel = (currentLevel+1)%dimension;
                    node = node.rightChild;
                }
                else
                    break;
            }
        }
        if(!flag)
            System.out.println("Node Not found");
    }
    private boolean match(int[] a, int[] b){
        //boolean flag = false;
        for (int i=0; i<a.length;i++) {
            if(a[i] != b[i]){
                return false;
            }
        }
        return true;
    }
    private void printNodeLineage(Node node){
        while (true){
            for (int a: node.coordinates) {
                System.out.print(a+" ");
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


    public void search(int[] leftBound, int[] rightBound){
        //Integer[] l = leftBound;
        ArrayList<int[]> correctedBound = correctRange(leftBound,rightBound);
        find(correctedBound.get(0),correctedBound.get(1),root,0);
    }
    private ArrayList<int[]> correctRange(int[] left, int[] right){
        for(int i=0; i<left.length;i++){
            if(left[i] > right[i]){
                int temp = left[i];
                left[i] = right[i];
                right[i] = temp;
            }
        }
        ArrayList<int[]> ret = new ArrayList<>();
        ret.add(left);
        ret.add(right);
        return ret;
    }
    private void find(int[] leftBound, int[] rightBound, Node node, int currentLevel){
        if(node == null)
            return;

        //recursion for the left child
        if(leftBound[currentLevel] < node.coordinates[currentLevel])
            find(leftBound,rightBound, node.leftChild, (currentLevel+1)%dimension);


//        //checking and printing
//        if(leftBound[currentLevel] <= node.coordinates[currentLevel] && rightBound[currentLevel] >= node.coordinates[currentLevel]){
//            for (int x:node.coordinates) {
//                System.out.print(x+" ");
//            }
//            System.out.println();
//        }

        //checking and printing if it is in the "rectangle"
        boolean flag = true;
        for(int i=0; i<leftBound.length;i++){
            if(leftBound[i] > node.coordinates[i] || rightBound[i] < node.coordinates[i]){
                flag =false;
                break;
            }
        }
        if(flag){
            for(int x:node.coordinates){
                System.out.print(x+" ");
            }
            System.out.println();
        }

        //recursion for the right child
        if(rightBound[currentLevel] > node.coordinates[currentLevel])
            find(leftBound,rightBound,node.rightChild,(currentLevel+1)%dimension);
    }

}
