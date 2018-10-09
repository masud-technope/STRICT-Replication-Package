private void updateRegisterSafely() {
    try {
        editing = true;
        updateRegister();
    } finally {
        editing = false;
    }
}