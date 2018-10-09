public final void FormalParameters() throws ParseException {
    /*@bgen(jjtree) FormalParameters */
    BSHFormalParameters jjtn000 = new BSHFormalParameters(JJTFORMALPARAMETERS);
    boolean jjtc000 = true;
    jjtree.openNodeScope(jjtn000);
    jjtreeOpenNodeScope(jjtn000);
    try {
        jj_consume_token(LPAREN);
        switch((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
            case BOOLEAN:
            case BYTE:
            case CHAR:
            case DOUBLE:
            case FLOAT:
            case INT:
            case LONG:
            case SHORT:
            case IDENTIFIER:
                FormalParameter();
                label_3: while (true) {
                    switch((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
                        case COMMA:
                            ;
                            break;
                        default:
                            break label_3;
                    }
                    jj_consume_token(COMMA);
                    FormalParameter();
                }
                break;
            default:
                ;
        }
        jj_consume_token(RPAREN);
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