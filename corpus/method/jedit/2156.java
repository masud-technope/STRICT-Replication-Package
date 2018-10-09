public final void TryStatement() throws ParseException {
    /*@bgen(jjtree) TryStatement */
    BSHTryStatement jjtn000 = new BSHTryStatement(JJTTRYSTATEMENT);
    boolean jjtc000 = true;
    jjtree.openNodeScope(jjtn000);
    jjtreeOpenNodeScope(jjtn000);
    boolean closed = false;
    try {
        jj_consume_token(TRY);
        Block();
        label_27: while (true) {
            switch((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
                case CATCH:
                    ;
                    break;
                default:
                    break label_27;
            }
            jj_consume_token(CATCH);
            jj_consume_token(LPAREN);
            FormalParameter();
            jj_consume_token(RPAREN);
            Block();
            closed = true;
        }
        switch((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
            case FINALLY:
                jj_consume_token(FINALLY);
                Block();
                closed = true;
                break;
            default:
                ;
        }
        jjtree.closeNodeScope(jjtn000, true);
        jjtc000 = false;
        jjtreeCloseNodeScope(jjtn000);
        if (!closed) {
            if (true)
                throw generateParseException();
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