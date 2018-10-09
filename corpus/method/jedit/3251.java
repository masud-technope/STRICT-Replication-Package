//{{{ isSelected() method
public boolean isSelected(View view) {
    return view.getDockableWindowManager().isDockableWindowVisible(dockable);
//}}}
}