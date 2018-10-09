/**
	Declared a typed variable.
	Untyped variables are not declared per-se but are handled by the part
	of the grammar that deals with assignments.
*/
public final void TypedVariableDeclaration() throws ParseException {
    /*@bgen(jjtree) TypedVariableDeclaration */
    BSHTypedVariableDeclaration jjtn000 = new BSHTypedVariableDeclaration(JJTTYPEDVARIABLEDECLARATION);
    boolean jjtc000 = true;
    jjtree.openNodeScope(jjtn000);
    jjtreeOpenNodeScope(jjtn000);
    Token t = null;
    Modifiers mods;
    try {
        mods = Modifiers(Modifiers.FIELD, false);
        Type();
        VariableDeclarator();
        label_25: while (true) {
            switch((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
                case COMMA:
                    ;
                    break;
                default:
                    break label_25;
            }
            jj_consume_token(COMMA);
            VariableDeclarator();
        }
        jjtree.closeNodeScope(jjtn000, true);
        jjtc000 = false;
        jjtreeCloseNodeScope(jjtn000);
        jjtn000.modifiers = mods;
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