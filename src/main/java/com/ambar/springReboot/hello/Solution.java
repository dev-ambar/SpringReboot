package com.ambar.springReboot.hello;

public class Solution {
    public String solution(int N) {
        StringBuilder result = new StringBuilder(N);
        String alphabet = "abcdefghijklmnopqrstuvwxyz";  // 26 letters

        // Determine the maximum number of unique letters we can use
        int maxUniqueLetters = Math.min(N, 26); // Use up to 26 letters or less if N < 26
        while (N % maxUniqueLetters != 0) {
            maxUniqueLetters--; // Adjust until we find a divisor of N
        }

        int repeatCount = N / maxUniqueLetters; // Number of times each letter should repeat

        // Construct the result by repeating the required letters
        for (int i = 0; i < maxUniqueLetters; i++) {
            char letter = alphabet.charAt(i);
            for (int j = 0; j < repeatCount; j++) {
                result.append(letter);
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test cases
/*        System.out.println(solution.solution(3));     // Expected: any combination of 3 letters, each appearing once, e.g., "abc"
        System.out.println(solution.solution(5));     // Expected: any combination of 5 letters, each appearing once, e.g., "abcde"
        System.out.println(solution.solution(30));*/    // Expected: 15 letters "a" to "o", each appearing twice, e.g., "aabbcc...oo"
        System.out.println(solution.solution(26));    // Expected: 26 letters "a" to "z" repeated twice
    }
}
