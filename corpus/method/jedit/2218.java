public void SwitchTo(int lexState) {
    if (lexState >= 1 || lexState < 0)
        throw new TokenMgrError("Error: Ignoring invalid lexical state : " + lexState + ". State unchanged.", TokenMgrError.INVALID_LEXICAL_STATE);
    else
        curLexState = lexState;
}