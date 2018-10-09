private void validateForClass() {
    // volatile, transient
    validateForMethod();
    insureNo("native", "Class");
    insureNo("synchronized", "Class");
}