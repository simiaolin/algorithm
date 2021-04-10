package algoexpert.binarysearchtree;

import javafx.scene.chart.ValueAxis;

//不是严格意义上的bst
//left < root, but right  >= root
public class BST {
    public int value;
    public BST left;
    public BST right;

    public BST(int value) {
        this.value = value;
    }

    public BST(int value, BST left, BST right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public BST insert(int value) {
        if (value < this.value) {
            if (this.left == null) {
                this.left = new BST(value);
            } else {
                this.left.insert(value);
            }
        } else {
            if (this.right == null) {
                this.right = new BST(value);
            } else {
                this.right.insert(value);
            }
        }

        //todo why return this???
        return this;
    }

    public boolean contains(int value) {
        if (this == null) {
            return false;
        }
        if (this.value == value) {
            return true;
        } else if (value < this.value) {
            return (this.left == null) ? false : this.left.contains(value);
        } else {
            return (this.right == null) ? false : this.right.contains(value);
        }
    }

    public BST remove(int value) {
        this.remove(value, null);
        return this;
    }

    //only remove the first found.
    public void remove(int value, BST parent) {
        if (this.value == value) {
            if (left!= null && right != null) {
                int newVal = this.right.getMinRight();           //是this.right 而不是this
                this.value = newVal;
                this.right.remove(newVal, this);         //妙     this 一定要加上！！！
            } else if (parent == null) {                        //根结点
                if (left != null) {
                    this.value = left.value;
                    this.right = left.right;                     //注意先指左会直接丢失左的信息
                    this.left = left.left;
                } else  if (right != null) {
                    this.value = right.value;
                    this.left = right.left;
                    this.right = right.right;
                } else {
                    // do nothing
                }
            } else {                                           //普通节点
                if (parent.left == this) {
                    parent.left = (this.left == null) ? this.right : this.left;
                } else {
                    parent.right = (this.left == null) ? this.right : this.left;
                }
            }
        } else if (value < this.value && this.left != null) {
            this.left.remove(value, this);
        } else if (value > this.value && this.right != null) {
            this.right.remove(value, this);
        }
    }

    public int getMinRight() {
        if (left == null) {
            return this.value;
        } else {
            return left.getMinRight();
        }
    }

    public static void main(String[] args) {
        BST one = new BST(1);
        BST two = new BST(2, one,null);
        BST five_leaf = new BST(5);
        BST five = new BST(5, two, five_leaf);
        BST fourteen = new BST(14);
        BST thirteen = new BST(13, null, fourteen);
        BST twentytwo = new BST(22);
        BST fifteen = new BST(15, thirteen, twentytwo);
        BST ten = new BST(10, five, fifteen);
//        ten.remove(10);


        BST newTen = new BST(10);
        newTen.insert(5);
        newTen.remove(10);
        newTen.contains(15);
    }
}
