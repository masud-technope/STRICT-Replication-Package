public final void FormalComment() throws ParseException {
    /*@bgen(jjtree) #FormalComment( retainComments) */
    BSHFormalComment jjtn000 = new BSHFormalComment(JJTFORMALCOMMENT);
    boolean jjtc000 = true;
    jjtree.openNodeScope(jjtn000);
    jjtreeOpenNodeScope(jjtn000);
    Token t;
    try {
        t = jj_consume_token(FORMAL_COMMENT);
        jjtree.closeNodeScope(jjtn000, retainComments);
        jjtc000 = false;
        jjtreeCloseNodeScope(jjtn000);
        jjtn000.text = t.image;
    } finally {
        if (jjtc000) {
            jjtree.closeNodeScope(jjtn000, retainComments);
            jjtreeCloseNodeScope(jjtn000);
        }
    }
}