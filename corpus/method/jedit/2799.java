//}}}
//{{{ notifyChange() method
private static void notifyChange() {
    EditBus.send(new DynamicMenuChanged("recent-files"));
}