package ex1;

public class BroadleafTree extends Tree{
    BroadleafTree(int height) {
        super(height);
    }

     @Override
    String getSegment(int i) {
        return "|/\n\\|";
    }
}
