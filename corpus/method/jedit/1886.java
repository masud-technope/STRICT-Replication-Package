private final boolean jj_3R_119() {
    if (jj_scan_token(BREAK))
        return true;
    Token xsp;
    xsp = jj_scanpos;
    if (jj_scan_token(69))
        jj_scanpos = xsp;
    if (jj_scan_token(SEMICOLON))
        return true;
    return false;
}