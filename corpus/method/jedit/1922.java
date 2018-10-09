public final void UnaryExpressionNotPlusMinus() throws ParseException {
    Token t = null;
    switch((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
        case BANG:
        case TILDE:
            switch((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
                case TILDE:
                    t = jj_consume_token(TILDE);
                    break;
                case BANG:
                    t = jj_consume_token(BANG);
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
        default:
            if (jj_2_9(2147483647)) {
                CastExpression();
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
                        PostfixExpression();
                        break;
                    default:
                        jj_consume_token(-1);
                        throw new ParseException();
                }
            }
    }
}