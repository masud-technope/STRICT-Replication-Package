// This production is to determine lookahead only.
public final void CastLookahead() throws ParseException {
    if (jj_2_10(2)) {
        jj_consume_token(LPAREN);
        PrimitiveType();
    } else if (jj_2_11(2147483647)) {
        jj_consume_token(LPAREN);
        AmbiguousName();
        jj_consume_token(LBRACKET);
        jj_consume_token(RBRACKET);
    } else {
        switch((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
            case LPAREN:
                jj_consume_token(LPAREN);
                AmbiguousName();
                jj_consume_token(RPAREN);
                switch((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
                    case TILDE:
                        jj_consume_token(TILDE);
                        break;
                    case BANG:
                        jj_consume_token(BANG);
                        break;
                    case LPAREN:
                        jj_consume_token(LPAREN);
                        break;
                    case IDENTIFIER:
                        jj_consume_token(IDENTIFIER);
                        break;
                    case NEW:
                        jj_consume_token(NEW);
                        break;
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
                    default:
                        jj_consume_token(-1);
                        throw new ParseException();
                }
                break;
            default:
                jj_consume_token(-1);
                throw new ParseException();
        }
    }
}