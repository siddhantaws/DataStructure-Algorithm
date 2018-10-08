package com.wellsfargo.data_structure.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class TarjanOfflineLCA {

  void LCA(Node u) {
    MakeSet(u);
    Find(u).ancestor = u;
    for (Node v : u.children()) {
      LCA(v);
      Union(u, v);
      Find(u).ancestor = u;
    }
    u.colour = Node.black;
    Node v;
    for (Pair uv : P.pair()) {
      u = uv.u();
      v = uv.v();
      if (v.colour == Node.black
          && u != null && v != null
          && Find(u) == Find(v)     // required, but algorithm [3th Ed. p584] doesn't have it.
          ) {
        System.out.println("Tarjan's Lowest Common Ancestor of {" + u.data
            + ", " + v.data + "}: " + Find(v).ancestor.data);
      }
    }
  }

  Pair P;

  void MakeSet(Node x) {
    x.parent = x;
    x.rank = 0;
  }

  void Union(Node x, Node y) {
    Link(Find(x), Find(y));
  }

  void Link(Node x, Node y) {
    if (x.rank > y.rank)
      y.parent = x;
    else {
      x.parent = y;
      if (x.rank == y.rank)
        y.rank += 1;
    }
  }

  Node Find(Node x) {
    if (x != x.parent)
      x.parent = Find(x.parent);

    return x.parent;
  }

  static Node F = new Node('F');
  static Node B = new Node('B');
  static Node G = new Node('G');
  static Node A = new Node('A');
  static Node D = new Node('D');
  static Node I = new Node('I');
  static Node C = new Node('C');
  static Node E = new Node('E');
  static Node H = new Node('H');
  static Node X = new Node('X');

  static Node insert(Node node, Node child) {
    if (node == null)
      return child;

    if (child.data <= node.data) {
      node.left = insert(node.left, child);
      node.left.parent = node;
    } else {
      node.right = insert(node.right, child);
      node.right.parent = node;
    }

    return node;

  }

  static Node build_a_to_h() {
    Node root = null;
    root = insert(root, F);

    root = insert(root, B);
    root = insert(root, G);

    root = insert(root, A);
    root = insert(root, D);

    root = insert(root, I);

    root = insert(root, C);
    root = insert(root, E);
    root = insert(root, H);

    return (root);
  }


  public static void main(String[] args) {
    Node build_a_to_h = build_a_to_h();

    TarjanOfflineLCA tlca = new TarjanOfflineLCA();

    tlca.P = new Pair(I, C);

    // a tree walk of T with the initial call LCA.T:root/
    tlca.LCA(build_a_to_h);
  }

  static class Node {
    char data;
    Node left;
    Node right;
    Node parent;
    Node ancestor;

    static String black = "black";
    static String white = "white";

    String colour = white;

    int level;
    int height;
    int rank;

    Node(char data) {
      this.data = data;
    }

    List<Node> children() {
      return adjacent(false);
    }

    List<Node> adjacent(boolean isstack) {
      List<Node> l = new ArrayList<Node>();

      if (this.left != null) {
        l.add(this.left);
        this.left.level = this.level + 1;
      }

      if (this.right != null) {
        l.add(this.right);
        this.right.level = this.level + 1;
      }

      if (isstack)
        Collections.reverse(l);

      return l;
    }

    @Override
    public String toString() {
      return "data->"+data;
    }
  }


  static class Pair {
    Node u;
    Node v;

    Pair(Node u, Node v) {
      this.u = u;
      this.v = v;
    }

    List<Pair> pair() {
      List<Pair> list = new ArrayList<Pair>();
      list.add(this);
      return list;
    }

    Node u() {
      return this.u;
    }

    Node v() {
      return this.v;
    }

  }
}


