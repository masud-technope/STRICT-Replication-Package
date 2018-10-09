public final void MultiplicativeExpression() throws ParseException {
    Token t = null;
    UnaryExpression();
    label_16: while (true) {
        switch((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
            case STAR:
            case SLASH:
            case MOD:
                ;
                break;
            default:
                break label_16;
        }
        switch((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
            case STAR:
                t = jj_consume_token(STAR);
                break;
            case SLASH:
                t = jj_consume_token(SLASH);
                break;
            case MOD:
                t = jj_consume_token(MOD);
                break;
            default:
                jj_consume_token(-1);
                throw new ParseException();
        }
        UnaryExpression();
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