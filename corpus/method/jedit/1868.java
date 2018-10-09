public final void BlockStatement() throws ParseException {
    if (jj_2_24(2147483647)) {
        ClassDeclaration();
    } else if (jj_2_25(2147483647)) {
        MethodDeclaration();
    } else if (jj_2_26(2147483647)) {
        MethodDeclaration();
    } else if (jj_2_27(2147483647)) {
        TypedVariableDeclaration();
        jj_consume_token(SEMICOLON);
    } else if (jj_2_28(1)) {
        Statement();
    } else {
        switch((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
            case IMPORT:
            case STATIC:
                ImportDeclaration();
                break;
            case PACKAGE:
                PackageDeclaration();
                break;
            case FORMAL_COMMENT:
                FormalComment();
                break;
            default:
                jj_consume_token(-1);
                throw new ParseException();
        }
    }
}