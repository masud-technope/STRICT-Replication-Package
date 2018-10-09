public final void AmbiguousName() throws ParseException {
    /*@bgen(jjtree) AmbiguousName */
    BSHAmbiguousName jjtn000 = new BSHAmbiguousName(JJTAMBIGUOUSNAME);
    boolean jjtc000 = true;
    jjtree.openNodeScope(jjtn000);
    jjtreeOpenNodeScope(jjtn000);
    Token t;
    StringBuilder s;
    try {
        t = jj_consume_token(IDENTIFIER);
        s = new StringBuilder(t.image);
        label_5: while (true) {
            if (jj_2_7(2)) {
                ;
            } else {
                break label_5;
            }
            jj_consume_token(DOT);
            t = jj_consume_token(IDENTIFIER);
            s.append("." + t.image);
        }
        jjtree.closeNodeScope(jjtn000, true);
        jjtc000 = false;
        jjtreeCloseNodeScope(jjtn000);
        jjtn000.text = s.toString();
    } finally {
        if (jjtc000) {
            jjtree.closeNodeScope(jjtn000, true);
            jjtreeCloseNodeScope(jjtn000);
        }
    }
}