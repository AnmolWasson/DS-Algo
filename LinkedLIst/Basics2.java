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
        ListNode nhead = mid.next;
        mid.next = null;
        return mergeTwoSortedLL(mergeSort(head), mergeSort(nhead));

    }

    ListNode mergeTwoSortedLL(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null)
            return l1 != null ? l1 : l2;

        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        ListNode c1 = l1, c2 = l2;
        while (c1 != null && c2 != null) {
            if (c1.val > c2.val) {
                prev.next = c2;
                prev = c2;
                c2 = c2.next;
            } else {
                prev.next = c1;
                prev = c1;
                c1 = c1.next;
            }
        }
        if (c1 != null) {
            prev.next = c1;
        } else {
            prev.next = c2;
        }
        return dummy.next;
    }

    ListNode MidNode(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode sl = head;
        ListNode ft = head;
        while (ft.next != null && ft.next.next != null) {
            ft = ft.next.next;
            sl = sl.next;

        }
        return sl;
    }
}
