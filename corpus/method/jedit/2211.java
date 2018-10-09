public void ReInit(JavaCharStream stream, int lexState) {
    ReInit(stream);
    SwitchTo(lexState);
}