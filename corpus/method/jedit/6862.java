//}}}
//{{{ mousePressed() method
@Override
public void mousePressed(MouseEvent evt) {
    super.mousePressed(evt);
    EditBus.send(new PositionChanging(textArea));
}