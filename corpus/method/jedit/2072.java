private final boolean jj_3R_60() {
    if (jj_scan_token(LPAREN))
        return true;
    if (jj_3R_29())
        return true;
    if (jj_scan_token(RPAREN))
        return true;
    Token xsp;
    xsp = jj_scanpos;
    if (jj_scan_token(87)) {
        jj_scanpos = xsp;
        if (jj_scan_token(86)) {
            jj_scanpos = xsp;
            if (jj_scan_token(72)) {
                jj_scanpos = xsp;
                if (jj_scan_token(69)) {
                    jj_scanpos = xsp;
                    if (jj_scan_token(40)) {
                        jj_scanpos = xsp;
                        if (jj_3R_105())
                            return true;
                    }
                }
            }
        }
    }
    return false;
}