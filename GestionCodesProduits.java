
/**
 * GestionCodesProduits est une classe qui permet de construire un
 * code de produit et/ou d'afficher les informations d'un produit a 
 * partir de son code.
 *
 * @author Charles Therien
 * Code Permanent THEC03029208
 * Courriel : therien.charles@courrier.uqam.ca
 * Cours : INF1120-30
 * @version 22 fev 2018
 */
public class GestionCodesProduits
{
    //initialisation constante
    public static final String MESS_PRESENTATION =
            "Ce programme permet de creer des codes de produits"
            +" electroniques\n"
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
    public static final String AFFICHAGE_CODE_PRODUIT =
             "\n CODE DU PRODUIT : ";
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
    public static final int CATEGORIE_ORDINATEUR = 1;
    public static final int CATEGORIE_TELEVISEUR= 2;
    public static final int CATEGORIE_APPAREIL_PHOTO = 3;
    public static final int CATEGORIE_PETIT_ELECTRO = 4;
    public static final int NUM_MODELE_MIN = 1000;
    public static final int NUM_MODELE_MAX = 9999999;
    public static final int NUM_CODE_MAX = 469999999;
    public static final int NUM_CODE_MIN = 111000;
    
    public static final String CATEGORIE = "\nCATEGORIE : ";
    public static final String PRODUIT =   "\nPRODUIT   : ";
    public static final String MODELE =    "\nMODELE    : ";
    public static final String MESS_FIN = "\nFin normale du programme...";
    public static final String MESS_ERR_CODE_INVALIDE =
            "*** Ce code de produit est invalide ***";
    public static final String MESS_ERR_MENU_PRINCIPAL =
            "Erreur ! Vous devez entrer 1, 2 (ou 3 pour quitter)."
            + " Recommencez...";
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
        int numCategorie;
        int numProduit = 0;
        int numModele;
        int codeProduit;
        int nbChiffre;
        boolean codeValide = true;
        
        String descrProduit = "";
        System.out.println(MESS_PRESENTATION);
        do{
            System.out.print(MENU_PRINCIPAL);
            choixMenuPrincipal = Clavier.lireCharLn();
            //boucle de validation du choix d'option dans le menu principal
            while(!(choixMenuPrincipal == '1' || choixMenuPrincipal == '2' 
                    || choixMenuPrincipal == '3')){
                System.out.println(MESS_ERR_MENU_PRINCIPAL);
                System.out.print(MENU_PRINCIPAL);
                choixMenuPrincipal = Clavier.lireCharLn();
            }
            if(choixMenuPrincipal == '1'){
                System.out.print(MENU_CATEGORIE);
                numCategorie = Clavier.lireIntLn();
                //boucle de validation du choix de categorie
                while(numCategorie < 1 || numCategorie > NB_CATEGORIE){
                    System.out.println(MESS_ERR_MENU_CATEGORIE);
                    System.out.print(MENU_CATEGORIE);
                    numCategorie = Clavier.lireIntLn();
                }
                if(numCategorie == CATEGORIE_ORDINATEUR){
                    System.out.print(MENU_ORDINATEUR);
                    numProduit = Clavier.lireIntLn();
                    //boucle de validation de selection du produit
                    while(numProduit < 1 
                            || numProduit > NB_PRODUIT_ORDINATEUR){
                    System.out.println(MESS_ERR_MENU_ORDINATEUR);
                    System.out.print(MENU_ORDINATEUR);
                    numProduit = Clavier.lireIntLn();
                    }
                }
                if(numCategorie == CATEGORIE_TELEVISEUR){
                    System.out.print(MENU_TELEVISEUR);
                    numProduit = Clavier.lireIntLn();
                    //boucle de validation de selection du produit
                    while(numProduit < 1 
                            || numProduit > NB_PRODUIT_TELEVISEUR){
                        System.out.println(MESS_ERR_MENU_TELEVISEUR);
                        System.out.print(MENU_TELEVISEUR);
                        numProduit = Clavier.lireIntLn();
                    }
                }
                if(numCategorie == CATEGORIE_APPAREIL_PHOTO){
                    //categorie n'ayant qu'une possibilite de produit
                    numProduit = 1;
                }
                if(numCategorie == CATEGORIE_PETIT_ELECTRO){
                    System.out.print(MENU_PETIT_ELECTRO);
                    numProduit = Clavier.lireIntLn();
                    //boucle de validation de selection du produit
                    while(numProduit < 1 
                            || numProduit > NB_PRODUIT_PETIT_ELECTRO){
                        System.out.println(MESS_ERR_MENU_PETIT_ELECTRO);
                        System.out.print(MENU_PETIT_ELECTRO);
                        numProduit = Clavier.lireIntLn();
                    }
                }
                System.out.print(MENU_MODELE);
                numModele = Clavier.lireIntLn();
                //boucle de validation du numero de modele
                while(numModele < NUM_MODELE_MIN 
                        || numModele > NUM_MODELE_MAX){
                    System.out.println(MESS_ERR_MODELE_INVALIDE);
                    System.out.print(MENU_MODELE);
                    numModele = Clavier.lireIntLn();
                } 
                //la composition du code de produit se fait lors de l'affichage
                System.out.println(AFFICHAGE_CODE_PRODUIT + numCategorie 
                        + numProduit + numModele);
                System.out.print(MESS_CONTINUER);
                Clavier.lireFinLigne();
            } else if (choixMenuPrincipal == '2'){
                System.out.print(MESS_SOLLI_CODE);
                codeProduit = Clavier.lireIntLn();
                //1: on verifie que le code est de longueur acceptee
                if(codeProduit >= NUM_CODE_MIN || codeProduit <= NUM_CODE_MAX){
                     /*Calcul le premier chiffre:
                     *  trouvle le log_10 du code, le tranforme en int
                     *      ce int est le nombre de chiffre -1
                     *  on divise le code par 10 exposant le ce int
                     *  cela retire tous les chiffre après le premier
                     */
                    nbChiffre = (int)Math.log10(codeProduit);
                    numCategorie  = codeProduit/(int)(Math.pow(10,nbChiffre));
                    //validation que la Categorie est possible
                    if(numCategorie < 1 || numCategorie > NB_CATEGORIE){
                        //retire le numero de categorie du code
                        codeProduit = codeProduit % (int)Math.pow(10,nbChiffre);
                        //isole le numero de produit
                        numProduit = codeProduit/(int)(Math.pow(10,nbChiffre-1));
                        //retire le numero de produit du code
                        codeProduit = codeProduit % (int)Math.pow(10,nbChiffre-1);
                        if(numCategorie == CATEGORIE_ORDINATEUR){
                            descrProduit += CATEGORIE + "Ordinateurs"
                                    + PRODUIT;
                            
                            switch(numProduit){
                                case(1): descrProduit += "Ordinateur de bureau";
                                    break;
                                case(2): descrProduit += "Portable";
                                    break;
                                case(3): descrProduit += "Tablette";
                                    break;
                                case(4): descrProduit += "Moniteur";
                                    break;
                                case(5): descrProduit += "Imprimante / numeriseur";
                                    break;
                                default: codeValide = false;
                            }
                        }
                        if(numCategorie == CATEGORIE_TELEVISEUR){
                            descrProduit += CATEGORIE + "Televiseurs"
                                    + PRODUIT;
                            switch(numProduit){
                                case(1): descrProduit += "Televiseur de bureau";
                                    break;
                                case(2): descrProduit += "Projecteur";
                                    break;
                                default: codeValide = false;
                            }
                        }
                        if(numCategorie == CATEGORIE_APPAREIL_PHOTO){
                            descrProduit += CATEGORIE + "Appareil Photos"
                                    + PRODUIT;
                            if(numProduit == 1){
                                descrProduit += "Appareil photo numerique";
                            } else {
                                codeValide = false;
                            }
                        }
                        if(numCategorie == CATEGORIE_PETIT_ELECTRO){
                            descrProduit += CATEGORIE + "Petit Electros"
                                    + PRODUIT;
                            switch(numProduit){
                                case(1): descrProduit += "Cafetiere";
                                    break;
                                case(2): descrProduit += "Robot culinaire";
                                    break;
                                case(3): descrProduit += "Melangeur";
                                    break;
                                case(4): descrProduit += "Batteur";
                                    break;
                                case(5): descrProduit += "Firteuse / grill";
                                    break;
                                case(6): descrProduit += "Grille-pain / four grille-pain";
                                    break;
                                default: codeValide = false;
                            }
                        }
                        if(codeValide){
                            descrProduit += MODELE + codeProduit;
                            System.out.println(descrProduit);
                            System.out.println(AFFICHAGE_CODE_PRODUIT + numCategorie 
                        + numProduit + codeProduit);
                        }else {
                            System.out.println(MESS_ERR_CODE_INVALIDE + 1);
                            System.out.print(MESS_CONTINUER);
                            Clavier.lireFinLigne();
                        }
                    }else{
                        System.out.println(MESS_ERR_CODE_INVALIDE + 2);
                        System.out.print(MESS_CONTINUER);
                        Clavier.lireFinLigne();
                    }

                }else {
                    System.out.println(MESS_ERR_CODE_INVALIDE + 3);
                    System.out.print(MESS_CONTINUER);
                    Clavier.lireFinLigne();
                }
                
                
            }
            
        }while(choixMenuPrincipal != '3');
    }
}
