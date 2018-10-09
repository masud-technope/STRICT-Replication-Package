public void actionPerformed(ActionEvent evt) {
    Object source = evt.getSource();
    if (source == selectAll) {
        // to handle this right now.
        try {
            selectAllFlag = true;
            bufferList.setSelectionInterval(0, bufferModel.getSize() - 1);
        } finally {
            selectAllFlag = false;
        }
        bufferList.requestFocus();
    } else if (source == save) {
        java.util.List<String> paths = bufferList.getSelectedValuesList();
        for (String path : paths) {
            Buffer buffer = jEdit.getBuffer(path);
            if (!buffer.save(view, null, true, true))
                return;
            TaskManager.instance.waitForIoTasks();
            if (buffer.getBooleanProperty(BufferIORequest.ERROR_OCCURRED))
                return;
            jEdit._closeBuffer(view, buffer);
            bufferModel.removeElement(path);
        }
        if (bufferModel.getSize() == 0) {
            ok = true;
            dispose();
        } else {
            bufferList.setSelectedIndex(0);
            bufferList.requestFocus();
        }
    } else if (source == discard) {
        java.util.List<String> paths = bufferList.getSelectedValuesList();
        for (String path : paths) {
            Buffer buffer = jEdit.getBuffer(path);
            jEdit._closeBuffer(view, buffer);
            bufferModel.removeElement(path);
        }
        if (bufferModel.getSize() == 0) {
            ok = true;
            dispose();
        } else {
            bufferList.setSelectedIndex(0);
            bufferList.requestFocus();
        }
    } else if (source == cancel)
        cancel();
}