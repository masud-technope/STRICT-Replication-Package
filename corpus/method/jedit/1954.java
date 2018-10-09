public final void InstanceOfExpression() throws ParseException {
    Token t = null;
    RelationalExpression();
    switch((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
        case INSTANCEOF:
            t = jj_consume_token(INSTANCEOF);
            Type();
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
            break;
        default:
            ;
    }
}