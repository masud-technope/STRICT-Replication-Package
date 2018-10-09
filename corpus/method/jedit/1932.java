public final void UnaryExpression() throws ParseException {
    Token t = null;
    switch((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
        case PLUS:
        case MINUS:
            switch((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
                case PLUS:
                    t = jj_consume_token(PLUS);
                    break;
                case MINUS:
                    t = jj_consume_token(MINUS);
                    break;
                default:
                    jj_consume_token(-1);
                    throw new ParseException();
            }
            UnaryExpression();
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
            break;
        case INCR:
            PreIncrementExpression();
            break;
        case DECR:
            PreDecrementExpression();
            break;
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
        case BANG:
        case TILDE:
            UnaryExpressionNotPlusMinus();
            break;
        default:
            jj_consume_token(-1);
            throw new ParseException();
    }
}