public final boolean BooleanLiteral() throws ParseException {
    switch((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
        case TRUE:
            jj_consume_token(TRUE);
            {
                if (true)
                    return true;
            }
            break;
        case FALSE:
            jj_consume_token(FALSE);
            {
                if (true)
                    return false;
            }
            break;
        default:
            jj_consume_token(-1);
            throw new ParseException();
    }
    throw new Error("Missing return statement in function");
}