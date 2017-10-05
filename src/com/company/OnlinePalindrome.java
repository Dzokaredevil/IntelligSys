package com.company;

/**
 * Created by dimav on 05.10.2017.
 * Don't copy my code. The truth must be taken.
 */
class OnlinePalindrome {
    protected static boolean isPalindrome(char[] letters, int endIdx){
        int left = 0, right = endIdx;
        while(left < right){
            if(letters[left] != letters[right])
                return false;
            left++;
            right--;
        }
        return true;
    }

    static String checkPalindrome(String inStr, int base, int quotient){
        StringBuilder builder = new StringBuilder();
        char[] letters = inStr.toCharArray();
        int leftHash   = letters[0] % quotient;
        int rightHash  = letters[1] % quotient;
        int strLen     = inStr.length();
        builder.append("Y");
        for(int i = 1, h = 1; i < strLen; i++){
            System.out.print("i = " + i + " LeftHash = " + leftHash + " RightHash = " + rightHash + "\n");
            if(leftHash != rightHash) {
                builder.append("N");
            } else {
                if(isPalindrome(letters, i))
                    builder.append("Y");
                else
                    builder.append("N");
            }
            if(i == strLen-1)
                break ;
            if(i % 2 == 1){
                rightHash = (rightHash + quotient - letters[(i+1)/2]*h);
                rightHash = ((rightHash * base) % quotient + letters[i+1]) % quotient;
            } else {
                h = (h*base) % quotient;
                leftHash  = (letters[i/2] * h + leftHash) % quotient;
                rightHash = ((rightHash * base) % quotient + letters[i+1]) % quotient;
            }
        }
        return builder.toString();
    }
}
