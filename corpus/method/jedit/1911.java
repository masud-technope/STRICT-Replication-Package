public final void PrimaryPrefix() throws ParseException {
    switch((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
        case FALSE:
        case NULL:
        case TRUE:
        case VOID:
        case INTEGER_LITERAL:
        case FLOATING_POINT_LITERAL:
        case CHARACTER_LITERAL:
        case STRING_LITERAL:
            Literal();
            break;
        case LPAREN:
            jj_consume_token(LPAREN);
            Expression();
            jj_consume_token(RPAREN);
            break;
        case NEW:
            AllocationExpression();
            break;
        default:
            if (jj_2_14(2147483647)) {
                MethodInvocation();
            } else if (jj_2_15(2147483647)) {
                Type();
            } else {
                switch((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
                    case IDENTIFIER:
                        AmbiguousName();
                        break;
                    default:
                        jj_consume_token(-1);
                        throw new ParseException();
                }
            }
    }
}