private final boolean jj_3R_38() {
    if (jj_scan_token(LBRACE))
        return true;
    Token xsp;
    while (true) {
        xsp = jj_scanpos;
        if (jj_3_23()) {
            jj_scanpos = xsp;
            break;
        }
    }
    if (jj_scan_token(RBRACE))
        return true;
    return false;
}