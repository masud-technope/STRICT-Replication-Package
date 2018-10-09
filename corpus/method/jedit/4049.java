 LastModifiedWidget(View view) {
    this.view = view;
    lastModifiedLabel = new JLabel() {

        @Override
        public void addNotify() {
            super.addNotify();
            LastModifiedWidget.this.update();
            EditBus.addToBus(LastModifiedWidget.this);
        }

        @Override
        public void removeNotify() {
            super.removeNotify();
            EditBus.removeFromBus(LastModifiedWidget.this);
        }
    };
    lastModifiedLabel.setToolTipText(jEdit.getProperty("fileprop.lastmod"));
    update();
}