public class TreeHeight {
    public static int getTreeHeight(Tree t) {
        if (t == null) {
            return -1;
        }

        // int h = 0;
        // h = Math.max(h, getTreeHeight(t.l) + 1);
        // h = Math.max(h, getTreeHeight(t.r) + 1);

        // return h;

        if (t.l == null && t.r == null) {
            return 0;
        }
        if (t.l == null) {
            return getTreeHeight(t.r) + 1;
        }
        if (t.r == null) {
            return getTreeHeight(t.l) + 1;
        }

        return Math.max(getTreeHeight(t.l), getTreeHeight(t.r)) + 1;
    }

    public static void main(String[] args) {
        Tree tree1 = new Tree(1);
        System.out.printf("The height of tree %s is %s\n", tree1, getTreeHeight(tree1));

        Tree tree2 = new Tree();
        tree2.x = 50;
        tree2.l = new Tree(20, new Tree(10), new Tree(30));
        tree2.r = new Tree(80, new Tree(70), new Tree(90));
        System.out.printf("The height of tree %s is %s\n", tree2, getTreeHeight(tree2));

        Tree tree3 = new Tree(100);
        tree3.l = new Tree(20);
        tree3.r = new Tree(80, new Tree(70), new Tree(90));
        System.out.printf("The height of tree %s is %s\n", tree3, getTreeHeight(tree3));

        Tree tree4 = new Tree(100);
        tree4.l = new Tree(20);
        tree4.r = new Tree(80, new Tree(70, new Tree(65), new Tree(75)), new Tree(90));
        System.out.printf("The height of tree %s is %s\n", tree4, getTreeHeight(tree4));
    }
}

class Tree {
    public int x;
    public Tree l;
    public Tree r;

    public Tree() {
        this.x = 0;
        this.l = null;
        this.r = null;
    }

    public Tree(int x) {
        this.x = x;
        this.l = null;
        this.r = null;
    }

    public Tree(int x, Tree l) {
        this.x = x;
        this.l = l;
        this.r = null;
    }

    public Tree(int x, Tree l, Tree r) {
        this.x = x;
        this.l = l;
        this.r = r;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public Tree getL() {
        return l;
    }

    public void setL(Tree l) {
        this.l = l;
    }

    public Tree getR() {
        return r;
    }

    public void setR(Tree r) {
        this.r = r;
    }
}
