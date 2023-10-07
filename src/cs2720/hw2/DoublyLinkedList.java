package cs2720.hw2;

public class DoublyLinkedList<T extends Comparable<T>> {

    private NodeType<T> head;

    public DoublyLinkedList() {
        head = null;
    }

    public void insertItem(T item) {
        if(isEmpty()) { //inserting if empty
            NodeType<T> node = new NodeType<T>();
            node.info = item;
            head = node;
            head.next = null;
            head.back = null;
        }
        else { // inserting if populated
            if(searchItem(item) != 0) {
                System.out.println("no duplicates allowed");
            }
            else {
                NodeType<T> node = new NodeType<T>();
                node.info = item;
                NodeType<T> cpos = new NodeType<T>();
                NodeType<T> ppos = new NodeType<T>();
                cpos = head;
                ppos = null;
                cpos.back = ppos;
                while(cpos.next != null && node.info.compareTo(cpos.info) >= 1 ) {
                    ppos = cpos;
                    cpos = cpos.next;
                }
                if(ppos == null) { //inserting at beginning
                    if(item.compareTo(cpos.info) >=1) {//inserting with only one item in list
                        node.back = cpos;
                        cpos.next = node;
                    }
                    else {
                        node.next = head;
                        head.back = node;
                        head = node;
                    }
                }
                else {
                    if(item.compareTo(cpos.info) >= 1) {
                        node.back = cpos;
                        cpos.next = node;
                    }
                    else {
                        ppos.next = node;
                        node.back = ppos;
                        node.next = cpos;
                        cpos.back = node;
                    }
                }
            }
        }
    }
    public void deleteItem(T item) {
        if(isEmpty()) {
            System.out.print("you cant delete from an empty list");
        }
        else if(length() == 1) {
            head = null;
        }
        else if(searchItem(item) == 0) {
            System.out.print("the item is not in this list");
        }
        else {
            NodeType<T> cpos = head;
            while(cpos.next != null) {
                if(item.compareTo(cpos.info) == 0) {
                    break;
                }
                else {
                    cpos = cpos.next;
                }
            }
            if(cpos.next == null) {
                cpos.back.next = null;
            }
            else if(cpos.back == null) {
                cpos.next.back = null;
                head = cpos.next;
            }
            else {
                cpos.next.back = cpos.back;
                cpos.back.next = cpos.next;
            }
        }
    }
    public int length() {
        NodeType<T> temp = new NodeType<T>();
        temp = head;
        int length = 0;
        while(temp != null) {
            length++;
            temp = temp.next;
        }
        return length;
    }

    public void print() {
        if(isEmpty()) {
            System.out.print("the list is empty");
        }
        else {
           NodeType<T> temp = new NodeType<T>();
           temp = head;
           while(temp != null) {
               System.out.print(temp.info + " ");
               temp = temp.next;
           }
        }
    }
    public void printReverse() {
        NodeType<T> temp = new NodeType<T>();
        temp = head;
        if(isEmpty()) {
            System.out.print("the list is empty");
        }
        else {
            while(temp.next != null) {
                temp = temp.next;
            }
            while(temp != null) {
                System.out.print(temp.info + " ");
                temp = temp.back;
            }
        }
    }
    public boolean isEmpty() {
        if( head == null) {
            return true;
        }
        else {
            return false;
        }
    }
    public void deleteSubsection(T lb, T ub) {
        NodeType<T> cpos = new NodeType<T>();
        cpos = head;
        //potential if condition?
        if(isEmpty()) { // if empty do nothing
            print();
        }
        while(cpos.next != null) {
            if(cpos.info.compareTo(lb) != -1 && cpos.info.compareTo(ub) != 1) {
                cpos = cpos.next;
                deleteItem(cpos.back.info);
                if(cpos.next == null) {
                    deleteItem(cpos.info);
                }
            }
            else {
                cpos = cpos.next;
            }
        }

    }
    public void reverseList() {
        NodeType<T> cpos = new NodeType<T>();
        NodeType<T> ppos = new NodeType<T>();
        if(!isEmpty() ) {
            ppos = head;
            cpos = ppos.next;
            //update the first node
            ppos.next = null;
            ppos.back = cpos;

            while(cpos != null) {
                if(cpos.next == null) {
                    cpos.back = null;
                    cpos.next = ppos;
                }
                else
                cpos.back = cpos.next;
                cpos.next = ppos;
                ppos = cpos;
                cpos = cpos.back;
            }
            head = ppos;
        }
    }
    public void swapAlternate() {
        NodeType<T> cpos = new NodeType<T>();
        NodeType<T> ppos = new NodeType<T>();
        //set position of temp nodes
        if( length() == 1 || isEmpty()) {
            return;
        }
        else {
            ppos = head;
            cpos = ppos.next;
            if (length() == 2) {
                ppos.next = null;
                cpos.next = ppos;
                ppos.back = cpos;
                cpos.back = null;
                head = cpos;
            }
            else {
                //swap first nodes
                ppos.next = cpos.next;
                ppos.back = cpos;
                cpos.next = ppos;
                ppos.next.back = ppos;
                cpos.back = null;
                head = cpos;

                //set up ppos and cpos for the loop
                cpos = ppos.next.next;
                ppos = ppos.next;
                while(cpos != null && ppos != null) {
                    if(cpos.next == null) {
                        ppos.next = null;
                        ppos.back.next = cpos;
                        cpos.back = ppos.back;
                        ppos.back = cpos;
                        cpos.next = ppos;
                        return;
                    }
                    else if (cpos == null) {
                        return;
                    }
                    else {
                        ppos.next = cpos.next;
                        ppos.back.next = cpos;
                        cpos.next = ppos;

                        cpos.back = ppos.back;
                        ppos.next.back = ppos;
                        ppos.back = cpos.next;

                        //update ppos and cpos position
                        cpos = ppos.next.next;
                        ppos = ppos.next;
                    }
                }
            }
        }
    }

    //helpers
    public int searchItem(T item) {
        NodeType<T> temp = head;
        int index = 1;
        while( temp != null) {
            if(item.compareTo(temp.info) == 0) {
                return index;
            }
            else {
                temp = temp.next;
                index++;
            }
        }
        index = 0;//means the item is not in the list
        return index;
    }
}
