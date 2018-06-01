public class Noeud {
    private String connaissance;
    private boolean M1;
    private boolean M2;


    public Noeud(String connaissance) {
        this.connaissance = connaissance;
        this.M1 = false;
        this.M2 = false;
    }

    public String getConnaissance() {
        return connaissance;
    }

    public void setConnaissance(String connaissance) {
        this.connaissance = connaissance;
    }

    public boolean isM1() {
        return M1;
    }

    public void setM1(boolean m1) {
        M1 = m1;
    }

    public boolean isM2() {
        return M2;
    }

    public void setM2(boolean m2) {
        M2 = m2;
    }

    @Override
    public String toString() {
        return " ( " + connaissance + " --> [M1 : " + M1 + "  M2 : " + M2 + "] )"
                ;
    }

//    @Override
//    public String toString() {
//        return " ( " + connaissance + " --> [M1 : "+M1 + "] )"
//                ;
//    }
}
