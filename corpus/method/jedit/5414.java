//{{{ _save() method
@Override
protected void _save() {
    saveMode();
    global.save();
    for (ModeProperties modeProp : modeProps) {
        modeProp.save();
    }
}