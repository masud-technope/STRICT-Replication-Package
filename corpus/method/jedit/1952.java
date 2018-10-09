public final void EqualityExpression() throws ParseException {
    Token t = null;
    InstanceOfExpression();
    label_12: while (true) {
        switch((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
            case EQ:
            case NE:
                ;
                break;
            default:
                break label_12;
        }
        switch((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
            case EQ:
                t = jj_consume_token(EQ);
                break;
            case NE:
                t = jj_consume_token(NE);
                break;
            default:
                jj_consume_token(-1);
                throw new ParseException();
        }
        InstanceOfExpression();
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