public final void SwitchStatement() throws ParseException {
    /*@bgen(jjtree) SwitchStatement */
    BSHSwitchStatement jjtn000 = new BSHSwitchStatement(JJTSWITCHSTATEMENT);
    boolean jjtc000 = true;
    jjtree.openNodeScope(jjtn000);
    jjtreeOpenNodeScope(jjtn000);
    try {
        jj_consume_token(SWITCH);
        jj_consume_token(LPAREN);
        Expression();
        jj_consume_token(RPAREN);
        jj_consume_token(LBRACE);
        label_23: while (true) {
            switch((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
                case CASE:
                case _DEFAULT:
                    ;
                    break;
                default:
                    break label_23;
            }
            SwitchLabel();
            label_24: while (true) {
                if (jj_2_29(1)) {
                    ;
                } else {
                    break label_24;
                }
                BlockStatement();
            }
        }
        jj_consume_token(RBRACE);
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