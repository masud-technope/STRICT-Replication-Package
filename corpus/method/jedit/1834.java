/*
	The new JDK1.5 enhanced for statement.
	e.g. for( int a : arrayOfInts ) { }
	We also support loose typing of the iterator var for BeanShell
	e.g. for( a : arrayOfInts ) { }
*/
public final void EnhancedForStatement() throws ParseException {
    /*@bgen(jjtree) EnhancedForStatement */
    BSHEnhancedForStatement jjtn000 = new BSHEnhancedForStatement(JJTENHANCEDFORSTATEMENT);
    boolean jjtc000 = true;
    jjtree.openNodeScope(jjtn000);
    jjtreeOpenNodeScope(jjtn000);
    Token t = null;
    try {
        if (jj_2_30(4)) {
            jj_consume_token(FOR);
            jj_consume_token(LPAREN);
            t = jj_consume_token(IDENTIFIER);
            jj_consume_token(COLON);
            Expression();
            jj_consume_token(RPAREN);
            Statement();
            jjtree.closeNodeScope(jjtn000, true);
            jjtc000 = false;
            jjtreeCloseNodeScope(jjtn000);
            jjtn000.varName = t.image;
        } else {
            switch((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
                case FOR:
                    jj_consume_token(FOR);
                    jj_consume_token(LPAREN);
                    Type();
                    t = jj_consume_token(IDENTIFIER);
                    jj_consume_token(COLON);
                    Expression();
                    jj_consume_token(RPAREN);
                    Statement();
                    jjtree.closeNodeScope(jjtn000, true);
                    jjtc000 = false;
                    jjtreeCloseNodeScope(jjtn000);
                    jjtn000.varName = t.image;
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