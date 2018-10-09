private final boolean jj_3R_114() {
    if (jj_scan_token(IF))
        return true;
    if (jj_scan_token(LPAREN))
        return true;
    if (jj_3R_39())
        return true;
    if (jj_scan_token(RPAREN))
        return true;
    if (jj_3R_45())
        return true;
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_184())
        jj_scanpos = xsp;
    return false;
}