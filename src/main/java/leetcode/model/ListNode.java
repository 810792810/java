package leetcode.model;

public class ListNode {
    public int val;
    public ListNode next;
    public ListNode() {}
    public ListNode(int val) { this.val = val; }
    public ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    public void print(){
        ListNode node = this;
        while(node != null){
            System.out.print(node.val +", ");
            node = node.next;
        }
    }
}
