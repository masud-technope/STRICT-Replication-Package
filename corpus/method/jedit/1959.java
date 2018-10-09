public final void ConditionalOrExpression() throws ParseException {
    Token t = null;
    ConditionalAndExpression();
    label_7: while (true) {
        switch((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
            case BOOL_OR:
            case BOOL_ORX:
                ;
                break;
            default:
                break label_7;
        }
        switch((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
            case BOOL_OR:
                t = jj_consume_token(BOOL_OR);
                break;
            case BOOL_ORX:
                t = jj_consume_token(BOOL_ORX);
                break;
            default:
                jj_consume_token(-1);
                throw new ParseException();
        }
        ConditionalAndExpression();
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