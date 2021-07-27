package LinkedLIst;

public class Basics2 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    // Merge k sorted LinkedList

    ListNode mergeKSorted(ListNode[] arr) {

        if (arr.length == 0)
            return null;
        if (arr.length == 1)
            return arr[0];

        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        for (int i = 0; i < arr.length; i++) {
            ListNode crtTail = getTail(arr[0]);
            prev.next = arr[i];
            prev = crtTail;
        }
        ListNode head = dummy.next;
        return mergeSort(head);

    }

    ListNode getTail(ListNode head) {
        ListNode crt = head;
        while (crt.next != null) {
            crt = crt.next;
        }
        return crt;
    }

    ListNode mergeSort(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode mid = MidNode(head);
        ListNode nhead=mid.next;
        return mergeTwoLL(mergeSort(head), mergeSort(nhead));

    }   

}
