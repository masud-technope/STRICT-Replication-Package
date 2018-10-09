//}}}
//{{{ processKeyEvent() method
@Override
public void processKeyEvent(KeyEvent evt) {
    getInputHandler().processKeyEvent(/* source=TEXTAREA (1) */
    evt, 1, false);
    if (!evt.isConsumed())
        super.processKeyEvent(evt);
}