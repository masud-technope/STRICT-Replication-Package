private final boolean jj_3_3() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_scan_token(48))
        jj_scanpos = xsp;
    if (jj_scan_token(IMPORT))
        return true;
    if (jj_3R_29())
        return true;
    xsp = jj_scanpos;
    if (jj_3R_30())
        jj_scanpos = xsp;
    if (jj_scan_token(SEMICOLON))
        return true;
    return false;
}