public final void PrimitiveType() throws ParseException {
    /*@bgen(jjtree) PrimitiveType */
    BSHPrimitiveType jjtn000 = new BSHPrimitiveType(JJTPRIMITIVETYPE);
    boolean jjtc000 = true;
    jjtree.openNodeScope(jjtn000);
    jjtreeOpenNodeScope(jjtn000);
    try {
        switch((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
            case BOOLEAN:
                jj_consume_token(BOOLEAN);
                jjtree.closeNodeScope(jjtn000, true);
                jjtc000 = false;
                jjtreeCloseNodeScope(jjtn000);
                jjtn000.type = Boolean.TYPE;
                break;
            case CHAR:
                jj_consume_token(CHAR);
                jjtree.closeNodeScope(jjtn000, true);
                jjtc000 = false;
                jjtreeCloseNodeScope(jjtn000);
                jjtn000.type = Character.TYPE;
                break;
            case BYTE:
                jj_consume_token(BYTE);
                jjtree.closeNodeScope(jjtn000, true);
                jjtc000 = false;
                jjtreeCloseNodeScope(jjtn000);
                jjtn000.type = Byte.TYPE;
                break;
            case SHORT:
                jj_consume_token(SHORT);
                jjtree.closeNodeScope(jjtn000, true);
                jjtc000 = false;
                jjtreeCloseNodeScope(jjtn000);
                jjtn000.type = Short.TYPE;
                break;
            case INT:
                jj_consume_token(INT);
                jjtree.closeNodeScope(jjtn000, true);
                jjtc000 = false;
                jjtreeCloseNodeScope(jjtn000);
                jjtn000.type = Integer.TYPE;
                break;
            case LONG:
                jj_consume_token(LONG);
                jjtree.closeNodeScope(jjtn000, true);
                jjtc000 = false;
                jjtreeCloseNodeScope(jjtn000);
                jjtn000.type = Long.TYPE;
                break;
            case FLOAT:
                jj_consume_token(FLOAT);
                jjtree.closeNodeScope(jjtn000, true);
                jjtc000 = false;
                jjtreeCloseNodeScope(jjtn000);
                jjtn000.type = Float.TYPE;
                break;
            case DOUBLE:
                jj_consume_token(DOUBLE);
                jjtree.closeNodeScope(jjtn000, true);
                jjtc000 = false;
                jjtreeCloseNodeScope(jjtn000);
                jjtn000.type = Double.TYPE;
                break;
            default:
                jj_consume_token(-1);
                throw new ParseException();
        }
    } finally {
        if (jjtc000) {
            jjtree.closeNodeScope(jjtn000, true);
            jjtreeCloseNodeScope(jjtn000);
        }
    }
}