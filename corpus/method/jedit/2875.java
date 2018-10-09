//{{{ BufferSetManager constructor
public  BufferSetManager() {
    EditBus.addToBus(this);
    try {
        scope = BufferSet.Scope.valueOf(jEdit.getProperty("bufferset.scope", "global"));
    } catch (IllegalArgumentException e) {
        Log.log(Log.ERROR, this, e);
        scope = BufferSet.Scope.global;
    }
}