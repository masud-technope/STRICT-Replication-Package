//}}}
//{{{ Getters and setters
//{{{ setGutterEnabled() method
/* Enables showing or hiding the gutter. */
public void setGutterEnabled(boolean enabled) {
    this.enabled = enabled;
    revalidate();
}