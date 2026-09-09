class Solution {
    public long countCommas(long n) {
        long biggest = 999;

        long commaSum = 0;
        while (n > biggest) {
            commaSum += n - biggest;
            biggest = biggest * 1000 + 999;
        }

        return commaSum;
    }
}