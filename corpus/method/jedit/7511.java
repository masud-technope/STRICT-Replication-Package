//}}}
//{{{ getOpenBuffers() method
private Set<Buffer> getOpenBuffers() {
    Set<Buffer> openBuffers = new LinkedHashSet<Buffer>();
    for (EditPane editPane : getEditPanes()) {
        openBuffers.addAll(Arrays.asList(editPane.getBufferSet().getAllBuffers()));
    }
    return openBuffers;
}