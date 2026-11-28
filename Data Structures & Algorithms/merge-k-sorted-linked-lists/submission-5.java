/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        // PriorityQueue<ListNode>pq = new PriorityQueue<>((a,b)->a.val-b.val);
        // for(ListNode node:lists){
        //     if(node!=null){
        //         pq.offer(node);
        //     }
        // }
        // ListNode dummy = new ListNode(0);
        // ListNode curr = dummy;
        // while(!pq.isEmpty()){
        //     ListNode small = pq.poll();
        //     curr.next = small;
        //     curr = curr.next;

        //     if(small.next!=null){
        //         pq.offer(small.next);
        //     }
        // }
        // return dummy.next;
        if(lists == null || lists.length == 0){
            return null;
        }
        int k = lists.length;
        for(int interval = 1;interval<k;interval*=2){
            for(int i = 0;i+interval<k;i+=interval*2){
                lists[i] = merge(lists[i],lists[i+interval]);
            }
        }
        return lists[0];
    } 
    private ListNode merge(ListNode l1,ListNode l2){
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        while( l1 != null &&  l2 !=null){
            if(l1.val<l2.val){
                curr.next = l1;
                l1 = l1.next;
            }else{
                curr.next = l2;
                l2 =l2.next;
            }
             curr = curr.next;
        }
            if(l1!=null){
                curr.next = l1;
            }else{
                curr.next = l2;
            }
        return dummy.next;
    }
}

