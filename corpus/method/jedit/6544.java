//}}}
//{{{ isCommentOrLiteral() method
/**
	 * @return true for COMMENTx and LITERALx tokens 
	 */
public static boolean isCommentOrLiteral(byte id) {
    switch(id) {
        case Token.COMMENT1:
        case Token.COMMENT2:
        case Token.COMMENT3:
        case Token.COMMENT4:
        case Token.LITERAL1:
        case Token.LITERAL2:
        case Token.LITERAL3:
        case Token.LITERAL4:
            return true;
        default:
            return false;
    }
}