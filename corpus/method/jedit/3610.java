//}}}
//{{{ insertElementAt() method
@Override
public void insertElementAt(String obj, int index) {
    modified = true;
    super.insertElementAt(obj, index);
}