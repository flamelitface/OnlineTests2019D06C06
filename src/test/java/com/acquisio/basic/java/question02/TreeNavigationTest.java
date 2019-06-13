package com.acquisio.basic.java.question02;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TreeNavigationTest {

    private Node rootNode;

    private TreeNavigation treeNavigation = new TreeNavigation();

    private String result = "..2"+ System.lineSeparator() +
            "....7"+ System.lineSeparator() +
            "......2"+ System.lineSeparator() +
            "......6"+ System.lineSeparator() +
            "........5"+ System.lineSeparator() +
            "........11"+ System.lineSeparator() +
            "....5"+ System.lineSeparator() +
            "......9"+ System.lineSeparator() +
            "........4" + System.lineSeparator();

    @Before
    public void init() {
        Node n1 = new Node("6", new Node("5"), new Node("11"));
        Node n2 = new Node("7", new Node("2"), n1);
        Node n3 = new Node("9", new Node("4"));
        Node n4 = new Node("5", null, n3);
        rootNode = new Node("2", n2, n4);
    }

    @Test
    public void printTreeNodes() {
        assertEquals(result, treeNavigation.printTreeNodes(rootNode));
    }
}