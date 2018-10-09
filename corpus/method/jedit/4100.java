//{{{ addNotify() method
@Override
public void addNotify() {
    super.addNotify();
    visible = true;
    textArea.addCaretListener(this);
//}}}
}