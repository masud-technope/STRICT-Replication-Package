public final void IfStatement() throws ParseException {
    /*@bgen(jjtree) IfStatement */
    BSHIfStatement jjtn000 = new BSHIfStatement(JJTIFSTATEMENT);
    boolean jjtc000 = true;
    jjtree.openNodeScope(jjtn000);
    jjtreeOpenNodeScope(jjtn000);
    try {
        jj_consume_token(IF);
        jj_consume_token(LPAREN);
        Expression();
        jj_consume_token(RPAREN);
        Statement();
        switch((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
            case ELSE:
                jj_consume_token(ELSE);
                Statement();
                break;
            default:
                ;
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