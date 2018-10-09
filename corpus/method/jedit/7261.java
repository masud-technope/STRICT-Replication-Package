//}}}
//{{{ getInputMethodRequests() method
@Override
public InputMethodRequests getInputMethodRequests() {
    if (inputMethodSupport == null) {
        inputMethodSupport = new InputMethodSupport(this);
        Log.log(Log.DEBUG, this, "InputMethodSupport is activated");
    }
    return inputMethodSupport;
}