private void bsPutint(int u) throws IOException {
    bsW(8, (u >> 24) & 0xff);
    bsW(8, (u >> 16) & 0xff);
    bsW(8, (u >> 8) & 0xff);
    bsW(8, u & 0xff);
}