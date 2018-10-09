private final boolean jj_3R_132() {
    if (jj_scan_token(DOT))
        return true;
    if (jj_scan_token(IDENTIFIER))
        return true;
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_146())
        jj_scanpos = xsp;
    return false;
}