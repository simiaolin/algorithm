package algoexpert.graph;

import java.util.ArrayList;
import java.util.List;

public class DepthFirstSearch {

    static class Node {
        String name;
        List<Node> children = new ArrayList<Node>();

        public Node(String name) {
            this.name = name;
        }

        public List<String> depthFirstSearch(List<String> array) {
            // Write your code here.
            array.add(name);
            for (Node child : children) {
                child.depthFirstSearch(array);
            }
            return array;
        }

        public Node addChild(String name) {
            Node child = new Node(name);
            children.add(child);
            return this;
        }

        public Node addChild(Node child) {
            children.add(child);
            return this;
        }
    }

    public static void main(String[] args) {
        Node a = new Node("A");
        Node b = new Node("B");
        Node c = new Node("C");
        Node d = new Node("D");
        Node e = new Node("E");
        Node f = new Node("F");
        Node g = new Node("G");
        Node h = new Node("H");
        Node i = new Node("I");
        Node j = new Node("J");
        Node k = new Node("K");
        a.addChild(b).addChild(c).addChild(d);
        b.addChild(e).addChild(f);
        d.addChild(g).addChild(h);
        f.addChild(i).addChild(j);
        g.addChild(k);
        ArrayList<String> list = new ArrayList<String>();
        List<String> res = a.depthFirstSearch(list);

        for (String s : res) {
            System.out.print(s + " ");
        }
    }

}
