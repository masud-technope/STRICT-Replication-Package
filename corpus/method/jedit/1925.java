private final boolean jj_3R_97() {
    if (jj_scan_token(LBRACE))
        return true;
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_163())
        jj_scanpos = xsp;
    xsp = jj_scanpos;
    if (jj_scan_token(79))
        jj_scanpos = xsp;
    if (jj_scan_token(RBRACE))
        return true;
    return false;
}