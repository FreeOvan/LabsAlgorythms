package LabFirst;
//
public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return head;
        }
        int length = 1;
        ListNode tail = head;
        ListNode temp = head;
        while (tail.next != null) {
            tail = tail.next;
            length++;
        }
        k %= length;
        if (k == 0){
            return head;
        }
        for(int i = 0; i < length - k - 1; i++){
            temp = temp.next;
        }
        ListNode newList = temp.next;
        temp.next = null;
        tail.next = head;
        return newList;
    }
}
