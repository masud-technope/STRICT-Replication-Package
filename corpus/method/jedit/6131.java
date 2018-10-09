//}}}
//{{{ getPrevFile() method
public String getPrevFile(View view, String file) {
    if (file == null)
        return view.getBuffer().getPath();
    else
        return null;
}