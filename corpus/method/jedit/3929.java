//}}}
//{{{ handleRegisterChanged() method
@EBHandler
public void handleRegisterChanged(RegisterChanged msg) {
    if (msg.getRegisterName() != '%')
        refreshList();
}