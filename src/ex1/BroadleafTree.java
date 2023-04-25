package ex1;

class BroadleafTree extends Tree {
    public BroadleafTree(int height) {
        super(height);
    }

    @Override
    public String getSegment(int segmentIndex) {
        if (segmentIndex == 0) {
            return " ^ ";

        } else if (segmentIndex % 2 == 1) {
            return "|/ ";
        } else {
            return "\\| ";
        }
    }
}
