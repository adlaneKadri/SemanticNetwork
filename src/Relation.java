public class Relation {

    private Noeud noeudDepart;
    private Noeud noeudArrive;
    private String relation;


    public Relation(Noeud noeudDepart, String relation, Noeud noeudArrive) {
        this.noeudDepart = noeudDepart;
        this.relation = relation;
        this.noeudArrive = noeudArrive;
    }

    public Noeud getNoeudDepart() {
        return noeudDepart;
    }

    public void setNoeudDepart(Noeud noeudDepart) {
        this.noeudDepart = noeudDepart;
    }

    public Noeud getNoeudArrive() {
        return noeudArrive;
    }

    public void setNoeudArrive(Noeud noeudArrive) {
        this.noeudArrive = noeudArrive;
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    @Override
    public String toString() {
        return "" + noeudDepart +
                " " + relation +
                "  " + noeudArrive
                ;
    }

    public void display(){
        System.out.println(this);
    }

    public void displayRelation(){
        System.out.println(noeudDepart.getConnaissance()+ " : "+relation+" : "+noeudArrive.getConnaissance());
    }

}
