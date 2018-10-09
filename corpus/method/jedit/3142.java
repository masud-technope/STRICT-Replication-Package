//{{{ ColorChooserDialog
public  ColorChooserDialog(Window owner, Color initialColor) {
    super(owner);
    setModal(true);
    this.initialColor = initialColor;
    init();
}