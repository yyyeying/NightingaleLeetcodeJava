package datastructure;

public class List {
    public ListNode head;

    public List(int[] list){
        ListNode lastNode = null;
        for(int x: list){
            // System.out.println(x);
            ListNode newNode = new ListNode(x);
            if(head == null){
                head = newNode;
            }
            if(lastNode != null){
                lastNode.next = newNode;
            }
            lastNode = newNode;
        }
    }

    public List(ListNode head){
        this.head = head;
    }

    public void print(){
        if (head == null){
            return;
        }
        ListNode node = head;
        while (node != null){
            System.out.print(node.val + ", ");
            node = node.next;
        }
        System.out.print("\n");
    }
}
