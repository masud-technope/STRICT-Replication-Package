public final void ArrayDimensions() throws ParseException {
    /*@bgen(jjtree) ArrayDimensions */
    BSHArrayDimensions jjtn000 = new BSHArrayDimensions(JJTARRAYDIMENSIONS);
    boolean jjtc000 = true;
    jjtree.openNodeScope(jjtn000);
    jjtreeOpenNodeScope(jjtn000);
    try {
        if (jj_2_21(2)) {
            label_19: while (true) {
                jj_consume_token(LBRACKET);
                Expression();
                jj_consume_token(RBRACKET);
                jjtn000.addDefinedDimension();
                if (jj_2_19(2)) {
                    ;
                } else {
                    break label_19;
                }
            }
            label_20: while (true) {
                if (jj_2_20(2)) {
                    ;
                } else {
                    break label_20;
                }
                jj_consume_token(LBRACKET);
                jj_consume_token(RBRACKET);
                jjtn000.addUndefinedDimension();
            }
        } else {
            switch((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
                case LBRACKET:
                    label_21: while (true) {
                        jj_consume_token(LBRACKET);
                        jj_consume_token(RBRACKET);
                        jjtn000.addUndefinedDimension();
                        switch((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
                            case LBRACKET:
                                ;
                                break;
                            default:
                                break label_21;
                        }
                    }
                    ArrayInitializer();
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