package ex1;

class Bamboo extends Tree {
    Bamboo(int height) {
        super(height);
    }

    @Override
    String getSegment(int i) {
        return "|";
    }
}