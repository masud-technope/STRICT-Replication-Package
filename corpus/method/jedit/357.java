private void vswap(int p1, int p2, int n) {
    int temp = 0;
    while (n > 0) {
        temp = m_zptr[p1];
        m_zptr[p1] = m_zptr[p2];
        m_zptr[p2] = temp;
        p1++;
        p2++;
        n--;
    }
}