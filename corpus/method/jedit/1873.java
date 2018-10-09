public final void LabeledStatement() throws ParseException {
    jj_consume_token(IDENTIFIER);
    jj_consume_token(COLON);
    Statement();
}