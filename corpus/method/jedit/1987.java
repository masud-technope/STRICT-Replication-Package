/*
this originally handled postfix array dimensions...

void VariableDeclaratorId() #VariableDeclaratorId :
{ Token t; }
{
  t=<IDENTIFIER> { jjtThis.name = t.image; }
  ( "[" "]" { jjtThis.addUndefinedDimension(); } )*
}
*/
public final void VariableInitializer() throws ParseException {
    switch((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
        case LBRACE:
            ArrayInitializer();
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
            Expression();
            break;
        default:
            jj_consume_token(-1);
            throw new ParseException();
    }
}