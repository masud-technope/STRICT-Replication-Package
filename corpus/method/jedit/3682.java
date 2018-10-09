//}}}
//{{{ invokeLastAction() method
public void invokeLastAction() {
    if (lastAction == null)
        javax.swing.UIManager.getLookAndFeel().provideErrorFeedback(null);
    else
        invokeAction(lastAction);
}