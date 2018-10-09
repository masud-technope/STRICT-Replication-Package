//}}}
public TabExpander getTabExpander() {
    if (buffer.getBooleanProperty("elasticTabstops")) {
        return elasticTabstopsExpander;
    } else {
        return painter;
    }
}