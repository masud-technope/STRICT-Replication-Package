public final void StatementExpressionList() throws ParseException {
    /*@bgen(jjtree) StatementExpressionList */
    BSHStatementExpressionList jjtn000 = new BSHStatementExpressionList(JJTSTATEMENTEXPRESSIONLIST);
    boolean jjtc000 = true;
    jjtree.openNodeScope(jjtn000);
    jjtreeOpenNodeScope(jjtn000);
    try {
        StatementExpression();
        label_26: while (true) {
            switch((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
                case COMMA:
                    ;
                    break;
                default:
                    break label_26;
            }
            jj_consume_token(COMMA);
            StatementExpression();
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