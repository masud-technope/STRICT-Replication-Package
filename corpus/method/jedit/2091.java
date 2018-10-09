private final boolean jj_3R_137() {
    if (jj_scan_token(FOR))
        return true;
    if (jj_scan_token(LPAREN))
        return true;
    if (jj_3R_32())
        return true;
    if (jj_scan_token(IDENTIFIER))
        return true;
    if (jj_scan_token(COLON))
        return true;
    if (jj_3R_39())
        return true;
    if (jj_scan_token(RPAREN))
        return true;
    if (jj_3R_45())
        return true;
    return false;
}