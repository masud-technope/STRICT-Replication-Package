public final void AndExpression() throws ParseException {
    Token t = null;
    EqualityExpression();
    label_11: while (true) {
        switch((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
            case BIT_AND:
            case BIT_ANDX:
                ;
                break;
            default:
                break label_11;
        }
        switch((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
            case BIT_AND:
                t = jj_consume_token(BIT_AND);
                break;
            case BIT_ANDX:
                t = jj_consume_token(BIT_ANDX);
                break;
            default:
                jj_consume_token(-1);
                throw new ParseException();
        }
        EqualityExpression();
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