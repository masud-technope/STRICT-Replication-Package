//}}}
//{{{ save() method
public void save() {
    for (int i = 0; i < windows.size(); i++) {
        ((Entry) windows.get(i)).save();
    }
}