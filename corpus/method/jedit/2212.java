private final void ReInitRounds() {
    int i;
    jjround = 0x80000001;
    for (i = 74; i-- > 0; ) jjrounds[i] = 0x80000000;
}