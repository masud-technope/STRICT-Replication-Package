public final void ExclusiveOrExpression() throws ParseException {
    Token t = null;
    AndExpression();
    label_10: while (true) {
        switch((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
            case XOR:
                ;
                break;
            default:
                break label_10;
        }
        t = jj_consume_token(XOR);
        AndExpression();
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