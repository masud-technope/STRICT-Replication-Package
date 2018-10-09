public final void PreIncrementExpression() throws ParseException {
    Token t = null;
    t = jj_consume_token(INCR);
    PrimaryExpression();
    BSHUnaryExpression jjtn001 = new BSHUnaryExpression(JJTUNARYEXPRESSION);
    boolean jjtc001 = true;
    jjtree.openNodeScope(jjtn001);
    jjtreeOpenNodeScope(jjtn001);
    try {
        jjtree.closeNodeScope(jjtn001, 1);
        jjtc001 = false;
        jjtreeCloseNodeScope(jjtn001);
        jjtn001.kind = t.kind;
    } finally {
        if (jjtc001) {
            jjtree.closeNodeScope(jjtn001, 1);
            jjtreeCloseNodeScope(jjtn001);
        }
    }
}