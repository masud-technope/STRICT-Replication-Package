private final boolean jj_3_26() {
    if (jj_3R_41())
        return true;
    if (jj_scan_token(IDENTIFIER))
        return true;
    if (jj_3R_43())
        return true;
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_44())
        jj_scanpos = xsp;
    if (jj_scan_token(LBRACE))
        return true;
    return false;
}