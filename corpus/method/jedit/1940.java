private final boolean jj_3R_124() {
    if (jj_scan_token(TRY))
        return true;
    if (jj_3R_38())
        return true;
    Token xsp;
    while (true) {
        xsp = jj_scanpos;
        if (jj_3R_189()) {
            jj_scanpos = xsp;
            break;
        }
    }
    xsp = jj_scanpos;
    if (jj_3R_190())
        jj_scanpos = xsp;
    return false;
}