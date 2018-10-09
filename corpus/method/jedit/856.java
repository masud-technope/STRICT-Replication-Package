//}}}
@Override
protected JTableHeader createDefaultTableHeader() {
    /**
		 * Set up column hook in a way that it survives switching of LAF
		 * */
    JTableHeader header = new JTableHeader(getColumnModel()) {

        ColumnDragHook hook;

        @Override
        public void updateUI() {
            if (hook != null) {
                hook.uninstallHook();
                hook = null;
            }
            super.updateUI();
            hook = new ColumnDragHook(this);
        }
    };
    return header;
}