public void registerChanged(char name) {
    EditBus.send(new RegisterChanged(null, name));
}