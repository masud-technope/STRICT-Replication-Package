public final void AllocationExpression() throws ParseException {
    /*@bgen(jjtree) AllocationExpression */
    BSHAllocationExpression jjtn000 = new BSHAllocationExpression(JJTALLOCATIONEXPRESSION);
    boolean jjtc000 = true;
    jjtree.openNodeScope(jjtn000);
    jjtreeOpenNodeScope(jjtn000);
    try {
        if (jj_2_18(2)) {
            jj_consume_token(NEW);
            PrimitiveType();
            ArrayDimensions();
        } else {
            switch((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
                case NEW:
                    jj_consume_token(NEW);
                    AmbiguousName();
                    switch((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
                        case LBRACKET:
                            ArrayDimensions();
                            break;
                        case LPAREN:
                            Arguments();
                            if (jj_2_17(2)) {
                                Block();
                            } else {
                                ;
                            }
                            break;
                        default:
                            jj_consume_token(-1);
                            throw new ParseException();
                    }
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