public final int AssignmentOperator() throws ParseException {
    Token t;
    switch((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
        case ASSIGN:
            jj_consume_token(ASSIGN);
            break;
        case STARASSIGN:
            jj_consume_token(STARASSIGN);
            break;
        case SLASHASSIGN:
            jj_consume_token(SLASHASSIGN);
            break;
        case MODASSIGN:
            jj_consume_token(MODASSIGN);
            break;
        case PLUSASSIGN:
            jj_consume_token(PLUSASSIGN);
            break;
        case MINUSASSIGN:
            jj_consume_token(MINUSASSIGN);
            break;
        case ANDASSIGN:
            jj_consume_token(ANDASSIGN);
            break;
        case XORASSIGN:
            jj_consume_token(XORASSIGN);
            break;
        case ORASSIGN:
            jj_consume_token(ORASSIGN);
            break;
        case LSHIFTASSIGN:
            jj_consume_token(LSHIFTASSIGN);
            break;
        case LSHIFTASSIGNX:
            jj_consume_token(LSHIFTASSIGNX);
            break;
        case RSIGNEDSHIFTASSIGN:
            jj_consume_token(RSIGNEDSHIFTASSIGN);
            break;
        case RSIGNEDSHIFTASSIGNX:
            jj_consume_token(RSIGNEDSHIFTASSIGNX);
            break;
        case RUNSIGNEDSHIFTASSIGN:
            jj_consume_token(RUNSIGNEDSHIFTASSIGN);
            break;
        case RUNSIGNEDSHIFTASSIGNX:
            jj_consume_token(RUNSIGNEDSHIFTASSIGNX);
            break;
        default:
            jj_consume_token(-1);
            throw new ParseException();
    }
    t = getToken(0);
    {
        if (true)
            return t.kind;
    }
    throw new Error("Missing return statement in function");
}