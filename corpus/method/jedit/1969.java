/*
 * Expression syntax follows.
 */
public final void Expression() throws ParseException {
    if (jj_2_8(2147483647)) {
        Assignment();
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
            case BANG:
            case TILDE:
            case INCR:
            case DECR:
            case PLUS:
            case MINUS:
                ConditionalExpression();
                break;
            default:
                jj_consume_token(-1);
                throw new ParseException();
        }
    }
}