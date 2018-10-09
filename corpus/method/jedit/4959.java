//}}}
//{{{ invoke() method
public void invoke(TextArea textArea) {
    try {
        if (cachedCode == null) {
            String cachedCodeName = "action_" + sanitizedName;
            cachedCode = bsh.cacheBlock(cachedCodeName, code, true);
        }
        bsh.runCachedBlock(cachedCode, textArea, new NameSpace(bsh.getNameSpace(), "BeanShellAction.invoke()"));
    } catch (Throwable e) {
        Log.log(Log.ERROR, this, e);
    }
}