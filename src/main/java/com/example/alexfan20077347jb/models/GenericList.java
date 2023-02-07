package com.example.alexfan20077347jb.models;


import java.io.Serializable;

public class GenericList <T> implements Serializable {
    public GenericNode<T> head=null;

    public void addElement(T e){ // ADDS AN ELEMENT TO THE HEAD OF THE LIST
        GenericNode<T> temp = new GenericNode<>();
        temp.setContents(e);
        temp.next = head;
        head=temp;
    }

    public int getListSize(){
        GenericNode<T> N = head;
        int size = 0;
        while(N!=null){
            N = N.next;
            size++;
        }
        return size;
    }

    public void clear(){ // EMPTY LIST
        head = null;
    } // empties the list

    public void delete(int i){
        GenericNode<T> temp = head;
        int j = 0;
        if(i==0){
            head=head.next;
        }
        while(j<i && temp!=null) {
            temp = temp.next;
            j++; // while j is less than i and temp doesn't equal to null, set temp to the next node
        }
        if (temp!=null && temp.next!=null){
            temp.next=temp.next.next; // if temp doesn't equal null or temp.next doesn't equal null, set second node to be the third node
        }
    }

    public GenericNode<T> get(int i) {
    GenericNode<T> temp = head;
    int j = 0;

    if(head==null){
        throw new IndexOutOfBoundsException("The list is empty");
        } // if head equals null return the list is empty

        while(j<i && temp!=null){
            temp = temp.next; // while j is less than i and temp doesn't equal null, set temp = the next node
            j++;
        }
        return temp;
    }

    // INNER CLASS FOR NODES
     public class GenericNode<N> implements Serializable{
        public GenericNode<N> next = null;
        private N contents;

        public N getContents(){
            return contents;
        }

        public void setContents(N c) {
            contents = c;
        }
    }

}
