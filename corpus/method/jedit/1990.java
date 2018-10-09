public final void VariableDeclarator() throws ParseException {
    /*@bgen(jjtree) VariableDeclarator */
    BSHVariableDeclarator jjtn000 = new BSHVariableDeclarator(JJTVARIABLEDECLARATOR);
    boolean jjtc000 = true;
    jjtree.openNodeScope(jjtn000);
    jjtreeOpenNodeScope(jjtn000);
    Token t;
    try {
        t = jj_consume_token(IDENTIFIER);
        switch((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
            case ASSIGN:
                jj_consume_token(ASSIGN);
                VariableInitializer();
                break;
            default:
                ;
        }
        jjtree.closeNodeScope(jjtn000, true);
        jjtc000 = false;
        jjtreeCloseNodeScope(jjtn000);
        jjtn000.name = t.image;
    } catch (Throwable jjte000) {
        if (jjtc000) {
            jjtree.clearNodeScope(jjtn000);
            jjtc000 = false;
        } else {
            jjtree.popNode();
        }
        if (jjte000 instanceof RuntimeException) {
            {
                if (true)
                    throw (RuntimeException) jjte000;
            }
        }
        if (jjte000 instanceof ParseException) {
            {
                if (true)
                    throw (ParseException) jjte000;
            }
        }
        {
            if (true)
                throw (Error) jjte000;
        }
    } finally {
        if (jjtc000) {
            jjtree.closeNodeScope(jjtn000, true);
            jjtreeCloseNodeScope(jjtn000);
        }
    }
}