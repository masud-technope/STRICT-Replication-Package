private final boolean jj_3R_115() {
    if (jj_scan_token(WHILE))
        return true;
    if (jj_scan_token(LPAREN))
        return true;
    if (jj_3R_39())
        return true;
    if (jj_scan_token(RPAREN))
        return true;
    if (jj_3R_45())
        return true;
    return false;
}