public final void ShiftExpression() throws ParseException {
    Token t = null;
    AdditiveExpression();
    label_14: while (true) {
        switch((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
            case LSHIFT:
            case LSHIFTX:
            case RSIGNEDSHIFT:
            case RSIGNEDSHIFTX:
            case RUNSIGNEDSHIFT:
            case RUNSIGNEDSHIFTX:
                ;
                break;
            default:
                break label_14;
        }
        switch((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
            case LSHIFT:
                t = jj_consume_token(LSHIFT);
                break;
            case LSHIFTX:
                t = jj_consume_token(LSHIFTX);
                break;
            case RSIGNEDSHIFT:
                t = jj_consume_token(RSIGNEDSHIFT);
                break;
            case RSIGNEDSHIFTX:
                t = jj_consume_token(RSIGNEDSHIFTX);
                break;
            case RUNSIGNEDSHIFT:
                t = jj_consume_token(RUNSIGNEDSHIFT);
                break;
            case RUNSIGNEDSHIFTX:
                t = jj_consume_token(RUNSIGNEDSHIFTX);
                break;
            default:
                jj_consume_token(-1);
                throw new ParseException();
        }
        AdditiveExpression();
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