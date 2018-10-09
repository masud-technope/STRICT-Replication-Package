//{{{ invoke() method
@Override
public void invoke(View view) {
    setLastMacro(this);
    if (view == null)
        handler.runMacro(null, this);
    else {
        try {
            view.getBuffer().beginCompoundEdit();
            handler.runMacro(view, this);
        } finally {
            view.getBuffer().endCompoundEdit();
        }
    }
//}}}
}