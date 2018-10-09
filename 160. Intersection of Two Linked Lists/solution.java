/* Approach 3: Two Pointers

    Maintain two pointers pApApA and pBpBpB initialized at the head of A and B, respectively. 
    Then let them both traverse through the lists, one node at a time.
    When pApApA reaches the end of a list, then redirect it to the head of B (yes, B, that's right.); 
    similarly when pBpBpB reaches the end of a list, redirect it the head of A.
    If at any point pApApA meets pBpBpB, then pApApA/pBpBpB is the intersection node.
    To see why the above trick would work, consider the following two lists: A = {1,3,5,7,9,11} 
    and B = {2,4,9,11}, which are intersected at node '9'. Since B.length (=4) < A.length (=6), 
    pBpBpB would reach the end of the merged list first, because pBpBpB traverses exactly 2 nodes less than 
    pApApA does. By redirecting pBpBpB to head A, and pApApA to head B, we now ask pBpBpB to travel exactly 2 
    more nodes than pApApA would. So in the second iteration, they are guaranteed to reach the intersection node at 
    the same time.
    If two lists have intersection, then their last nodes must be the same one. So when pApApA/pBpBpB reaches the end of a list, 
    record the last element of A/B respectively. If the two last elements are not the same one, then the two lists have no 
    intersections.

Complexity Analysis

    Time complexity : O(m+n).

    Space complexity : O(1).

*/
// dont have to worry the loop may never end if their is no intersection. when there is no intersection, prtA == prtB == null
// at the first full iteration.
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null){
            return null;
        }
        
        ListNode ptrA = headA;
        ListNode ptrB = headB;
        while(ptrA != ptrB){
            ptrA = (ptrA == null) ? headB : ptrA.next;
            ptrB = (ptrB == null) ? headA : ptrB.next;
        }
        
        return ptrA; 
    }
}
