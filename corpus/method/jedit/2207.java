private final void jjCheckNAddStates(int start, int end) {
    do {
        jjCheckNAdd(jjnextStates[start]);
    } while (start++ != end);
}