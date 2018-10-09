public final void ConditionalExpression() throws ParseException {
    ConditionalOrExpression();
    switch((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
        case HOOK:
            jj_consume_token(HOOK);
            Expression();
            jj_consume_token(COLON);
            BSHTernaryExpression jjtn001 = new BSHTernaryExpression(JJTTERNARYEXPRESSION);
            boolean jjtc001 = true;
            jjtree.openNodeScope(jjtn001);
            jjtreeOpenNodeScope(jjtn001);
            try {
                ConditionalExpression();
            } catch (Throwable jjte001) {
                if (jjtc001) {
                    jjtree.clearNodeScope(jjtn001);
                    jjtc001 = false;
                } else {
                    jjtree.popNode();
                }
                if (jjte001 instanceof RuntimeException) {
                    {
                        if (true)
                            throw (RuntimeException) jjte001;
                    }
                }
                if (jjte001 instanceof ParseException) {
                    {
                        if (true)
                            throw (ParseException) jjte001;
                    }
                }
                {
                    if (true)
                        throw (Error) jjte001;
                }
            } finally {
                if (jjtc001) {
                    jjtree.closeNodeScope(jjtn001, 3);
                    jjtreeCloseNodeScope(jjtn001);
                }
            }
            break;
        default:
            ;
    }
}