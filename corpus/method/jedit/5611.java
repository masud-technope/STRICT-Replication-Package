//}}}
//}}}
//{{{ Private members
//{{{ actionsPresentButNotCoreClass() method
private void actionsPresentButNotCoreClass() {
    Log.log(Log.WARNING, this, getPath() + " has an actions.xml but no plugin core class");
    actions.setLabel("MISSING PLUGIN CORE CLASS");
}