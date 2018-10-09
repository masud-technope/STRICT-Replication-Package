//}}}
//{{{ moveAllToRight() method
public void moveAllToRight() {
    rightModel.addAll(leftModel.data);
    leftModel.clear();
}