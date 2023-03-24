package ex1;

class PineTree extends Tree {
    PineTree(int height) {
        super(height);
    }

    @Override
    String getSegment(int i) {
        return "/|\\";
    }
}
