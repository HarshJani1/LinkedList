public class Polynomial {
    public Node head = null;
    Node tail = null;
    public void insert(int coefficient, char variable, int exponent){

        Node node = new Node(coefficient, variable, exponent);
        if(tail == null && head == null){
            head = node;
            tail = node;
            return;
        }
        tail.next = node;
        tail = node;

    }

    public void add(Node head1,Node head2){
        Node dummyHead = new Node();
        Node dummyTail = new Node();
        Node curr1 = head1;
        Node curr2 = head2;
        while(curr1 != null && curr2 != null){
            if((curr1.exponent == curr2.exponent && curr1.variable == curr2.variable)|| (curr1.exponent == 0 && curr2.exponent == 0)){
                insert(curr1.coefficient+ curr2.coefficient, curr1.variable, curr1.exponent);
                curr1 = curr1.next;
                curr2 = curr2.next;
            }else if(curr1.exponent > curr2.exponent && curr1.variable == curr2.variable){
                insert(curr1.coefficient, curr1.variable, curr1.exponent);
                curr1 = curr1.next;

            }else if(curr1.exponent < curr2.exponent && curr2.variable == curr1.variable){
                insert(curr2.coefficient, curr1.variable, curr2.exponent);

                curr2 = curr2.next;
            }else{
                insert(curr1.coefficient, curr1.variable, curr1.exponent);
                curr1 = curr1.next;
                insert(curr2.coefficient, curr2.variable, curr2.exponent);
                curr2 = curr2.next;

            }
        }

        if(curr1 != null){
            tail.next = curr1;

        }
        if(curr2 != null){
            tail = curr2;
        }

        while(tail.next != null){
            tail = tail.next;
        }

        printPolynomial();
    }

    public void printPolynomial() {
        Node curr = this.head;
        while (curr != null) {
            System.out.print(curr.coefficient + ""+curr.variable+"^"+ curr.exponent+" + ");
            curr = curr.next;
        }
    }

    private class Node{
        int coefficient;
        char variable;
        int exponent;
        Node next;

        public Node(int coefficient, char variable, int exponent) {
            this.coefficient = coefficient;
            this.variable = variable;
            this.exponent = exponent;
            this.next = null;
        }

        public Node(){

        }
    }
}
