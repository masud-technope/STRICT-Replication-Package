/*****************************************
 * THE JAVA LANGUAGE GRAMMAR STARTS HERE *
 *****************************************/
/*
	Gather modifiers for a class, method, or field.
	I lookahead is true then we are being called as part of a lookahead and we
	should not enforce any rules.  Otherwise we validate based on context
	(field, method, class)
*/
public final Modifiers Modifiers(int context, boolean lookahead) throws ParseException {
    Modifiers mods = null;
    label_1: while (true) {
        switch((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
            case ABSTRACT:
            case FINAL:
            case NATIVE:
            case PRIVATE:
            case PROTECTED:
            case PUBLIC:
            case STATIC:
            case STRICTFP:
            case SYNCHRONIZED:
            case TRANSIENT:
            case VOLATILE:
                ;
                break;
            default:
                break label_1;
        }
        switch((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
            case PRIVATE:
                jj_consume_token(PRIVATE);
                break;
            case PROTECTED:
                jj_consume_token(PROTECTED);
                break;
            case PUBLIC:
                jj_consume_token(PUBLIC);
                break;
            case SYNCHRONIZED:
                jj_consume_token(SYNCHRONIZED);
                break;
            case FINAL:
                jj_consume_token(FINAL);
                break;
            case NATIVE:
                jj_consume_token(NATIVE);
                break;
            case TRANSIENT:
                jj_consume_token(TRANSIENT);
                break;
            case VOLATILE:
                jj_consume_token(VOLATILE);
                break;
            case ABSTRACT:
                jj_consume_token(ABSTRACT);
                break;
            case STATIC:
                jj_consume_token(STATIC);
                break;
            case STRICTFP:
                jj_consume_token(STRICTFP);
                break;
            default:
                jj_consume_token(-1);
                throw new ParseException();
        }
        if (!lookahead)
            try {
                if (mods == null)
                    mods = new Modifiers();
                mods.addModifier(context, getToken(0).image);
            } catch (IllegalStateException e) {
                {
                    if (true)
                        throw createParseException(e.getMessage());
                }
            }
    }
    {
        if (true)
            return mods;
    }
    throw new Error("Missing return statement in function");
}