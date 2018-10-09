//}}}
//{{{ moveAllToLeft() method
public void moveAllToLeft() {
    leftModel.addAll(rightModel.data);
    rightModel.clear();
}