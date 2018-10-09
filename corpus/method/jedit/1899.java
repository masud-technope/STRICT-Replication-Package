// leave these on the stack for Arguments() to handle
public final void ArgumentList() throws ParseException {
    Expression();
    label_18: while (true) {
        switch((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
            case COMMA:
                ;
                break;
            default:
                break label_18;
        }
        jj_consume_token(COMMA);
        Expression();
    }
}