//}}}
//{{{ _delete() method
@Override
public boolean _delete(Object session, String path, Component comp) {
    synchronized (lock) {
        path = path.substring(PROTOCOL.length() + 1);
        Iterator<Favorite> iter = favorites.iterator();
        while (iter.hasNext()) {
            if (iter.next().getPath().equals(path)) {
                iter.remove();
                VFSManager.sendVFSUpdate(this, PROTOCOL + ':', false);
                EditBus.sendAsync(new DynamicMenuChanged("favorites"));
                return true;
            }
        }
    }
    return false;
}