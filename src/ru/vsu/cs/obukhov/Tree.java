package ru.vsu.cs.obukhov;


public class Tree {

    private class Junction {
        public int meaning;
        public Junction left;
        public Junction right;

        Junction (int meaning) {
            this.meaning = meaning;
            this.left = null;
            this.right = null;
        }

        public String toString() {
            return String.format("%d",this.meaning);
        }
    }

    private Junction root;
    public int getSize() {
        return size;
    }

    private int size;

    public Tree () {
        this.size = -1;
        this.root = null;
    }

    public Junction Recursive (Junction curr , int  meaning) {
        if (curr==null) {
            return new Junction(meaning);
        }
        curr.left = Recursive(curr.left, meaning);
        curr.right = Recursive(curr.right, meaning);
        return curr;
    }

    public void add(int meaning) {
        root = Recursive(root, meaning);
        this.size++;
    }

    public void createTree (int countNLevel) {
        int counter = 0;
        while (counter <= countNLevel) {
            this.add(counter);
            counter++;
        }
    }

    public void beforeAction(StringBuilder sb, String padding, String pointer, Junction junction) {
        if (junction.left != null & junction.right != null) {
            sb.append(padding);
            sb.append(pointer);
            sb.append(junction.left);
            sb.append("\n");

            StringBuilder paddingBuilder = new StringBuilder(padding);
            paddingBuilder.append("│  ");

            String paddingForBoth = paddingBuilder.toString();
            String pointerForRight = "└─";
            String pointerForLeft = (junction.right != null) ? "├─" : "└─";

            beforeAction(sb, paddingForBoth, pointerForLeft, junction.left);
            beforeAction(sb, paddingForBoth, pointerForRight, junction.right);
        }
    }

    public void print() {
        StringBuilder sb = new StringBuilder();
        beforeAction(sb, "", "", this.root);
        System.out.print(sb.toString());
    }

}

