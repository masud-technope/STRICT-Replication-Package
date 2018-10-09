 BufferSetWidget() {
    bufferSetLabel = new ToolTipLabel() {

        @Override
        public void addNotify() {
            super.addNotify();
            BufferSetWidget.this.update();
            EditBus.addToBus(BufferSetWidget.this);
        }

        @Override
        public void removeNotify() {
            super.removeNotify();
            EditBus.removeFromBus(BufferSetWidget.this);
        }
    };
    update();
    bufferSetLabel.addMouseListener(new MouseAdapter() {

        @Override
        public void mouseClicked(MouseEvent evt) {
            if (evt.getClickCount() == 2) {
                BufferSetManager bufferSetManager = jEdit.getBufferSetManager();
                BufferSet.Scope scope = bufferSetManager.getScope();
                switch(scope) {
                    case global:
                        scope = BufferSet.Scope.view;
                        break;
                    case view:
                        scope = BufferSet.Scope.editpane;
                        break;
                    case editpane:
                        scope = BufferSet.Scope.global;
                        break;
                }
                bufferSetManager.setScope(scope);
            }
        }
    });
}