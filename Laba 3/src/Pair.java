public class Pair <F,S>{
    private F first;
    private S second;
    public Pair(F first, S second){
        this.first = first;
        this.second = second;
    }
    public F getFirst(){
        return first;
    }
    public S getSecond(){
        return second;
    }
    public String toString(){
        return "Pair{" + "first=" + first + ", second=" + second + '}';
    }


    public boolean equals(Pair<F, S> otherPair) {
        if (otherPair == null) {
            return false;
        } else {
            return this.first.equals(otherPair.getFirst()) &&
                this.second.equals(otherPair.getSecond());
        }
    }
}
