package leetcode.no1_100;

/**
 * @Author: xc
 * @Date: 2020/10/20
 * 2.两数相加
 *
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 * 思路,因为倒序,第一位是个位数,所以可以直接相加,遍历相加就行
 * 时间复杂度O(max(m,n))
 * 空间复杂度O(max(m,n))  可能+1,
 *
 */
public class No2 {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(9,new ListNode(9,new ListNode(9)));
        ListNode l2 = new ListNode(9,new ListNode(9));

        ListNode listNode = addTwoNumbers(l1, l2);
        while(listNode !=null){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }


    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode tail = null;
        int attach = 0;
        while (l1 != null || l2 != null){
            int sum =0;
            if (l1 != null){
                sum += l1.val;
                l1 = l1.next;
            }

            if (l2 != null){
                sum += l2.val;
                l2 = l2.next;
            }
            sum += attach;
            attach = sum/10;
            if (head == null){
                head = tail = new ListNode(sum%10);
            }else {
                tail.next = new ListNode(sum%10);
                tail = tail.next;
            }
        }
        if (attach>0){
            tail.next = new ListNode(attach);
        }
        return head;
    }


}
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) {
        this.val = val;
    }
    ListNode(int val, ListNode next) {
        this.val = val; this.next = next;
    }
}
