//{{{ removeNotify() method
@Override
public void removeNotify() {
    visible = false;
    textArea.removeCaretListener(this);
    super.removeNotify();
//}}}
}