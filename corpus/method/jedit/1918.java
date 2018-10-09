public final void PrimaryExpression() throws ParseException {
    /*@bgen(jjtree) PrimaryExpression */
    BSHPrimaryExpression jjtn000 = new BSHPrimaryExpression(JJTPRIMARYEXPRESSION);
    boolean jjtc000 = true;
    jjtree.openNodeScope(jjtn000);
    jjtreeOpenNodeScope(jjtn000);
    try {
        PrimaryPrefix();
        label_17: while (true) {
            switch((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
                case LBRACE:
                case LBRACKET:
                case DOT:
                    ;
                    break;
                default:
                    break label_17;
            }
            PrimarySuffix();
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