private final boolean jj_3R_128() {
    if (jj_scan_token(IMPORT))
        return true;
    if (jj_scan_token(STAR))
        return true;
    if (jj_scan_token(SEMICOLON))
        return true;
    return false;
}