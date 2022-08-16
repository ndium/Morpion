public class Metier
{
    private char[][] grille;

    public Metier()
    {
        this.grille = new char[][]{{'#', '#', '#'}, {'#', '#', '#'}, {'#', '#', '#'}};
    }

    public void ajouterSymbole(char symbole, int positionX, int positionY)
    {
        this.grille[positionX][positionY] = symbole;
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

    public char getCharTab(int positionX, int positionY)
    {
        return this.grille[positionX][positionY];
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
        System.out.println(m1.afficherTableau());

        m1.ajouterSymbole('O',0,0);
        m1.ajouterSymbole('O',1,0);
        m1.ajouterSymbole('O',2,0);

        System.out.println(m1.afficherTableau());

        System.out.println(m1.conditionDeVictoire('O'));
    }
}
