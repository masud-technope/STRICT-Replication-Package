public final void Literal() throws ParseException {
    /*@bgen(jjtree) Literal */
    BSHLiteral jjtn000 = new BSHLiteral(JJTLITERAL);
    boolean jjtc000 = true;
    jjtree.openNodeScope(jjtn000);
    jjtreeOpenNodeScope(jjtn000);
    Token x;
    boolean b;
    String literal;
    char ch;
    try {
        switch((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
            case INTEGER_LITERAL:
                x = jj_consume_token(INTEGER_LITERAL);
                jjtree.closeNodeScope(jjtn000, true);
                jjtc000 = false;
                jjtreeCloseNodeScope(jjtn000);
                literal = x.image;
                ch = literal.charAt(literal.length() - 1);
                if (ch == 'l' || ch == 'L') {
                    literal = literal.substring(0, literal.length() - 1);
                    // This really should be Long.decode, but there isn't one. As a result,
                    // hex and octal literals ending in 'l' or 'L' don't work.
                    jjtn000.value = new Primitive(Long.valueOf(literal).longValue());
                } else
                    try {
                        jjtn000.value = new Primitive(Integer.decode(literal).intValue());
                    } catch (NumberFormatException e) {
                        {
                            if (true)
                                throw createParseException("Error or number too big for integer type: " + literal);
                        }
                    }
                break;
            case FLOATING_POINT_LITERAL:
                x = jj_consume_token(FLOATING_POINT_LITERAL);
                jjtree.closeNodeScope(jjtn000, true);
                jjtc000 = false;
                jjtreeCloseNodeScope(jjtn000);
                literal = x.image;
                ch = literal.charAt(literal.length() - 1);
                if (ch == 'f' || ch == 'F') {
                    literal = literal.substring(0, literal.length() - 1);
                    jjtn000.value = new Primitive(Float.valueOf(literal).floatValue());
                } else {
                    if (ch == 'd' || ch == 'D')
                        literal = literal.substring(0, literal.length() - 1);
                    jjtn000.value = new Primitive(Double.valueOf(literal).doubleValue());
                }
                break;
            case CHARACTER_LITERAL:
                x = jj_consume_token(CHARACTER_LITERAL);
                jjtree.closeNodeScope(jjtn000, true);
                jjtc000 = false;
                jjtreeCloseNodeScope(jjtn000);
                try {
                    jjtn000.charSetup(x.image.substring(1, x.image.length() - 1));
                } catch (Exception e) {
                    {
                        if (true)
                            throw createParseException("Error parsing character: " + x.image);
                    }
                }
                break;
            case STRING_LITERAL:
                x = jj_consume_token(STRING_LITERAL);
                jjtree.closeNodeScope(jjtn000, true);
                jjtc000 = false;
                jjtreeCloseNodeScope(jjtn000);
                try {
                    jjtn000.stringSetup(x.image.substring(1, x.image.length() - 1));
                } catch (Exception e) {
                    {
                        if (true)
                            throw createParseException("Error parsing string: " + x.image);
                    }
                }
                break;
            case FALSE:
            case TRUE:
                b = BooleanLiteral();
                jjtree.closeNodeScope(jjtn000, true);
                jjtc000 = false;
                jjtreeCloseNodeScope(jjtn000);
                jjtn000.value = new Primitive(b);
                break;
            case NULL:
                NullLiteral();
                jjtree.closeNodeScope(jjtn000, true);
                jjtc000 = false;
                jjtreeCloseNodeScope(jjtn000);
                jjtn000.value = Primitive.NULL;
                break;
            case VOID:
                VoidLiteral();
                jjtree.closeNodeScope(jjtn000, true);
                jjtc000 = false;
                jjtreeCloseNodeScope(jjtn000);
                jjtn000.value = Primitive.VOID;
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