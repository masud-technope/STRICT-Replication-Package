private static void hbMakeCodeLengths(char[] len, int[] freq, int alphaSize, int maxLen) {
    /*
         * Nodes and heap entries run from 1.  Entry 0
         * for both the heap and nodes is a sentinel.
         */
    int nNodes;
    /*
         * Nodes and heap entries run from 1.  Entry 0
         * for both the heap and nodes is a sentinel.
         */
    int nHeap;
    /*
         * Nodes and heap entries run from 1.  Entry 0
         * for both the heap and nodes is a sentinel.
         */
    int n1;
    /*
         * Nodes and heap entries run from 1.  Entry 0
         * for both the heap and nodes is a sentinel.
         */
    int n2;
    /*
         * Nodes and heap entries run from 1.  Entry 0
         * for both the heap and nodes is a sentinel.
         */
    int i;
    /*
         * Nodes and heap entries run from 1.  Entry 0
         * for both the heap and nodes is a sentinel.
         */
    int j;
    /*
         * Nodes and heap entries run from 1.  Entry 0
         * for both the heap and nodes is a sentinel.
         */
    int k;
    boolean tooLong;
    int[] heap = new int[MAX_ALPHA_SIZE + 2];
    int[] weights = new int[MAX_ALPHA_SIZE * 2];
    int[] parent = new int[MAX_ALPHA_SIZE * 2];
    for (i = 0; i < alphaSize; i++) {
        weights[i + 1] = (freq[i] == 0 ? 1 : freq[i]) << 8;
    }
    while (true) {
        nNodes = alphaSize;
        nHeap = 0;
        heap[0] = 0;
        weights[0] = 0;
        parent[0] = -2;
        for (i = 1; i <= alphaSize; i++) {
            parent[i] = -1;
            nHeap++;
            heap[nHeap] = i;
            {
                int zz;
                int tmp;
                zz = nHeap;
                tmp = heap[zz];
                while (weights[tmp] < weights[heap[zz >> 1]]) {
                    heap[zz] = heap[zz >> 1];
                    zz >>= 1;
                }
                heap[zz] = tmp;
            }
        }
        if (!(nHeap < (MAX_ALPHA_SIZE + 2))) {
            panic();
        }
        while (nHeap > 1) {
            n1 = heap[1];
            heap[1] = heap[nHeap];
            nHeap--;
            {
                int zz = 0;
                int yy = 0;
                int tmp = 0;
                zz = 1;
                tmp = heap[zz];
                while (true) {
                    yy = zz << 1;
                    if (yy > nHeap) {
                        break;
                    }
                    if (yy < nHeap && weights[heap[yy + 1]] < weights[heap[yy]]) {
                        yy++;
                    }
                    if (weights[tmp] < weights[heap[yy]]) {
                        break;
                    }
                    heap[zz] = heap[yy];
                    zz = yy;
                }
                heap[zz] = tmp;
            }
            n2 = heap[1];
            heap[1] = heap[nHeap];
            nHeap--;
            {
                int zz = 0;
                int yy = 0;
                int tmp = 0;
                zz = 1;
                tmp = heap[zz];
                while (true) {
                    yy = zz << 1;
                    if (yy > nHeap) {
                        break;
                    }
                    if (yy < nHeap && weights[heap[yy + 1]] < weights[heap[yy]]) {
                        yy++;
                    }
                    if (weights[tmp] < weights[heap[yy]]) {
                        break;
                    }
                    heap[zz] = heap[yy];
                    zz = yy;
                }
                heap[zz] = tmp;
            }
            nNodes++;
            parent[n1] = nNodes;
            parent[n2] = nNodes;
            final int v1 = weights[n1];
            final int v2 = weights[n2];
            final int weight = calculateWeight(v1, v2);
            weights[nNodes] = weight;
            parent[nNodes] = -1;
            nHeap++;
            heap[nHeap] = nNodes;
            {
                int zz = 0;
                int tmp = 0;
                zz = nHeap;
                tmp = heap[zz];
                while (weights[tmp] < weights[heap[zz >> 1]]) {
                    heap[zz] = heap[zz >> 1];
                    zz >>= 1;
                }
                heap[zz] = tmp;
            }
        }
        if (!(nNodes < (MAX_ALPHA_SIZE * 2))) {
            panic();
        }
        tooLong = false;
        for (i = 1; i <= alphaSize; i++) {
            j = 0;
            k = i;
            while (parent[k] >= 0) {
                k = parent[k];
                j++;
            }
            len[i - 1] = (char) j;
            if (j > maxLen) {
                tooLong = true;
            }
        }
        if (!tooLong) {
            break;
        }
        for (i = 1; i < alphaSize; i++) {
            j = weights[i] >> 8;
            j = 1 + (j / 2);
            weights[i] = j << 8;
        }
    }
}