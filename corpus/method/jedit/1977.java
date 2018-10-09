/*
	Type, name and expression syntax follows.
*/
public final void Type() throws ParseException {
    /*@bgen(jjtree) Type */
    BSHType jjtn000 = new BSHType(JJTTYPE);
    boolean jjtc000 = true;
    jjtree.openNodeScope(jjtn000);
    jjtreeOpenNodeScope(jjtn000);
    try {
        switch((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
            case BOOLEAN:
            case BYTE:
            case CHAR:
            case DOUBLE:
            case FLOAT:
            case INT:
            case LONG:
            case SHORT:
                PrimitiveType();
                break;
            case IDENTIFIER:
                AmbiguousName();
                break;
            default:
                jj_consume_token(-1);
                throw new ParseException();
        }
        label_4: while (true) {
            if (jj_2_6(2)) {
                ;
            } else {
                break label_4;
            }
            jj_consume_token(LBRACKET);
            jj_consume_token(RBRACKET);
            jjtn000.addArrayDimension();
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