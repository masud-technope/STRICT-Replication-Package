public final void FormalParameter() throws ParseException {
    /*@bgen(jjtree) FormalParameter */
    BSHFormalParameter jjtn000 = new BSHFormalParameter(JJTFORMALPARAMETER);
    boolean jjtc000 = true;
    jjtree.openNodeScope(jjtn000);
    jjtreeOpenNodeScope(jjtn000);
    Token t;
    try {
        if (jj_2_5(2)) {
            Type();
            t = jj_consume_token(IDENTIFIER);
            jjtree.closeNodeScope(jjtn000, true);
            jjtc000 = false;
            jjtreeCloseNodeScope(jjtn000);
            jjtn000.name = t.image;
        } else {
            switch((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
                case IDENTIFIER:
                    t = jj_consume_token(IDENTIFIER);
                    jjtree.closeNodeScope(jjtn000, true);
                    jjtc000 = false;
                    jjtreeCloseNodeScope(jjtn000);
                    jjtn000.name = t.image;
                    break;
                default:
                    jj_consume_token(-1);
                    throw new ParseException();
            }
        }
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