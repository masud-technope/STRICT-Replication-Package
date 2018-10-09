public final void InclusiveOrExpression() throws ParseException {
    Token t = null;
    ExclusiveOrExpression();
    label_9: while (true) {
        switch((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
            case BIT_OR:
            case BIT_ORX:
                ;
                break;
            default:
                break label_9;
        }
        switch((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
            case BIT_OR:
                t = jj_consume_token(BIT_OR);
                break;
            case BIT_ORX:
                t = jj_consume_token(BIT_ORX);
                break;
            default:
                jj_consume_token(-1);
                throw new ParseException();
        }
        ExclusiveOrExpression();
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