public final void ConditionalAndExpression() throws ParseException {
    Token t = null;
    InclusiveOrExpression();
    label_8: while (true) {
        switch((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
            case BOOL_AND:
            case BOOL_ANDX:
                ;
                break;
            default:
                break label_8;
        }
        switch((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
            case BOOL_AND:
                t = jj_consume_token(BOOL_AND);
                break;
            case BOOL_ANDX:
                t = jj_consume_token(BOOL_ANDX);
                break;
            default:
                jj_consume_token(-1);
                throw new ParseException();
        }
        InclusiveOrExpression();
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