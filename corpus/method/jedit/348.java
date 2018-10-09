private static int calculateWeight(final int v1, final int v2) {
    final int upper = (v1 & UPPER_BYTE_MASK) + (v2 & UPPER_BYTE_MASK);
    final int v1Lower = (v1 & LOWER_BYTE_MASK);
    final int v2Lower = (v2 & LOWER_BYTE_MASK);
    final int nnnn = (v1Lower > v2Lower) ? v1Lower : v2Lower;
    return upper | (1 + nnnn);
}