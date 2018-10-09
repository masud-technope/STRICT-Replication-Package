private final void jjCheckNAdd(int state) {
    if (jjrounds[state] != jjround) {
        jjstateSet[jjnewStateCnt++] = state;
        jjrounds[state] = jjround;
    }
}