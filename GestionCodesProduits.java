
/**
 * GestionCodesProduits est une classe qui permet de construire un
 * code de produit et/ou d'afficher les informations d'un produit a 
 * partir de son code.
 *
 * @author Charles Therien
 * @codePermanent THEC03029208
 * @version 22 fev 2018
 */
public class GestionCodesProduits
{
    //initialisation constante
    public static final String MESS_PRESENTATION =
            "Ce programme permet de creer des codes de produits electroniques\n"
            +"et d'afficher l'information sur un produit selon son code.";
    public static final String MENU_PRINCIPAL = "____\nMENU\n____\n"
            +"1. Construire un code de produit\n"
            +"2. Afficher les informations sur un produit\n"
            +"3. Quitter\n"
            +"\n Entrez votre choix (1,2 ou 3) :";
    public static final String MENU_CATEGORIE = "\nCATEGORIES :\n"
            +"\t1. Ordinateurs\n"
            +"\t2. Televiseurs\n"
            +"\t3. Appareils photo\n"
            +"\t4. Petits electros\n"
            +"\nEntrez le numero de categorie du produit :";
    public static final String MENU_ORDINATEUR = "\nPRODUITS\n"
            +"\t1. Ordinateurs de bureau\n"
            +"\t2. Portable\n"        
            +"\t3. Tablette\n"
            +"\t4. Moniteur\n"
            +"\t5. Imprimante/numeriseur\n"
            +"\nEntrez le numero du produit :";
    public static final String MENU_TELEVISEUR = "\nPRODUITS\n"
            +"\t1. Televiseur\n"
            +"\t2. Projecteur\n"
            +"\nEntrez le numero du produit :";
    public static final String MENU_PETIT_ELECTRO = "\nProduit\n"
            +"\t1. Cafetiere\n"
            +"\t2. Robot culinaire\n"
            +"\t3. Melangeur\n"
            +"\t4. Batteur\n"
            +"\t5. Fritteuse/grill\n"
            +"\t6. Grille-pain/four grille-pain\n"
            +"\nEntrez le numero du produit :";
    public static final String MENU_MODELE = 
                    "\nEntrez le numero du modele :";
    public static final String AFFICHAGE_CODE =
             "\n CODE DU PRODUIT :";
    public static final String MESS_CONTINUER = 
            "\nAppuyez sur <ENTREE> pour revenir au menu...";
    public static final String MESS_SOLLI_CODE =
            "Entrez le code du produit :";
    public static final int NB_CATEGORIE = 4;
    public static final int NB_PRODUIT_ORDINATEUR = 5;
    public static final int NB_PRODUIT_TELEVISEUR = 2;
    public static final int NB_PRODUIT_PETIT_ELECTRO = 6;
    public static final int MODELE_LONGUEUR_MIN = 4;
    public static final int MODELE_LONGUEUR_MAX = 7;
    public static final String MESS_FIN = "\nFin normale du programme...";
    public static final String MESS_ERR_CODE_INVALIDE =
            "*** Ce code de produit est invalide ***";
    public static final String MESS_ERR_MENU_PRINCIPAL =
            "Erreur ! Vous devez entrer 1, 2 (ou 3 pour quitter). Recommencez...";
    public static final String MESS_ERR_MENU_CATEGORIE =
            "Erreur ! Entrez un numero entre 1 et 4. Recommencez...";    
    public static final String MESS_ERR_MENU_ORDINATEUR =
            "Erreur ! Entrez un numero entre 1 et 5. Recommencez...";
    public static final String MESS_ERR_MENU_TELEVISEUR = 
            "Erreur ! Entrez un numero entre 1 et 2. Recommencez...";
    public static final String MESS_ERR_MENU_PETIT_ELECTRO =
            "Erreur ! Entrez un numero entre 1 et 6. Recommencez...";
    public static final String MESS_ERR_MODELE_INVALIDE =
            "Erreur ! Le numero du modele est invalide. Recommencez...";
    public static void main(String [] args){
        //initialisation variables
        char choixMenuPrincipal;
        int choixCategorie;
        int choixProduit;
        int numModele;
        String codeProduit;
        
        System.out.println(MESS_PRESENTATION);
        do{
            System.out.print(MENU_PRINCIPAL);
            choixMenuPrincipal = Clavier.lireCharLn();
            while(!(choixMenuPrincipal == '1' || choixMenuPrincipal == '2' || choixMenuPrincipal == '3')){
                System.out.println(MESS_ERR_MENU_PRINCIPAL);
                System.out.print(MENU_PRINCIPAL);
                choixMenuPrincipal = Clavier.lireCharLn();
            }
            if(choixMenuPrincipal == '1'){
                System.out.print(MENU_CATEGORIE);
                choixCategorie = Clavier.lireIntLn();
                while(choixCategorie < 1 || choixCategorie > 4){
                    System.out.print(MESS_ERR_MENU_CATEGORIE);
                }
            }
        }while(choixMenuPrincipal != '3');
    }
}
