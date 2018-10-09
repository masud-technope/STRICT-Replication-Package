public final void BreakStatement() throws ParseException {
    /*@bgen(jjtree) ReturnStatement */
    BSHReturnStatement jjtn000 = new BSHReturnStatement(JJTRETURNSTATEMENT);
    boolean jjtc000 = true;
    jjtree.openNodeScope(jjtn000);
    jjtreeOpenNodeScope(jjtn000);
    try {
        jj_consume_token(BREAK);
        switch((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
            case IDENTIFIER:
                jj_consume_token(IDENTIFIER);
                break;
            default:
                ;
        }
        jj_consume_token(SEMICOLON);
        jjtree.closeNodeScope(jjtn000, true);
        jjtc000 = false;
        jjtreeCloseNodeScope(jjtn000);
        jjtn000.kind = BREAK;
    } finally {
        if (jjtc000) {
            jjtree.closeNodeScope(jjtn000, true);
            jjtreeCloseNodeScope(jjtn000);
        }
    }
}