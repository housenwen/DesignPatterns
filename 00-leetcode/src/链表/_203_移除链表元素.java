package 链表;

/**
 * https://leetcode-cn.com/problems/remove-linked-list-elements/
 * 给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足
 * Node.val == val 的节点，并返回 新的头节点 。
 * 输入：head = [1,2,6,3,4,5,6], val = 6
 * 输出：[1,2,3,4,5]
 */
public class _203_移除链表元素 {
    //方法一删除头结点时另做考虑（由于头结点没有前一个结点）
    class Solution1 {
        public ListNode removeElements(ListNode head, int val) {
            //删除值相同的头结点后，可能新的头结点也值相等，用循环解决
            while (head != null && head.val == val) {
                head = head.next;
            }
            if (head == null)
                return head;
            ListNode prev = head;
            //确保当前结点后还有结点
            while (prev.next != null) {
                if (prev.next.val == val) {
                    prev.next = prev.next.next;
                } else {
                    prev = prev.next;
                }
            }
            return head;
        }
    }

    //方法二（添加一个虚拟头结点）
    class Solution2 {
        public ListNode removeElements(ListNode head, int val) {
            //创建一个虚拟头结点
            ListNode dummyNode = new ListNode(val - 1);
            dummyNode.next = head;
            ListNode prev = dummyNode;
            //确保当前结点后还有结点
            while (prev.next != null) {
                if (prev.next.val == val) {
                    prev.next = prev.next.next;
                } else {
                    prev = prev.next;
                }
            }
            return dummyNode.next;
        }
    }

    /**
     * 递归方法之前就是一个压栈的过程，递归方法之后就是一个弹栈的过程。通过不断地next，遍历O(N)到链表末尾；
     * 然后一个个弹栈寻找匹配值。注意本解中递归的返回值为head.next,即传入的下一结点；
     * 如果匹配就返回当前结点；不匹配，返回的head就是前一结点了。
     * 压栈时的head.next为后一个结点；弹栈时的head.next就位后前一个结点
     * <p>
     * （递归）遍历所有结点，所以时间复杂度是O(n)。递归的方法调用栈深度是n，所以空间复杂度O(n)。
     * 方法二和方法一没有太多区别，一般链表法都有虚拟头结点的技巧。遍历所有结点，
     * 所以时间复杂度是O(n)。空间复杂度O(1)。
     */

    //方法三（递归）
    class Solution3 {
        public ListNode removeElements(ListNode head, int val) {
            if (head == null)
                return null;
            head.next = removeElements(head.next, val);
            if (head.val == val) {
                return head.next;
            } else {
                return head;
            }
        }
    }
}
