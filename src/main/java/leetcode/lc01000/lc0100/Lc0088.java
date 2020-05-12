package leetcode.lc01000.lc0100;

public class Lc0088 {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(n == 0){
            return;
        }
        int newArray[] = new int[m + n];
        int left = 0;
        int right = 0;
        int curent = 0;
        while ( left < m && right < n){
            if (nums1[left] <nums2[right]){
                newArray[curent++] = nums1[left ++];
            }else{
                newArray[curent++] = nums2[right ++];
            }
        }
        for (int i = left; i < m; i++) {
            newArray[curent++] = nums1[i];
        }
        for (int i = right; i < n; i++) {
            newArray[curent++] = nums2[i];
        }
        for (int i = 0; i < curent; i++) {
            nums1[i] = newArray[i];
        }
    }
}
