//}}}
//{{{ queueTOCReload() method
@Override
public void queueTOCReload() {
    EventQueue.invokeLater(new Runnable() {

        @Override
        public void run() {
            queuedTOCReload = false;
            toc.load();
        }
    });
}