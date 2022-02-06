public class Driver {
    public static void main(String[] args) {
        Node root=new Node(new int[]{10,5,9});
        KDBTree kdb = new KDBTree(root, 3);
        kdb.insert(new int[]{8,0,11});
        kdb.insert(new int[]{13,4,7});
        kdb.insert(new int[]{9,-2,15});
        kdb.insert(new int[]{8,-4,18});
        kdb.insert(new int[]{14,2,8});
        kdb.insert(new int[]{11,7,10});
        kdb.insert(new int[]{0,-3,17});

        kdb.print();

        System.out.println();
        System.out.println();
        System.out.println();

        kdb.search(new int[]{0,-3,17});
        kdb.search(new int[]{5,5,5});
    }
}
