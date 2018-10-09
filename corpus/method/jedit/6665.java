//}}}
//{{{ setDirtyStatus() method
public void setDirtyStatus(boolean status) {
    synchronized (buffer.columnBlockLock) {
        isDirty = status;
    }
}