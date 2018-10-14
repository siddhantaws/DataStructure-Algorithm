package com.wellsfargo.data_structure.heap;

public class BinomialHeap<K extends Comparable> {

    private Node Nodes;
    private int size;

    public BinomialHeap() {
        Nodes = null;
        size = 0;
    }

    public boolean isEmpty() {
        return Nodes == null;
    }

    public int getSize() {
        return size;
    }

    public void makeEmpty() {
        Nodes = null;
        size = 0;
    }

    public void insert(K value) {
        if (value !=null) {
            Node temp = new Node(value);
            if (Nodes == null) {
                Nodes = temp;
                size = 1;
            } else {
                unionNodes(temp);
                size++;
            }
        }
    }

    private void displayHeap(Node r) {
        if (r != null) {
            displayHeap(r.child);
            System.out.print(r.key + " ");
            displayHeap(r.sibling);
        }
    }

    public void displayHeap() {
        System.out.print("\nHeap : ");
        displayHeap(Nodes);
        System.out.println("\n");
    }


    public void decreaseKeyValue(int old_value, int new_value) {
        Node temp = Nodes.findANodeWithKey(old_value);
        if (temp == null)
            return;
        temp.key = new_value;
        Node tempParent = temp.parent;

        while ((tempParent != null) && ( tempParent.key .compareTo(temp.key )>0 )) {
            Comparable z = temp.key;
            temp.key = tempParent.key;
            tempParent.key = z;

            temp = tempParent;
            tempParent = tempParent.parent;
        }
    }

    public K findMinimum() {
        return (K)Nodes.findMinNode().key;
    }


    public K extractMin() {
        if (Nodes == null)
            return null;

        Node temp = Nodes, prevTemp = null;
        Node minNode = Nodes.findMinNode();

        while (temp.key != minNode.key) {
            prevTemp = temp;
            temp = temp.sibling;
        }

        if (prevTemp == null) {
            Nodes = temp.sibling;
        } else {
            prevTemp.sibling = temp.sibling;
        }

        temp = temp.child;
        Node fakeNode = temp;

        while (temp != null) {
            temp.parent = null;
            temp = temp.sibling;
        }

        if ((Nodes == null) && (fakeNode == null)) {
            size = 0;
        } else {
            if ((Nodes == null) && (fakeNode != null)) {
                Nodes = fakeNode.reverse(null);
                size = Nodes.getSize();
            } else {
                if ((Nodes != null) && (fakeNode == null)) {
                    size = Nodes.getSize();
                } else {
                    unionNodes(fakeNode.reverse(null));
                    size = Nodes.getSize();
                }
            }
        }

        return (K)minNode.key;
    }


    private void merge(Node binHeap) {
        Node temp1 = Nodes, temp2 = binHeap;

        while ((temp1 != null) && (temp2 != null)) {
            if (temp1.degree == temp2.degree) {
                Node tmp = temp2;
                temp2 = temp2.sibling;
                tmp.sibling = temp1.sibling;
                temp1.sibling = tmp;
                temp1 = tmp.sibling;
            } else {
                if (temp1.degree < temp2.degree) {
                    if ((temp1.sibling == null) || (temp1.sibling.degree > temp2.degree)) {
                        Node tmp = temp2;
                        temp2 = temp2.sibling;
                        tmp.sibling = temp1.sibling;
                        temp1.sibling = tmp;
                        temp1 = tmp.sibling;
                    } else {
                        temp1 = temp1.sibling;
                    }
                } else {
                    Node tmp = temp1;
                    temp1 = temp2;
                    temp2 = temp2.sibling;
                    temp1.sibling = tmp;
                    if (tmp == Nodes) {
                        Nodes = temp1;
                    } else {

                    }
                }
            }
        }
        if (temp1 == null) {
            temp1 = Nodes;
            while (temp1.sibling != null) {
                temp1 = temp1.sibling;
            }
            temp1.sibling = temp2;
        } else {

        }
    }


    private void unionNodes(Node binHeap) {
        merge(binHeap);

        Node prevTemp = null, temp = Nodes, nextTemp = Nodes.sibling;

        while (nextTemp != null) {
            if ((temp.degree != nextTemp.degree)
                    || ((nextTemp.sibling != null) && (nextTemp.sibling.degree == temp.degree))) {
                prevTemp = temp;
                temp = nextTemp;
            } else {
                if (nextTemp.key .compareTo(temp.key)>=0 ) {
                    temp.sibling = nextTemp.sibling;
                    nextTemp.parent = temp;
                    nextTemp.sibling = temp.child;
                    temp.child = nextTemp;
                    temp.degree++;
                } else {
                    if (prevTemp == null) {
                        Nodes = nextTemp;
                    } else {
                        prevTemp.sibling = nextTemp;
                    }
                    temp.parent = nextTemp;
                    temp.sibling = nextTemp.child;
                    nextTemp.child = temp;
                    nextTemp.degree++;
                    temp = nextTemp;
                }
            }
            nextTemp = temp.sibling;
        }
    }

    static class Node<K extends Comparable> {
        K key;
        int degree;
        Node parent, child, sibling;

        @Override
        public String toString() {
            return "data->"+key+",degree->"+degree;
        }

        public Node(K key) {
            this.key = key;
        }

        public Node reverse(Node sibl) {
            Node ret;
            if (sibling != null)
                ret = sibling.reverse(this);
            else
                ret = this;
            sibling = sibl;
            return ret;
        }

        public Node findMinNode() {
            Node x = this, y = this;
            Comparable min = x.key;

            while (x != null) {
                if (min.compareTo(x.key) > 0) {
                    y = x;
                    min = x.key;
                }
                x = x.sibling;
            }

            return y;
        }

        public Node findANodeWithKey(K value) {
            Node temp = this, node = null;

            while (temp != null) {
                if (temp.key == value) {
                    node = temp;
                    break;
                }
                if (temp.child == null)
                    temp = temp.sibling;
                else {
                    node = temp.child.findANodeWithKey(value);
                    if (node == null)
                        temp = temp.sibling;
                    else
                        break;
                }
            }

            return node;
        }

        public int getSize() {
            return (1 + ((child == null) ? 0 : child.getSize()) + ((sibling == null) ? 0 : sibling.getSize()));
        }
    }


    public static void main(String[] args) {
        BinomialHeap<Integer> heap=new BinomialHeap<>();
        heap.insert(10);heap.insert(20); heap.insert(5);heap.insert(3);
    }

}
