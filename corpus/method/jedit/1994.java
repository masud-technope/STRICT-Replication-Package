/**
*/
public final void ClassDeclaration() throws ParseException {
    /*@bgen(jjtree) ClassDeclaration */
    BSHClassDeclaration jjtn000 = new BSHClassDeclaration(JJTCLASSDECLARATION);
    boolean jjtc000 = true;
    jjtree.openNodeScope(jjtn000);
    jjtreeOpenNodeScope(jjtn000);
    Modifiers mods;
    Token name;
    int numInterfaces;
    try {
        mods = Modifiers(Modifiers.CLASS, false);
        switch((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
            case CLASS:
                jj_consume_token(CLASS);
                break;
            case INTERFACE:
                jj_consume_token(INTERFACE);
                jjtn000.isInterface = true;
                break;
            default:
                jj_consume_token(-1);
                throw new ParseException();
        }
        name = jj_consume_token(IDENTIFIER);
        switch((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
            case EXTENDS:
                jj_consume_token(EXTENDS);
                AmbiguousName();
                jjtn000.extend = true;
                break;
            default:
                ;
        }
        switch((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
            case IMPLEMENTS:
                jj_consume_token(IMPLEMENTS);
                numInterfaces = NameList();
                jjtn000.numInterfaces = numInterfaces;
                break;
            default:
                ;
        }
        Block();
        jjtree.closeNodeScope(jjtn000, true);
        jjtc000 = false;
        jjtreeCloseNodeScope(jjtn000);
        jjtn000.modifiers = mods;
        jjtn000.name = name.image;
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