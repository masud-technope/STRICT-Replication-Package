public float nextTabStop(float x, int tabOffset) {
    int ntabs = (int) ((x + 1) / tabWidth);
    return (float) ((ntabs + 1) * tabWidth);
}