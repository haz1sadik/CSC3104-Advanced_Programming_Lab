package PracticeQuestions;

class Node{
    int info;
    Node link;
    Node(){
        this.link = null;
    }

    Node(int info) {
        this.info = info;
        this.link = null;
    }

    @Override
    public String toString() {
        return String.valueOf(info);
    }
}
public class LinkList {
    public static void main(String[] args) {
        Node list = new Node(18);
        list.link = new Node(32);
        list.link.link = new Node(23);
        list.link.link.link = new Node(16);
        list.link.link.link.link = new Node(43);
        list.link.link.link.link.link = new Node(87);
        list.link.link.link.link.link.link = new Node(25);
        list.link.link.link.link.link.link.link = new Node(44);

        // Setting pointers A and B
        Node A = list.link;       // A points to node 32
        Node B = list.link.link.link.link.link;

        System.out.println("Original");
        System.out.println(A);
        System.out.println(B);

        //Question a
        /*
        System.out.println("\nQA");
        A = A.link;
        System.out.println(A);
         */

        //Question b
        /*
        System.out.println("\nQB");
        list = A.link.link;
        System.out.println(list);
         */

        //Question c
        /*
        System.out.println("\nQC");
        B = B.link.link;
        System.out.println(B);
         */

        //Question d
        /*
        System.out.println("\nQD");
        list = null;
        System.out.println(list);
         */

        //Question e
        /*
        System.out.println("\nQE");
        B.link.info = 35;
        System.out.println(B.link);
         */

        //Question f
        /*
        System.out.println("\nQF");
        Node node = new Node();
        node.info = 10;
        node.link = A.link;
        A.link = node;
        System.out.println(A.link);
         */

        //Question g
        System.out.println("\nQG");
        System.out.println(A.link);
        A.link = A.link.link;
        System.out.println(A.link);
    }
}
