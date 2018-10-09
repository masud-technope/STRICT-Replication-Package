private final boolean jj_3R_29() {
    if (jj_scan_token(IDENTIFIER))
        return true;
    Token xsp;
    while (true) {
        xsp = jj_scanpos;
        if (jj_3_7()) {
            jj_scanpos = xsp;
            break;
        }
    }
    return false;
}