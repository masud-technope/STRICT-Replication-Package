public final void PostfixExpression() throws ParseException {
    Token t = null;
    if (jj_2_12(2147483647)) {
        PrimaryExpression();
        switch((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
            case INCR:
                t = jj_consume_token(INCR);
                break;
            case DECR:
                t = jj_consume_token(DECR);
                break;
            default:
                jj_consume_token(-1);
                throw new ParseException();
        }
        BSHUnaryExpression jjtn001 = new BSHUnaryExpression(JJTUNARYEXPRESSION);
        boolean jjtc001 = true;
        jjtree.openNodeScope(jjtn001);
        jjtreeOpenNodeScope(jjtn001);
        try {
            jjtree.closeNodeScope(jjtn001, 1);
            jjtc001 = false;
            jjtreeCloseNodeScope(jjtn001);
            jjtn001.kind = t.kind;
            jjtn001.postfix = true;
        } finally {
            if (jjtc001) {
                jjtree.closeNodeScope(jjtn001, 1);
                jjtreeCloseNodeScope(jjtn001);
            }
        }
    } else {
        switch((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
            case BOOLEAN:
            case BYTE:
            case CHAR:
            case DOUBLE:
            case FALSE:
            case FLOAT:
            case INT:
            case LONG:
            case NEW:
            case NULL:
            case SHORT:
            case TRUE:
            case VOID:
            case INTEGER_LITERAL:
            case FLOATING_POINT_LITERAL:
            case CHARACTER_LITERAL:
            case STRING_LITERAL:
            case IDENTIFIER:
            case LPAREN:
                PrimaryExpression();
                break;
            default:
                jj_consume_token(-1);
                throw new ParseException();
        }
    }
}