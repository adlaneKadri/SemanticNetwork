import java.util.ArrayList;

public class Arbre {

    private ArrayList<Relation> relations = new ArrayList<>();

    public boolean addRelation(Relation relation) {
        return relations.add(relation);
    }

    private boolean removeRelation(Relation relation) {
        return relations.remove(relation);
    }

    public void diplay() {
        for (Relation relation : relations
                ) {
            System.out.println(relation);
        }
    }


    /************************************  PARTIE  01 ********************************/
    private void marqeurM1(Noeud noeud) {

        ArrayList<Noeud> file = new ArrayList<>();
        file.add(noeud);


        while (!file.isEmpty()) {
            Noeud noeud1 = file.remove(0);
            noeud1.setM1(true);

            for (Relation relation : relations) {
                if (relation.getNoeudArrive().getConnaissance().equals(noeud1.getConnaissance())
                        && relation.getRelation().equals("isA")) {

                    relation.getNoeudDepart().setM1(true);
                    file.add(relation.getNoeudDepart());


                }

            }
        }
    }

    private void marqeurM2(Noeud noeud1) {

        ArrayList<Noeud> file = new ArrayList<>();
        file.add(noeud1);


        while (!file.isEmpty()) {
            Noeud noeud = file.remove(0);
            noeud.setM2(true);

            for (Relation relation1 : relations) {
                if (relation1.getNoeudArrive().getConnaissance().equals(noeud.getConnaissance())
                        && relation1.getRelation().equals("isA")) {

                    relation1.getNoeudDepart().setM2(true);
                    file.add(relation1.getNoeudDepart());


                }

            }
        }
    }

    public void marquer(Noeud noeudDepart, String relation, Noeud noeudArriver) {
        marqeurM1(noeudDepart);
        marqeurM2(noeudArriver);
        boolean answerExiste = false;
        for (Relation r : getRelations(relation)) {
            if (r.getNoeudDepart().isM1() && r.getNoeudArrive().isM2()) {
                System.out.println(r);
                answerExiste = true;
            }
        }

        if (!answerExiste) System.out.println("aucune réponse n'est fournie");

    }

    private ArrayList<Relation> getRelations(String relation) {
        ArrayList<Relation> setRelation = new ArrayList<>();

        for (Relation r : relations) {
            if (r.getRelation().equals(relation))
                setRelation.add(r);
        }

        return setRelation;
    }

    /************************************  PARTIE  02 ********************************/

    public ArrayList<Relation> heritage(Noeud noeud) {
        ArrayList<Relation> r = new ArrayList<>();
        ArrayList<Noeud> file = new ArrayList<>();
        ArrayList<Noeud> pile = new ArrayList<>();

        file.add(noeud);
        for (Relation relat: getNoeudCaractere(noeud) ) {
            r.add(new Relation(noeud, relat.getRelation(), relat.getNoeudArrive()));
        }

        while (!file.isEmpty()) {
            Noeud noeud1 = file.remove(0);

                pile.add(noeud1);

                for (Relation relation : relations) {
                if (relation.getNoeudDepart().getConnaissance().equals(noeud1.getConnaissance())
                        && relation.getRelation().equals("isA")) {
                    file.add(relation.getNoeudArrive());
                    for (Relation rel: getNoeudCaractere(relation.getNoeudArrive())) {
                        r.add(new Relation(noeud, rel.getRelation(), rel.getNoeudArrive()));
                    }
                }
            }

        }

        return r;
    }

    public ArrayList<Relation> getNoeudCaractere(Noeud noeud) {
        ArrayList<Relation> r = new ArrayList<>();
        for (Relation relation: relations ) {
            if (relation.getNoeudDepart().getConnaissance().equals(noeud.getConnaissance())
                    && !relation.getRelation().equals("isA") && !relation.getRelation().equals("exception")){

                r.add(relation);
            }
        }
        return  r;
    }


    /************************************  PARTIE  03 ********************************/

    public ArrayList<Relation> heritageWithException(Noeud noeud){

        ArrayList<Relation> r = new ArrayList<>();
        ArrayList<Noeud> heritage = new ArrayList<>();

        heritage.add(noeud);
        boolean premier = true;

        while (premier){
            if(getPere(heritage.get(heritage.size() - 1)).isEmpty()){
                premier = false;
            }else{
                heritage.addAll(getPere(heritage.get(heritage.size() - 1)));
            }
        }


        while(!heritage.isEmpty()){
            r = removeException(r,getException(heritage.get(heritage.size() - 1)));
            r.addAll(getNoeudCaractere(heritage.get(heritage.size() - 1)));
            heritage.remove(heritage.size() - 1);
        }

        ArrayList<Relation> resulat = new ArrayList<>();

        for (Relation rel : r ){
            resulat.add(new Relation(noeud, rel.getRelation(), rel.getNoeudArrive()));
        }


        return resulat;
    }

    public ArrayList<Relation> removeException(ArrayList<Relation> relations,ArrayList<Noeud> exception){
        ArrayList<Relation> newRelation = new ArrayList<>();
        for (Relation r : relations){
            if(!exception.contains(r.getNoeudArrive())){
                newRelation.add(r);
            }
        }

        return newRelation;
    }

    public ArrayList<Noeud> getPere(Noeud noeud){
        ArrayList<Noeud> peres = new ArrayList<>();

        for (Relation r : relations){
            if(r.getNoeudDepart() == noeud){
                if (r.getRelation().equals("isA")){
                    peres.add(r.getNoeudArrive());
                }
            }
        }

        return peres;
    }

    public ArrayList<Noeud> getException(Noeud noeud){
        ArrayList<Noeud> exceptions = new ArrayList<>();

        for (Relation r : relations){
            if(r.getNoeudDepart() == noeud){
                if (r.getRelation().equals("exception")){
                    exceptions.add(r.getNoeudArrive());
                }
            }
        }

        return exceptions;
    }
}
