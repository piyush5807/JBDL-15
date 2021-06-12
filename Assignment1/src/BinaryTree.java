import java.util.*;


public class BinaryTree {

    private static class Node {
        Person person;
        Node left;
        Node right;

        public Node(Person person) {
            this.person = person;
        }

        public Person getPerson() {
            return person;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "person=" + person.toString() +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }


    Node root;
    public BinaryTree() {
        this.root = null;
    }

    public void traverseTree(Node node, HashMap<Person, Integer> personMap) {

        if(node == null) {
            return;
        }

        traverseTree(node.left, personMap);
        if(personMap.containsKey(node.getPerson())) {
            personMap.put(node.getPerson(), personMap.get(node.getPerson()) + 1);
        }else {
            personMap.put(node.getPerson(), 1);
        }
        traverseTree(node.right, personMap);

    }
    public HashMap<Person, Integer> findPersonMap(Node root) {
        HashMap<Person, Integer> result = new HashMap<>();
        traverseTree(root, result );

        return result;
    }

    public static void main(String[] args) {
        Person p1 = new Person(20, "tim", 175);
        Person p2 = new Person(16, "jim", 185);
        Person p3 = new Person(75, "tom", 167);
        Person p4 = new Person(16, "jim", 185);
        Person p5 = new Person(20, "tim", 175);
        Person p6 = new Person(16, "jim", 180);
        Person p7 = new Person(75, "tom", 167);

        BinaryTree tree = new BinaryTree();
        tree.root = new Node(p1);
        tree.root.left = new Node(p2);
        tree.root.right = new Node(p3);
        tree.root.left.left = new Node(p4);
        tree.root.left.right = new Node(p5);
        tree.root.right.left = new Node(p6);
        tree.root.right.right = new Node(p7);

        HashMap<Person, Integer> finalResult = tree.findPersonMap(tree.root);
        System.out.println(finalResult.toString());


    }


}

