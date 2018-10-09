private final void jjAddStates(int start, int end) {
    do {
        jjstateSet[jjnewStateCnt++] = jjnextStates[start];
    } while (start++ != end);
}