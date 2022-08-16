import java.util.Scanner;

public class Metier
{
    private char[][] grille;

    public Metier()
    {
        this.grille = new char[][]{{'#', '#', '#'}, {'#', '#', '#'}, {'#', '#', '#'}};
    }

    public void ajouterSymbole(char symbole, int ligne, int colonne)
    {
        this.grille[ligne][colonne] = symbole;
    }

    public boolean conditionDeVictoire(char symbole)
    {
        //Ligne verticale
        if(this.grille[0][0] == symbole && this.grille[1][0] == symbole && this.grille[2][0] == symbole)
            return true;

        if(this.grille[0][1] == symbole && this.grille[1][1] == symbole && this.grille[2][1] == symbole)
            return true;

        if(this.grille[0][2] == symbole && this.grille[1][2] == symbole && this.grille[2][2] == symbole)
            return true;

        //Ligne horizontale
        if(this.grille[0][0] == symbole && this.grille[0][1] == symbole && this.grille[0][2] == symbole)
            return true;

        if(this.grille[1][0] == symbole && this.grille[1][1] == symbole && this.grille[1][2] == symbole)
            return true;

        if(this.grille[1][0] == symbole && this.grille[1][1] == symbole && this.grille[1][2] == symbole)
            return true;

        //Diagonale
        if(this.grille[0][0] == symbole && this.grille[1][1] == symbole && this.grille[2][2] == symbole)
            return true;

        if(this.grille[0][2] == symbole && this.grille[1][1] == symbole && this.grille[2][0] == symbole)
            return true;

        return false;
    }

    public char getCharTab(int ligne, int colonne)
    {
        return this.grille[ligne][colonne];
    }

    public String afficherTableau()
    {
        String message = "";

        for(char[] s1: grille)
        {
            for (char s2 : s1)
            {
                message += "|" + s2 + "|";
            }
            message += "\n";
        }

        return message;
    }

    public static void main(String[] args)
    {
        Metier m1 = new Metier();
        Scanner sc = new Scanner(System.in);
        Joueur joueur1 = new Joueur(null,'X');
        Joueur joueur2 = new Joueur(null,'O');

        int ligne;
        int colonne;
        boolean tour = false;
        Joueur joueurCourant = new Joueur(null, 'A');

        System.out.println(m1.afficherTableau());

        System.out.println("Bonjour et bienvenue sur le Morpion !");
        System.out.println("Joueur numéro 1 choissisez votre nom : ");
        joueur1.setNom(sc.nextLine());


        System.out.println("Joueur numéro 2 choissisez votre nom : ");
        joueur2.setNom(sc.nextLine());


        while(m1.conditionDeVictoire(joueur1.getSymbole()) == false || m1.conditionDeVictoire(joueur1.getSymbole()) == false)
        {
            //Changement de joueur
            if(tour == false)
            {
                joueurCourant.setNom(joueur1.getNom());
                joueurCourant.setSymbole(joueur1.getSymbole());
            }
            else
            {
                joueurCourant.setNom(joueur2.getNom());
                joueurCourant.setSymbole(joueur2.getSymbole());
            }

            //Refaire si le joueur essaye de jouer sur une case déjà utilisé
            do
            {
                System.out.println(m1.afficherTableau());

                System.out.println(joueurCourant.getNom() + " numéro de ligne ?");
                ligne = Integer.parseInt(sc.nextLine())-1;
                System.out.println(joueurCourant.getNom() + " numéro de colonne ?");
                colonne = Integer.parseInt(sc.nextLine())-1;

            } while(m1.getCharTab(ligne,colonne) == joueur1.getSymbole() || m1.getCharTab(ligne,colonne) == joueur2.getSymbole());

            m1.ajouterSymbole(joueurCourant.getSymbole(), ligne, colonne);

            tour = !tour;
        }
        System.out.println(joueurCourant.getNom() + " a gagné ! ");
    }
}
