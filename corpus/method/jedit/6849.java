//}}}
// }}}
// {{{ overrides from the base class that are EditBus  aware
public void goToBufferEnd(boolean select) {
    EditBus.send(new PositionChanging(this));
    super.goToBufferEnd(select);
}