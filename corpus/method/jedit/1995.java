/*
	Thanks to Sreenivasa Viswanadha for suggesting how to get rid of expensive
	lookahead here.
*/
public final boolean Line() throws ParseException {
    switch((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
        case 0:
            jj_consume_token(0);
            Interpreter.debug("End of File!");
            {
                if (true)
                    return true;
            }
            break;
        default:
            if (jj_2_1(1)) {
                BlockStatement();
                {
                    if (true)
                        return false;
                }
            } else {
                jj_consume_token(-1);
                throw new ParseException();
            }
    }
    throw new Error("Missing return statement in function");
}