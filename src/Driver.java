public class Driver {
    public static void main(String[] args) {
        Node root=new Node(new int[]{10,5});
        KDBTree kdb = new KDBTree(root, 2);
        kdb.insert(new int[]{8,7});
        kdb.insert(new int[]{5,5});
        kdb.insert(new int[]{9,11});
        kdb.insert(new int[]{1,3});
        kdb.insert(new int[]{8,2});
        kdb.insert(new int[]{7,15});
        kdb.insert(new int[]{9,12});
        kdb.insert(new int[]{15,8});
        kdb.insert(new int[]{17,5});
        kdb.insert(new int[]{11,9});
        kdb.insert(new int[]{12,7});
        kdb.insert(new int[]{22,6});
        kdb.insert(new int[]{10,10});
        kdb.insert(new int[]{13,13});

        kdb.print();

        System.out.println();
        System.out.println();
        System.out.println();

        int[] a = new int[]{7,13};
        int[] b = new int[]{12,6};
        kdb.search(a,b);
    }
}
