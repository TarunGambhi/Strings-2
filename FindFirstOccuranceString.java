//Robert Karp Algo for strStr
//https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string
//TC: O(n)
//SC : O(1)
class Solution {
    public int strStr(String haystack, String needle) {
        long needleHash = 0;
        long stackHash = 0;
        long k = 26;
        int n = needle.length();
        int m = haystack.length();
        if(m<n) return -1;
        long kl = (long)Math.pow(k,n);
        for(int i=0; i<n; i++){
            char c = needle.charAt(i);
            needleHash = (needleHash * k) + (c-'a');
        }
        for(int i =0; i<n; i++){
            char c = haystack.charAt(i);
            stackHash = (stackHash * k) + (c-'a');
        }
        if(needleHash == stackHash) return 0;
        for(int i =1; i <= m-n; i++){
            //incoming element
            char in = haystack.charAt(n + i -1);
            stackHash = stackHash * k + (in-'a');
            //outgoing element
            char out = haystack.charAt(i-1);
            stackHash = stackHash -  ((out-'a') * kl);
            if(needleHash == stackHash) return i;
        }
        return -1;
    }
}
