public boolean repeatingSameMacro(String macroName) {
    InputHandler ih = jEdit.getActiveView().getInputHandler();
    EditAction lastAction = ih.getLastAction();
    int lastActionCount = ih.getLastActionCount();
    // When called from within a macro, the last action will be that macro.
    // But, if the last action count is greater than 1, then it's a repeat.
    boolean repeat = false;
    if ((lastAction.getName().equals(macroName)) && (lastActionCount > 1))
        repeat = true;
    return repeat;
}