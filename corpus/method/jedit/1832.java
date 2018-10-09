private final boolean jj_3R_121() {
    if (jj_scan_token(RETURN))
        return true;
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_188())
        jj_scanpos = xsp;
    if (jj_scan_token(SEMICOLON))
        return true;
    return false;
}