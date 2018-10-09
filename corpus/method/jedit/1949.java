public final void RelationalExpression() throws ParseException {
    Token t = null;
    ShiftExpression();
    label_13: while (true) {
        switch((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
            case GT:
            case GTX:
            case LT:
            case LTX:
            case LE:
            case LEX:
            case GE:
            case GEX:
                ;
                break;
            default:
                break label_13;
        }
        switch((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
            case LT:
                t = jj_consume_token(LT);
                break;
            case LTX:
                t = jj_consume_token(LTX);
                break;
            case GT:
                t = jj_consume_token(GT);
                break;
            case GTX:
                t = jj_consume_token(GTX);
                break;
            case LE:
                t = jj_consume_token(LE);
                break;
            case LEX:
                t = jj_consume_token(LEX);
                break;
            case GE:
                t = jj_consume_token(GE);
                break;
            case GEX:
                t = jj_consume_token(GEX);
                break;
            default:
                jj_consume_token(-1);
                throw new ParseException();
        }
        ShiftExpression();
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