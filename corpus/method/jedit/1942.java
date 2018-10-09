private final boolean jj_3R_43() {
    if (jj_scan_token(LPAREN))
        return true;
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_75())
        jj_scanpos = xsp;
    if (jj_scan_token(RPAREN))
        return true;
    return false;
}