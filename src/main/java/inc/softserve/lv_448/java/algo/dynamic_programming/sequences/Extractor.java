package inc.softserve.lv_448.java.algo.dynamic_programming.sequences;

public class Extractor {
    private final SeqGenerator seqGenerator;

    public Extractor(SeqGenerator seqGenerator) {
        this.seqGenerator = seqGenerator;
    }

    public int extract(int index){
        return seqGenerator.apply(index)
                .get(index);
    }
}
