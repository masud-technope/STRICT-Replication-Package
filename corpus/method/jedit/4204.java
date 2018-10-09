//}}}
@Override
public /** Update tooltip to reflect the window titles currently available. */
void handleMessage(EBMessage message) {
    if (message instanceof EditPaneUpdate && (((EditPaneUpdate) message).getWhat() == EditPaneUpdate.BUFFER_CHANGED)) {
        StringList sl = new StringList();
        for (View v : jEdit.getViews()) sl.add(v.getTitle());
        setToolTip(sl.join(" | "));
    }
}