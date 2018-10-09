public final void ArrayInitializer() throws ParseException {
    /*@bgen(jjtree) ArrayInitializer */
    BSHArrayInitializer jjtn000 = new BSHArrayInitializer(JJTARRAYINITIALIZER);
    boolean jjtc000 = true;
    jjtree.openNodeScope(jjtn000);
    jjtreeOpenNodeScope(jjtn000);
    try {
        jj_consume_token(LBRACE);
        switch((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
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
            case LBRACE:
            case BANG:
            case TILDE:
            case INCR:
            case DECR:
            case PLUS:
            case MINUS:
                VariableInitializer();
                label_2: while (true) {
                    if (jj_2_4(2)) {
                        ;
                    } else {
                        break label_2;
                    }
                    jj_consume_token(COMMA);
                    VariableInitializer();
                }
                break;
            default:
                ;
        }
        switch((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
            case COMMA:
                jj_consume_token(COMMA);
                break;
            default:
                ;
        }
        jj_consume_token(RBRACE);
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