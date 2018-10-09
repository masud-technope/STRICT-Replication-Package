public final void PrimarySuffix() throws ParseException {
    /*@bgen(jjtree) PrimarySuffix */
    BSHPrimarySuffix jjtn000 = new BSHPrimarySuffix(JJTPRIMARYSUFFIX);
    boolean jjtc000 = true;
    jjtree.openNodeScope(jjtn000);
    jjtreeOpenNodeScope(jjtn000);
    Token t = null;
    try {
        if (jj_2_16(2)) {
            jj_consume_token(DOT);
            jj_consume_token(CLASS);
            jjtree.closeNodeScope(jjtn000, true);
            jjtc000 = false;
            jjtreeCloseNodeScope(jjtn000);
            jjtn000.operation = BSHPrimarySuffix.CLASS;
        } else {
            switch((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
                case LBRACKET:
                    jj_consume_token(LBRACKET);
                    Expression();
                    jj_consume_token(RBRACKET);
                    jjtree.closeNodeScope(jjtn000, true);
                    jjtc000 = false;
                    jjtreeCloseNodeScope(jjtn000);
                    jjtn000.operation = BSHPrimarySuffix.INDEX;
                    break;
                case DOT:
                    jj_consume_token(DOT);
                    t = jj_consume_token(IDENTIFIER);
                    switch((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
                        case LPAREN:
                            Arguments();
                            break;
                        default:
                            ;
                    }
                    jjtree.closeNodeScope(jjtn000, true);
                    jjtc000 = false;
                    jjtreeCloseNodeScope(jjtn000);
                    jjtn000.operation = BSHPrimarySuffix.NAME;
                    jjtn000.field = t.image;
                    break;
                case LBRACE:
                    jj_consume_token(LBRACE);
                    Expression();
                    jj_consume_token(RBRACE);
                    jjtree.closeNodeScope(jjtn000, true);
                    jjtc000 = false;
                    jjtreeCloseNodeScope(jjtn000);
                    jjtn000.operation = BSHPrimarySuffix.PROPERTY;
                    break;
                default:
                    jj_consume_token(-1);
                    throw new ParseException();
            }
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