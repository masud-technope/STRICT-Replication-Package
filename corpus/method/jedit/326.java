private int readInt() {
    int u = 0;
    u = (u << 8) | bsR(8);
    u = (u << 8) | bsR(8);
    u = (u << 8) | bsR(8);
    u = (u << 8) | bsR(8);
    return u;
}