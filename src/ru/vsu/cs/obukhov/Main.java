package ru.vsu.cs.obukhov;

public class Main {

    public static void main(String[] args) {
        Tree tr = new Tree();
        tr.createTree(4);
        System.out.println(tr.getSize());
        tr.print();
    }
}
