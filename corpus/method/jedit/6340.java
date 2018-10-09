//}}}
//{{{ handleSearchSettingsChanged() method
@EBHandler
public void handleSearchSettingsChanged(EBMessage msg) {
    if (!saving)
        load();
}