private final boolean jj_3_21() {
    Token xsp;
    if (jj_3_19())
        return true;
    while (true) {
        xsp = jj_scanpos;
        if (jj_3_19()) {
            jj_scanpos = xsp;
            break;
        }
    }
    while (true) {
        xsp = jj_scanpos;
        if (jj_3_20()) {
            jj_scanpos = xsp;
            break;
        }
    }
    return false;
}