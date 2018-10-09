// ButtonGroup should have this
public  MyButtonGroup(AbstractButton... buttons) {
    super();
    for (AbstractButton b : buttons) {
        super.add(b);
    }
}