/*
	Originally called ResultType in the grammar
*/
public final void ReturnType() throws ParseException {
    /*@bgen(jjtree) ReturnType */
    BSHReturnType jjtn000 = new BSHReturnType(JJTRETURNTYPE);
    boolean jjtc000 = true;
    jjtree.openNodeScope(jjtn000);
    jjtreeOpenNodeScope(jjtn000);
    try {
        switch((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
            case VOID:
                jj_consume_token(VOID);
                jjtree.closeNodeScope(jjtn000, true);
                jjtc000 = false;
                jjtreeCloseNodeScope(jjtn000);
                jjtn000.isVoid = true;
                break;
            case BOOLEAN:
            case BYTE:
            case CHAR:
            case DOUBLE:
            case FLOAT:
            case INT:
            case LONG:
            case SHORT:
            case IDENTIFIER:
                Type();
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