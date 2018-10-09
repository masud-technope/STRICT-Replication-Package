//{{{ run() method
@Override
public void _run() {
    try {
        setStatus(jEdit.getProperty("options.plugin-manager.workthread"));
        setMaximum(3L);
        setValue(0L);
        final List<MirrorList.Mirror> mirrors = new ArrayList<MirrorList.Mirror>();
        try {
            MirrorList mirrorList = new MirrorList(download, this);
            if (download)
                saveMirrorList(mirrorList.getXml());
            mirrors.addAll(mirrorList.getMirrors());
        } catch (final Exception ex) {
            if (download) {
                Log.log(Log.ERROR, this, ex);
                ThreadUtilities.runInDispatchThread(new Runnable() {

                    public void run() {
                        GUIUtilities.error(PluginManagerOptionPane.this, "ioerror", new String[] { ex.toString() });
                    }
                });
            }
        }
        ThreadUtilities.runInDispatchThread(new Runnable() {

            public void run() {
                miraModel.setList(mirrors);
                String id = jEdit.getProperty("plugin-manager.mirror.id");
                int size = miraModel.getSize();
                for (int i = 0; i < size; i++) {
                    if (size == 1 || miraModel.getID(i).equals(id)) {
                        miraList.setSelectedIndex(i);
                        break;
                    }
                }
                if (size == 0) {
                    miraList.clearSelection();
                }
            }
        });
        setValue(3L);
    } finally {
        ThreadUtilities.runInDispatchThread(new Runnable() {

            public void run() {
                updateMirrors.setEnabled(true);
                updateStatus.setText(null);
            }
        });
    }
//}}}
}