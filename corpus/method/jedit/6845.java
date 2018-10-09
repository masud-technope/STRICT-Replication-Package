// }}}
// {{{ replaceSelection(String)
@Override
public int replaceSelection(String selectedText) {
    EditBus.send(new PositionChanging(this));
    return super.replaceSelection(selectedText);
}