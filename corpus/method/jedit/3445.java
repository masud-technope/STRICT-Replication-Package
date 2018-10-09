// This enables users to copy the error messages to
// clipboard with Ctrl+C on Windows. But it works only
// if the entry is selected by a mouse click.
public String toString() {
    return path + ":\n" + TextUtilities.join(java.util.Arrays.asList(messages), "\n");
}