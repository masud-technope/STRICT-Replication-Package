private final boolean jj_3R_113() {
    if (jj_scan_token(SWITCH))
        return true;
    if (jj_scan_token(LPAREN))
        return true;
    if (jj_3R_39())
        return true;
    if (jj_scan_token(RPAREN))
        return true;
    if (jj_scan_token(LBRACE))
        return true;
    Token xsp;
    while (true) {
        xsp = jj_scanpos;
        if (jj_3R_183()) {
            jj_scanpos = xsp;
            break;
        }
    }
    if (jj_scan_token(RBRACE))
        return true;
    return false;
}