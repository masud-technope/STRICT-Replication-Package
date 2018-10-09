public final void MethodDeclaration() throws ParseException {
    /*@bgen(jjtree) MethodDeclaration */
    BSHMethodDeclaration jjtn000 = new BSHMethodDeclaration(JJTMETHODDECLARATION);
    boolean jjtc000 = true;
    jjtree.openNodeScope(jjtn000);
    jjtreeOpenNodeScope(jjtn000);
    Token t = null;
    Modifiers mods;
    int count;
    try {
        mods = Modifiers(Modifiers.METHOD, false);
        jjtn000.modifiers = mods;
        if (jj_2_2(2147483647)) {
            t = jj_consume_token(IDENTIFIER);
            jjtn000.name = t.image;
        } else {
            switch((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
                case BOOLEAN:
                case BYTE:
                case CHAR:
                case DOUBLE:
                case FLOAT:
                case INT:
                case LONG:
                case SHORT:
                case VOID:
                case IDENTIFIER:
                    ReturnType();
                    t = jj_consume_token(IDENTIFIER);
                    jjtn000.name = t.image;
                    break;
                default:
                    jj_consume_token(-1);
                    throw new ParseException();
            }
        }
        FormalParameters();
        switch((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
            case THROWS:
                jj_consume_token(THROWS);
                count = NameList();
                jjtn000.numThrows = count;
                break;
            default:
                ;
        }
        switch((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
            case LBRACE:
                Block();
                break;
            case SEMICOLON:
                jj_consume_token(SEMICOLON);
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