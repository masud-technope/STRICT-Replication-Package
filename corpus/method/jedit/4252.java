//{{{ componentMoved() method
@Override
public void componentMoved(ComponentEvent ce) {
    final Rectangle bounds = frame.getBounds();
    final Runnable sizeSaver = new Runnable() {

        @Override
        public void run() {
            EventQueue.invokeLater(new Runnable() {

                @Override
                public void run() {
                    save(frame.getExtendedState(), bounds);
                }
            });
        }
    };
    cancelResizeSave();
    resizeDelayFuture = schedExecutor.schedule(sizeSaver, 500, TimeUnit.MILLISECONDS);
//}}}
}