private final boolean jj_3R_117() {
    if (jj_scan_token(FOR))
        return true;
    if (jj_scan_token(LPAREN))
        return true;
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_185())
        jj_scanpos = xsp;
    if (jj_scan_token(SEMICOLON))
        return true;
    xsp = jj_scanpos;
    if (jj_3R_186())
        jj_scanpos = xsp;
    if (jj_scan_token(SEMICOLON))
        return true;
    xsp = jj_scanpos;
    if (jj_3R_187())
        jj_scanpos = xsp;
    if (jj_scan_token(RPAREN))
        return true;
    if (jj_3R_45())
        return true;
    return false;
}