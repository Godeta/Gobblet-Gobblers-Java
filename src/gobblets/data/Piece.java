package gobblets.data;


//definie une pi�ce et prend sa taille en param�tre dans le constructeur
public class Piece {
	//chaque pi�ce a une taille et une couleur
	    private Couleur couleur;
	    private final Taille taille;

	    public Piece(Taille t) {
	        taille = t;
	    }

	    public Taille getTaille() {
	        return taille;
	    }

	    public Couleur getCouleur() {
	        return couleur;
	    }

	    public void setCouleur(Couleur c) {
	        couleur = c;
	    }

	    public String toString() {
	        return "Piece(taille="+taille+", couleur="+couleur+")";
	    }

	    //permet de copier une pi�ce
	    public Object clone() {
	        Piece p = new Piece(taille);
	        p.setCouleur(couleur);
	        return p;
	    }

	    //verifie si deux pi�ces sont equivalentes
	    public boolean equals(Object obj) {
	        if (this == obj)
	            return true;
	        if (obj == null)
	            return false;
	        if (getClass() != obj.getClass())
	            return false;
	        Piece other = (Piece) obj;
	        if (couleur != other.getCouleur())
	            return false;
	        if (taille != other.getTaille())
	            return false;
	        return true;
	    }
	    
	    
	}
