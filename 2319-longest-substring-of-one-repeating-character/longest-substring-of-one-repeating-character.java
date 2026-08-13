class Solution {

    // Information about one block
    static class Block {
        int start;
        int end;

        char first;
        char last;

        int prefix;
        int suffix;
        int best;
        int length;
    }

    char[] arr;
    Block[] blocks;

    int BLOCK_SIZE = 320;

    public int[] longestRepeating(
            String s,
            String queryCharacters,
            int[] queryIndices) {

        // Convert String into char array
        arr = s.toCharArray();

        int n = arr.length;

        // Number of blocks
        int numBlocks = (n + BLOCK_SIZE - 1) / BLOCK_SIZE;

        blocks = new Block[numBlocks];
        for (int i = 0; i < numBlocks; i++) {
            int start = i * BLOCK_SIZE;
            int end = Math.min(
                    n - 1,
                    start + BLOCK_SIZE - 1
            );
            blocks[i] = new Block();
            blocks[i].start = start;
            blocks[i].end = end;

            rebuild(i);
        }

        int[] ans = new int[queryIndices.length];
        for (int q = 0; q < queryIndices.length; q++) {
            int index = queryIndices[q];
            char ch = queryCharacters.charAt(q);
            arr[index] = ch;

            int blockIndex = index / BLOCK_SIZE;
            rebuild(blockIndex);

            // Get the longest repeating substring
            ans[q] = getAnswer();
        }

        return ans;
    }

    // Rebuild one block
    void rebuild(int blockIndex) {

        Block block = blocks[blockIndex];

        int start = block.start;
        int end = block.end;

        // Length of block
        block.length = end - start + 1;

        // First and last character
        block.first = arr[start];
        block.last = arr[end];

        // -------------------------
        // Calculate PREFIX
        // -------------------------

        int pref = 1;

        while (start + pref <= end &&
               arr[start + pref] == arr[start]) {

            pref++;
        }

        block.prefix = pref;

        

        int suff = 1;

        while (end - suff >= start &&
               arr[end - suff] == arr[end]) {

            suff++;
        }

        block.suffix = suff;

        // -------------------------
        // Calculate BEST
        // -------------------------

        int current = 1;
        int best = 1;

        for (int i = start + 1; i <= end; i++) {

            if (arr[i] == arr[i - 1]) {

                current++;

            } else {

                current = 1;
            }

            best = Math.max(best, current);
        }

        block.best = best;
    }

    // Merge two blocks
    Block merge(Block a, Block b) {

        Block c = new Block();

        // Total length
        c.length = a.length + b.length;

        // First and last characters
        c.first = a.first;
        c.last = b.last;

        // -------------------------
        // Calculate PREFIX
        // -------------------------

        c.prefix = a.prefix;

        /*
         If the entire first block has
         the same character and it matches
         the first character of block b,
         the prefix continues into b.
        */

        if (a.prefix == a.length &&
            a.last == b.first) {

            c.prefix = a.length + b.prefix;
        }

        // -------------------------
        // Calculate SUFFIX
        // -------------------------

        c.suffix = b.suffix;

        /*
         If the entire second block has
         the same character and it matches
         the last character of block a,
         the suffix continues into a.
        */

        if (b.suffix == b.length &&
            a.last == b.first) {

            c.suffix = b.length + a.suffix;
        }

        // -------------------------
        // Calculate BEST
        // -------------------------

        // Best completely inside a or b
        c.best = Math.max(a.best, b.best);

        /*
         A repeating substring may cross
         the boundary between a and b.
        */

        if (a.last == b.first) {

            int crossing = a.suffix + b.prefix;

            c.best = Math.max(c.best, crossing);
        }

        return c;
    }

    // Merge all blocks and get final answer
    int getAnswer() {

        Block current = null;

        for (Block block : blocks) {

            if (current == null) {
                current = block;

            } else {
                current = merge(current, block);
            }
        }
        return current.best;
    }
}