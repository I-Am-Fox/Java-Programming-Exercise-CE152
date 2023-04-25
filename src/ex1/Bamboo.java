package ex1;

class Bamboo extends Tree {
    Bamboo(int height) {
        super(height);
    }

    @Override
    public String getSegment(int segmentIndex) {
        if (segmentIndex == 0) {
            return " ^ ";
        } else {
            return " | ";
        }
    }
}