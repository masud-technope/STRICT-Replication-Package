public final int NameList() throws ParseException {
    int count = 0;
    AmbiguousName();
    ++count;
    label_6: while (true) {
        switch((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
            case COMMA:
                ;
                break;
            default:
                break label_6;
        }
        jj_consume_token(COMMA);
        AmbiguousName();
        ++count;
    }
    {
        if (true)
            return count;
    }
    throw new Error("Missing return statement in function");
}