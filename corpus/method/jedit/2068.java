private final boolean jj_3R_218() {
    if (jj_3R_33())
        return true;
    Token xsp;
    xsp = jj_scanpos;
    if (jj_scan_token(100)) {
        jj_scanpos = xsp;
        if (jj_scan_token(101))
            return true;
    }
    return false;
}