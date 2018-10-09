private final boolean jj_3R_189() {
    if (jj_scan_token(CATCH))
        return true;
    if (jj_scan_token(LPAREN))
        return true;
    if (jj_3R_109())
        return true;
    if (jj_scan_token(RPAREN))
        return true;
    if (jj_3R_38())
        return true;
    return false;
}