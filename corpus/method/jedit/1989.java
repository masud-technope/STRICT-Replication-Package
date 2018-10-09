public final void ImportDeclaration() throws ParseException {
    /*@bgen(jjtree) ImportDeclaration */
    BSHImportDeclaration jjtn000 = new BSHImportDeclaration(JJTIMPORTDECLARATION);
    boolean jjtc000 = true;
    jjtree.openNodeScope(jjtn000);
    jjtreeOpenNodeScope(jjtn000);
    Token s = null;
    Token t = null;
    try {
        if (jj_2_3(3)) {
            switch((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
                case STATIC:
                    s = jj_consume_token(STATIC);
                    break;
                default:
                    ;
            }
            jj_consume_token(IMPORT);
            AmbiguousName();
            switch((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
                case DOT:
                    t = jj_consume_token(DOT);
                    jj_consume_token(STAR);
                    break;
                default:
                    ;
            }
            jj_consume_token(SEMICOLON);
            jjtree.closeNodeScope(jjtn000, true);
            jjtc000 = false;
            jjtreeCloseNodeScope(jjtn000);
            if (s != null)
                jjtn000.staticImport = true;
            if (t != null)
                jjtn000.importPackage = true;
        } else {
            switch((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
                case IMPORT:
                    jj_consume_token(IMPORT);
                    jj_consume_token(STAR);
                    jj_consume_token(SEMICOLON);
                    jjtree.closeNodeScope(jjtn000, true);
                    jjtc000 = false;
                    jjtreeCloseNodeScope(jjtn000);
                    jjtn000.superImport = true;
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