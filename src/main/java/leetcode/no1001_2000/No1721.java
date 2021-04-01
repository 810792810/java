package leetcode.no1001_2000;

/**
 * 中等 - 交换链表中的节点
 * 给你链表的头节点 head 和一个整数 k 。
 *
 * 交换 链表正数第 k 个节点和倒数第 k 个节点的值后，返回链表的头节点（链表 从 1 开始索引）。
 *
 *输入：head = [1,2,3,4,5], k = 2
 * 输出：[1,4,3,2,5]
 *
 * 思路: 快慢指针
 */
public class No1721 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1,
                new ListNode(2,
                        new ListNode(3,
                                new ListNode(4,
                                        new ListNode(5)))));
        swapNodes(head,2);
//        swapNodes2(head,2);
        head.print();
    }

    public static ListNode swapNodes(ListNode head, int k) {
        ListNode node = head;
        ListNode first  = head;
        ListNode last = head;
        int len = 1;
        while (node.next != null) {
            if (len < k) {
                first = first.next;
            } else {
                last = last.next;
            }
            len++;
            node = node.next;
        }

        int temp = first.val;
        first.val = last.val;
        last.val = temp;
        return head;
    }

    /**
     * 官方 快慢指针
     */
    public static ListNode swapNodes2(ListNode head, int k) {
        //在头节点前添加哑节点避免越界且允许了头节点的交换
        ListNode yummy = new ListNode(0, head);
        //初始化pre和快慢指针都指向哑节点处
        ListNode pre = yummy, slow = yummy, fast = yummy;
        //pre和快指针走k步，找到正数第k个节点
        for(int i = 0; i < k; i++){
            pre = pre.next;
            fast = fast.next;
        }
        //快慢指针再一起走。快指针到链表末尾时慢指针指向倒数第k个节点
        while(fast != null){
            fast = fast.next;
            slow = slow.next;
        }
        //交换两个节点的值
        int temp = pre.val;
        pre.val = slow.val;
        slow.val = temp;
        //返回链表头
        return head;
    }


        static public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      void print(){
          ListNode node = this;
          while(node != null){
              System.out.print(node.val +", ");
              node = node.next;
          }
      }
    }
}
