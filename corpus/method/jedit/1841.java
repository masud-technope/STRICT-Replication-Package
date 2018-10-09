public final void ForStatement() throws ParseException {
    /*@bgen(jjtree) ForStatement */
    BSHForStatement jjtn000 = new BSHForStatement(JJTFORSTATEMENT);
    boolean jjtc000 = true;
    jjtree.openNodeScope(jjtn000);
    jjtreeOpenNodeScope(jjtn000);
    Token t = null;
    try {
        jj_consume_token(FOR);
        jj_consume_token(LPAREN);
        switch((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
            case ABSTRACT:
            case BOOLEAN:
            case BYTE:
            case CHAR:
            case DOUBLE:
            case FALSE:
            case FINAL:
            case FLOAT:
            case INT:
            case LONG:
            case NATIVE:
            case NEW:
            case NULL:
            case PRIVATE:
            case PROTECTED:
            case PUBLIC:
            case SHORT:
            case STATIC:
            case STRICTFP:
            case SYNCHRONIZED:
            case TRANSIENT:
            case TRUE:
            case VOID:
            case VOLATILE:
            case INTEGER_LITERAL:
            case FLOATING_POINT_LITERAL:
            case CHARACTER_LITERAL:
            case STRING_LITERAL:
            case IDENTIFIER:
            case LPAREN:
            case BANG:
            case TILDE:
            case INCR:
            case DECR:
            case PLUS:
            case MINUS:
                ForInit();
                jjtn000.hasForInit = true;
                break;
            default:
                ;
        }
        jj_consume_token(SEMICOLON);
        switch((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
            case BOOLEAN:
            case BYTE:
            case CHAR:
            case DOUBLE:
            case FALSE:
            case FLOAT:
            case INT:
            case LONG:
            case NEW:
            case NULL:
            case SHORT:
            case TRUE:
            case VOID:
            case INTEGER_LITERAL:
            case FLOATING_POINT_LITERAL:
            case CHARACTER_LITERAL:
            case STRING_LITERAL:
            case IDENTIFIER:
            case LPAREN:
            case BANG:
            case TILDE:
            case INCR:
            case DECR:
            case PLUS:
            case MINUS:
                Expression();
                jjtn000.hasExpression = true;
                break;
            default:
                ;
        }
        jj_consume_token(SEMICOLON);
        switch((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
            case BOOLEAN:
            case BYTE:
            case CHAR:
            case DOUBLE:
            case FALSE:
            case FLOAT:
            case INT:
            case LONG:
            case NEW:
            case NULL:
            case SHORT:
            case TRUE:
            case VOID:
            case INTEGER_LITERAL:
            case FLOATING_POINT_LITERAL:
            case CHARACTER_LITERAL:
            case STRING_LITERAL:
            case IDENTIFIER:
            case LPAREN:
            case BANG:
            case TILDE:
            case INCR:
            case DECR:
            case PLUS:
            case MINUS:
                ForUpdate();
                jjtn000.hasForUpdate = true;
                break;
            default:
                ;
        }
        jj_consume_token(RPAREN);
        Statement();
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