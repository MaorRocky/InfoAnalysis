public class V3_condition implements condition {
    private int threshold;
    private int diagonalLevel;
    private final int condVer = 3;

    @Override
    public boolean applyCondition(Image img) {
        int sum = 0;
        int i;
        int j;
        if (diagonalLevel<0){
            i = -1 * diagonalLevel;
            j = 0;
        } else {
            i = 0;
            j = diagonalLevel;
        }
        while (i<= 27 && j<= 27){
            sum = sum + img.getPixelAt(i,j);
            i++;
            j++;
        }

        return (sum/28-Math.abs(diagonalLevel)) > threshold;
    }

    public V3_condition(int threshold, int diagonalLevel) {
        this.threshold = threshold;
        this.diagonalLevel = diagonalLevel;
    }

    public String toString(){
        return condVer+"!"+threshold+"!"+diagonalLevel;
    }

    public static condition fromString(String[] cond){
        return new V3_condition(Integer.parseInt(cond[0]),Integer.parseInt(cond[1]));
    }
}
