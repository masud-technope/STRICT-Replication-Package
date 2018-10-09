//}}}
//{{{ applyMode() method
private static void applyMode(Mode mode, JEditBuffer buffer) {
    if (mode != null && "text".equals(buffer.getMode().getName()) && !mode.equals(buffer.getMode()) && buffer.getLength() == 0) {
        buffer.setMode(mode);
    }
}