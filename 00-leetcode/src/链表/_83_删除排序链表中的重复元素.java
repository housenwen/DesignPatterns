package 链表;

/**
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/
 * 存在一个按升序排列的链表，给你这个链表的头节点 head ，
 * 请你删除所有重复的元素，使每个元素 只出现一次 。
 * 输入：head = [1,1,2]
 * 输出：[1,2]
 */
public class _83_删除排序链表中的重复元素 {
    class Solution {
        public ListNode deleteDuplicates(ListNode head) {
            ListNode cur = head;
            while (cur != null && cur.next != null) {
                if (cur.val == cur.next.val) {
                    cur.next = cur.next.next;
                } else {
                    cur = cur.next;
                }
            }
            return head;
        }
    }

    //递归
    class Solution2 {
        public ListNode deleteDuplicates(ListNode head) {
            //1：这种情况不可能有相同节点，直接返回
            if (head == null || head.next == null) {
                return head;
            }
            //2：当前节点与下个节点一样
            if (head.val == head.next.val) {
                //3：将当前节点的下个节点跳过，指向递下下个归后的结果
                head.next = deleteDuplicates(head.next.next);
                //4：为了防止删除了下个节点，与下下个节点还是一样，继续递归，如[1,1,1]这种情况，跳过了第二个节点，还剩下[1,1]
                return deleteDuplicates(head);
            }
            //5：当前节点与下个节点不一样，继续递归下个节点，递归函数继续判断是否与下下个节点一样(见2))
            deleteDuplicates(head.next);
            return head;
        }
    }

}
