private final boolean jj_3R_122() {
    if (jj_scan_token(SYNCHRONIZED))
        return true;
    if (jj_scan_token(LPAREN))
        return true;
    if (jj_3R_39())
        return true;
    if (jj_scan_token(RPAREN))
        return true;
    if (jj_3R_38())
        return true;
    return false;
}