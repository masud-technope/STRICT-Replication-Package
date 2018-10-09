/*
 * Statement syntax follows.
 */
public final void Statement() throws ParseException {
    if (jj_2_22(2)) {
        LabeledStatement();
    } else {
        switch((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
            case LBRACE:
                Block();
                break;
            case SEMICOLON:
                EmptyStatement();
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
            case INCR:
            case DECR:
            case PLUS:
            case MINUS:
                StatementExpression();
                jj_consume_token(SEMICOLON);
                break;
            case SWITCH:
                SwitchStatement();
                break;
            case IF:
                IfStatement();
                break;
            case WHILE:
                WhileStatement();
                break;
            case DO:
                DoStatement();
                break;
            default:
                if (isRegularForStatement()) {
                    ForStatement();
                } else {
                    switch((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
                        case FOR:
                            EnhancedForStatement();
                            break;
                        case BREAK:
                            BreakStatement();
                            break;
                        case CONTINUE:
                            ContinueStatement();
                            break;
                        case RETURN:
                            ReturnStatement();
                            break;
                        case SYNCHRONIZED:
                            SynchronizedStatement();
                            break;
                        case THROW:
                            ThrowStatement();
                            break;
                        case TRY:
                            TryStatement();
                            break;
                        default:
                            jj_consume_token(-1);
                            throw new ParseException();
                    }
                }
        }
    }
}