//}}}
//{{{ getFilePath() method
@Override
public String getFilePath(String vfsPath) {
    try {
        return new URL(vfsPath).getPath();
    } catch (MalformedURLException mue) {
        Log.log(Log.ERROR, this, mue);
        return super.getFilePath(vfsPath);
    }
}