package gobblets.ihm.texte;

import java.io.Serializable;
import java.util.Scanner;

import gobblets.data.ActionType;
import gobblets.data.Couleur;
import gobblets.data.Joueur;
import gobblets.data.JoueurHumain;
import gobblets.data.JoueurIA;
import gobblets.data.Taille;
import gobblets.ihm.Avertissement;
import gobblets.ihm.IHM;

public class SaisieConsole extends IHM implements Serializable {
    private transient final static Scanner sc = new Scanner(System.in);
    public SaisieConsole() { }

    public Joueur saisirJoueur(int n) throws Exception {
        System.out.println(getLanguage().avertissement(Avertissement.SAISIEJOUEUR)+n);
        Joueur j = null;
        System.out.println(getLanguage().avertissement(Avertissement.CHOIXTYPEJOUEUR));
        System.out.println("1 : "+getLanguage().avertissement(Avertissement.JOUEURHUMAIN)+
        		" | 2 : "+getLanguage().avertissement(Avertissement.JOUEURIA)+" | "+getLanguage().avertissement(Avertissement.AUTRE)+ " :" +
        		getLanguage().avertissement(Avertissement.ANNULER));
        int choice = 0;
        try {
            choice = Integer.parseInt(sc.nextLine());
        } catch (Exception e) {
            // Annuler Saisie joueur
            throw new Exception("annulation saisie.");
        }
        try {
            switch (choice) {
                case 1:
                    j = saisieJoueurHumain();
                    break;

                case 2:
                    j = saisieJoueurIA();
                    break;

                default:
                    throw new Exception("Pas de type joueur.");
            }
        } catch (Exception e) {
            System.out.println("Erreur : " + e + " ... Annulation saisie joueur");
            throw new Exception("annulation saisie.");
        }
        return j;
    }

    private JoueurIA saisieJoueurIA() throws Exception {
        String nom = "SUPER ORDINATEUR";
        System.out.println(getLanguage().avertissement(Avertissement.NOMJOUEUR) + " : " + nom);
        Couleur couleur;
        System.out.println(getLanguage().avertissement(Avertissement.COULEURJOUEUR) + " : ");
        String s = "";
        for (int i = 0; i < Couleur.values().length; i++) {
            s += i + 1 + " : " + couleur(Couleur.values()[i]) + "   ";
        }
        s += " | "+getLanguage().avertissement(Avertissement.AUTRE)+ " : "+getLanguage().avertissement(Avertissement.ANNULER);
        System.out.println(s);
        String in = sc.nextLine();
        switch (in) {
            case "1":
                couleur = Couleur.ROUGE;
                break;

            case "2":
                couleur = Couleur.VERT;
                break;

            case "3":
                couleur = Couleur.JAUNE;
                break;

            case "4":
                couleur = Couleur.BLEU;
                break;

            case "5":
                couleur = Couleur.BLANC;
                break;

            default:
                throw new Exception("Pas de couleur choisie.");
        }
        return new JoueurIA(nom, couleur);
    }

    private JoueurHumain saisieJoueurHumain() throws Exception {
        System.out.println(getLanguage().avertissement(Avertissement.NOMJOUEUR) + " : ");
        String nom;
        nom = sc.nextLine();
        Couleur couleur;
        System.out.println(getLanguage().avertissement(Avertissement.COULEURJOUEUR) + " : ");
        String s = "";
        for (int i = 0; i < Couleur.values().length; i++) {
            s += i+1 + " : " + couleur(Couleur.values()[i]) + "   ";
        }
        s += " | "+getLanguage().avertissement(Avertissement.AUTRE)+ " :"+getLanguage().avertissement(Avertissement.ANNULER);
        System.out.println(s);
        String in = sc.nextLine();
        switch (in) {
            case "1":
                couleur = Couleur.ROUGE;
                break;

            case "2":
                couleur = Couleur.VERT;
                break;

            case "3":
                couleur = Couleur.JAUNE;
                break;

            case "4":
                couleur = Couleur.BLEU;
                break;

            case "5":
                couleur = Couleur.BLANC;
                break;
            default:
                throw new Exception("Pas de couleur choisie.");
        }
        return new JoueurHumain(nom, couleur, this);
    }

    
    public Taille saisirTaille() throws Exception {
        System.out.println(getLanguage().avertissement(Avertissement.CHOIXTAILLE));
        String s = "";
        for (int i = 0; i < Taille.values().length; i++) {
            s += i+1 + " : " + super.getLanguage().taille(Taille.values()[i]) + "   ";
        }
        s += " | "+getLanguage().avertissement(Avertissement.AUTRE)+ " : "+getLanguage().avertissement(Avertissement.ANNULER);
        System.out.println(s);
        String in = sc.nextLine();
        switch (in) {
            case "1": return Taille.PETITE;
            case "2": return Taille.MOYENNE;
            case "3": return Taille.GRANDE;
            default: throw new Exception("annulation action");
        }
    }

    public int[] saisirCoordonnees() {
        int[] coord = new int[2];
        System.out.println(getLanguage().avertissement(Avertissement.SAISIECOORDONNEES) + "(0->2) : ");
        Integer in = null;
        for (int i = 0; i < coord.length; i++) {
            do {
                System.out.println((i==0 ? getLanguage().avertissement(Avertissement.SAISIELIGNE):getLanguage().avertissement(Avertissement.SAISIECOLONNE)));
                String s = sc.nextLine();
                try {
                    in = Integer.parseInt(s);
                } catch (Exception e) {
                    System.out.println("Erreur : " + e + " Veuillez entrer une valeur correcte.");
                }
            } while (in == null);
            coord[i] = in;
        }
        return coord;
    }

    public static String colorString(String s, Couleur c) throws Exception {
        if (s == null) throw new Exception("Pas de String.");
        if (c == null) throw new Exception("Pas de couleur");
        String color = "\u001B[38;2;"+c.getR()+";"+c.getG()+";"+c.getB()+"m";
        return color + s + "\u001B[m";
    }

    private String displayHouse(Joueur j) {
        String houseDis = "";
        Piece pTxt;
        for (Object o : j.getPieces().toArray()) {
            pTxt = new Piece((gobblets.data.Piece)o);
            houseDis += " " + pTxt.getRepresentationTextuelle();
        }
        return houseDis;
    }

    public void display(gobblets.data.Plateau p, Joueur j) {
        try {
            System.out.println(getLanguage().avertissement(Avertissement.NOMJOUEUR) + " : " + colorString(" "+j.getNom()+" ", j.getCouleur()));
            System.out.println(getLanguage().avertissement(Avertissement.MAISON) + " : " + displayHouse(j));
            Plateau pl = new Plateau(p);
            System.out.print(pl.getRepresentationTextuelle());;
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public ActionType saisirAction(Joueur j) throws Exception {
        System.out.println(getLanguage().avertissement(Avertissement.CHOIXACTION));
        String s = "";
        for (int i = 0; i < ActionType.values().length; i++) {
            s += i+1 + " : " + action(ActionType.values()[i]) + "   ";
        }
        s += " | "+getLanguage().avertissement(Avertissement.AUTRE)+ " : "+getLanguage().avertissement(Avertissement.ANNULER);
        System.out.println(s);
        String in = sc.nextLine();
        switch (in) {
            case "1": return ActionType.PLACER;
            case "2": return ActionType.DEPLACER;
            case "3": return ActionType.ENREGISTRER;
            case "4": return ActionType.QUITTER;
            default: throw new Exception("annulation action");
        }
    }
}