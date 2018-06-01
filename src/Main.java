public class Main {


    public static void main(String[] args) {

        Noeud noeud1 = new Noeud("animal");
        Noeud noeud2 = new Noeud("carnivor");
        Noeud noeud3 = new Noeud("herbivor");
        Noeud noeud4 = new Noeud("lion");
        Noeud noeud5 = new Noeud("chien");
        Noeud noeud6 = new Noeud("lapin");
        Noeud noeud7 = new Noeud("panda");
        Noeud noeud8 = new Noeud("rouge");
        Noeud noeud9 = new Noeud("blue");
        Noeud noeud10 = new Noeud("noir");
        Noeud noeud11 = new Noeud("blanc");



        Relation relation1 = new Relation(noeud2, "isA", noeud1);
        Relation relation2 = new Relation(noeud3, "isA", noeud1);
        Relation relation3 = new Relation(noeud4, "isA", noeud2);
        Relation relation4 = new Relation(noeud5, "isA", noeud2);
        Relation relation5 = new Relation(noeud6, "isA", noeud3);
        Relation relation6 = new Relation(noeud7, "isA", noeud3);
        Relation relation7 = new Relation(noeud4, "mange", noeud6);
        Relation relation8 = new Relation(noeud4, "mange", noeud7);


        Relation relation9 = new Relation(noeud4, "a_couleur", noeud8);
        Relation relation10 = new Relation(noeud1, "a_couleur", noeud11);
        Relation relation11 = new Relation(noeud2, "a_couleur", noeud10);


        Relation relation12 = new Relation(noeud2, "exception", noeud11);
        Relation relation13 = new Relation(noeud4, "exception", noeud10);


        Arbre network = new Arbre();

        network.addRelation(relation1);
        network.addRelation(relation2);
        network.addRelation(relation3);
        network.addRelation(relation4);
        network.addRelation(relation5);
        network.addRelation(relation6);
        network.addRelation(relation7);
        network.addRelation(relation8);
        network.addRelation(relation9);
        network.addRelation(relation10);
        network.addRelation(relation11);
        network.addRelation(relation12);
        network.addRelation(relation13);

        //network.diplay();
        /*network.marqeurM1(noeud1);
        network.marqeurM2(noeud6);
        System.out.println("Quel est l'animal qui mange les lapins\n");
        network.diplay();
        */
       /***********  Partie 1 ************/
       // network.marquer(noeud1, "mange", noeud1);

        /***********  Partie 2 ************/

        for (Relation r: network.heritage(noeud4) ) {
            r.displayRelation();
        }


        /************* partie 3 **************/
        for (Relation r: network.heritageWithException(noeud4) ) {
            r.displayRelation();
        }
    }
}
