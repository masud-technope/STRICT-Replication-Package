public final void AdditiveExpression() throws ParseException {
    Token t = null;
    MultiplicativeExpression();
    label_15: while (true) {
        switch((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
            case PLUS:
            case MINUS:
                ;
                break;
            default:
                break label_15;
        }
        switch((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
            case PLUS:
                t = jj_consume_token(PLUS);
                break;
            case MINUS:
                t = jj_consume_token(MINUS);
                break;
            default:
                jj_consume_token(-1);
                throw new ParseException();
        }
        MultiplicativeExpression();
        BSHBinaryExpression jjtn001 = new BSHBinaryExpression(JJTBINARYEXPRESSION);
        boolean jjtc001 = true;
        jjtree.openNodeScope(jjtn001);
        jjtreeOpenNodeScope(jjtn001);
        try {
            jjtree.closeNodeScope(jjtn001, 2);
            jjtc001 = false;
            jjtreeCloseNodeScope(jjtn001);
            jjtn001.kind = t.kind;
        } finally {
            if (jjtc001) {
                jjtree.closeNodeScope(jjtn001, 2);
                jjtreeCloseNodeScope(jjtn001);
            }
        }
    }
}