// could refactor these a bit
private void validateForMethod() {
    insureNo("volatile", "Method");
    insureNo("transient", "Method");
}