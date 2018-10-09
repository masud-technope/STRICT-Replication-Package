public final void CastExpression() throws ParseException {
    /*@bgen(jjtree) CastExpression */
    BSHCastExpression jjtn000 = new BSHCastExpression(JJTCASTEXPRESSION);
    boolean jjtc000 = true;
    jjtree.openNodeScope(jjtn000);
    jjtreeOpenNodeScope(jjtn000);
    try {
        if (jj_2_13(2147483647)) {
            jj_consume_token(LPAREN);
            Type();
            jj_consume_token(RPAREN);
            UnaryExpression();
        } else {
            switch((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
                case LPAREN:
                    jj_consume_token(LPAREN);
                    Type();
                    jj_consume_token(RPAREN);
                    UnaryExpressionNotPlusMinus();
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