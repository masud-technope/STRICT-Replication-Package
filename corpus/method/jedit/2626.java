//}}}
//{{{ insertElementAt() method
@Override
public void insertElementAt(String value, int index) {
    /* This is not terribly efficient, but this method is only
		called by the 'Paste Deleted' dialog where the performance
		is not exactly vital */
    remove(index);
    add(value);
}