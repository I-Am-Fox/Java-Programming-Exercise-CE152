package ex1;

class PineTree extends Tree {
    PineTree(int height) {
        super(height);
    }

    @Override
    public String getSegment(int segmentIndex) {
        if (segmentIndex == 0) {
            return " ^ ";
        } else {
            return "/|\\";
        }
    }
}
