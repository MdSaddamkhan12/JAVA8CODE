package JavaPractice.src.com.safatech.linkedlist.singly;

class Node{

    int data;
    Node next;

    public Node(int data) {
        this.data = data;
    }
}

public class MasterLinkedList {

    Node head;
    public void insertAtEnd(int data){

        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
            return;
        }
        Node current = head; // take a current node to move, head will still point to start so that we will not lose the start node
        while (current.next != null){

            current = current.next; // reference of the next node, Move the pointer
        }
        current.next = newNode; // link the current node -> new node, Change the connection

    }
    public void insertAtBeginning(int data){

        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;

    }
    public void insertAtIndex(int data, int index){

        Node newNode = new Node(data);

        if(index < 0 || index > length()){

            IO.println("Wrong index position");
            return;
        }

        // if insert at the index 0, beginning
        if(index == 0){
            newNode.next = head;
            head = newNode;
            return;
        }

        // start from the head
        Node current = head;

        // move to the node just before the required index
        for(int i = 0; i < index - 1; i++){

           current = current.next;
       }
        // connect new node to the next node
        newNode.next = current.next;
        // connect current node to new node
        current.next = newNode;
    }

    public void traverse(){

        Node current = head;
        while (current != null){

            IO.print(current.data + "->");
            current = current.next;
        }
        IO.println("null");

    }
    public int length( ){

        Node current = head;
        int count = 0;
        while (current != null){
            count++;
            current = current.next;
        }
        return count;
    }
    public boolean search(int target){

        Node current = head;
        while (current != null){

            if(current.data == target){
                return true;
            }
            current = current.next;
        }
        return false;
    }
    public void deleteFromStart(){

        if(head == null){
            return;
        }
        head = head.next;
    }

    public void deleteLast(){

        // empty list
        if(head == null){
            return;
        }
        // single node
        if(head.next == null){
            head = null;
            return;
        }
        Node current = head;
        // stop at second-last node
        while (current.next.next != null){

            current = current.next;
        }
        // remove the last node
        current.next = null;
    }

    public void deleteAtIndex(int index){

        if(index < 0 || index > length()){

            IO.println("Wrong index");
            return;
        }
        // empty list
        if(head == null){
            return;
        }
        // only head/single node
        if(index == 0){

            head = null;
        }

        Node current = head;
        for(int i = 0; i < index - 1; i++){
            current = current.next;
        }

        current.next = current.next.next;
    }

    public int getElement(int index){

        if(index < 0 || index > length()){
            IO.println("Wrong index");
            return -1;
        }
        Node current = head;
        for(int i = 0; i < index - 1; i++){
            current = current.next;
        }
        return current.data;
    }
    static void main() {


        MasterLinkedList list = new MasterLinkedList();

        // insert at the beginning
        list.insertAtBeginning(50);
        list.insertAtBeginning(40);
        list.insertAtBeginning(30);
        list.insertAtBeginning(20);
        list.insertAtBeginning(80);

        // insert at 3 index
        list.insertAtIndex(90,8);
        // insert at the end
//        list.insertAtEnd(10);
//        list.insertAtEnd(20);
//        list.insertAtEnd(30);
//        list.insertAtEnd(40);
//        list.insertAtEnd(50);

        // Display the node
        list.traverse();

        IO.println(list.length());
        IO.println(list.search(80));
//        list.deleteFromStart();
//        list.traverse();
//        IO.println(list.length());
//        list.deleteLast();
//        list.traverse();
//        IO.println(list.length());

        // delete at index
//        list.deleteAtIndex(2);
//        list.traverse();
//        IO.println(list.length());

        IO.println(list.getElement(3));
    }
}
