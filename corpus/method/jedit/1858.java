public final void SwitchLabel() throws ParseException {
    /*@bgen(jjtree) SwitchLabel */
    BSHSwitchLabel jjtn000 = new BSHSwitchLabel(JJTSWITCHLABEL);
    boolean jjtc000 = true;
    jjtree.openNodeScope(jjtn000);
    jjtreeOpenNodeScope(jjtn000);
    try {
        switch((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
            case CASE:
                jj_consume_token(CASE);
                Expression();
                jj_consume_token(COLON);
                break;
            case _DEFAULT:
                jj_consume_token(_DEFAULT);
                jj_consume_token(COLON);
                jjtree.closeNodeScope(jjtn000, true);
                jjtc000 = false;
                jjtreeCloseNodeScope(jjtn000);
                jjtn000.isDefault = true;
                break;
            default:
                jj_consume_token(-1);
                throw new ParseException();
        }
    } catch (Throwable jjte000) {
        if (jjtc000) {
            jjtree.clearNodeScope(jjtn000);
            jjtc000 = false;
        } else {
            jjtree.popNode();
        }
        if (jjte000 instanceof RuntimeException) {
            {
                if (true)
                    throw (RuntimeException) jjte000;
            }
        }
        if (jjte000 instanceof ParseException) {
            {
                if (true)
                    throw (ParseException) jjte000;
            }
        }
        {
            if (true)
                throw (Error) jjte000;
        }
    } finally {
        if (jjtc000) {
            jjtree.closeNodeScope(jjtn000, true);
            jjtreeCloseNodeScope(jjtn000);
        }
    }
}