//}}}
public void goToBufferStart(boolean select) {
    EditBus.send(new PositionChanging(this));
    super.goToBufferStart(select);
}