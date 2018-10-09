//}}}
//{{{ getNextFile() method
public String getNextFile(View view, String file) {
    if (file == null)
        return view.getBuffer().getPath();
    else
        return null;
}