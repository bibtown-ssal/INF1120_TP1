
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
            +"et d'afficher l'information sur un produit selon son code.\n";
    public static final String MENU_PRINCIPAL = "----\nMENU\n----\n"
            +"1. Construire un code de produit\n"
            +"2. Afficher les informations sur un produit\n"
            +"3. Quitter\n"
            +"\nEntrez votre choix (1,2 ou 3) : ";
    public static final String MENU_CATEGORIE = "\nCATEGORIES :\n"
            +"    1. Ordinateurs\n"
            +"    2. Televiseurs\n"
            +"    3. Appareils photo\n"
            +"    4. Petits electros\n"
            +"\nEntrez le numero de categorie du produit : ";
    public static final String MENU_ORDINATEUR = "\nPRODUITS\n"
            +"    1. Ordinateurs de bureau\n"
            +"    2. Portable\n"        
            +"    3. Tablette\n"
            +"    4. Moniteur\n"
            +"    5. Imprimante/numeriseur\n"
            +"\nEntrez le numero du produit : ";
    public static final String MENU_TELEVISEUR = "\nPRODUITS\n"
            +"    1. Televiseur\n"
            +"    2. Projecteur\n"
            +"\nEntrez le numero du produit : ";
    public static final String MENU_PETIT_ELECTRO = "\nProduit\n"
            +"    1. Cafetiere\n"
            +"    2. Robot culinaire\n"
            +"    3. Melangeur\n"
            +"    4. Batteur\n"
            +"    5. Fritteuse/grill\n"
            +"    6. Grille-pain/four grille-pain\n"
            +"\nEntrez le numero du produit : ";
    public static final String MENU_MODELE = 
            "\nEntrez le numero du modele : ";
    public static final String AFFICHAGE_CODE_PRODUIT =
            "\nCODE DU PRODUIT : ";
    public static final String MESS_CONTINUER = 
            "\nAppuyez sur <ENTREE> pour revenir au menu...";
    public static final String MESS_SOLLI_CODE =
            "Entrez le code du produit : ";
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
    public static final String MESS_FIN = "\nFIN NORMALE DU PROGRAMME";
    public static final String MESS_ERR_CODE_INVALIDE =
            "\n*** Ce code de produit est invalide ***";
    public static final String MESS_ERR_MENU_PRINCIPAL =
            "\nErreur ! Vous devez entrer 1, 2 (ou 3 pour quitter)."
            + " Recommencez...\n";
    public static final String MESS_ERR_MENU_CATEGORIE =
            "\nErreur ! Entrez un numero entre 1 et 4. Recommencez...\n";    
    public static final String MESS_ERR_MENU_ORDINATEUR =
            "\nErreur ! Entrez un numero entre 1 et 5. Recommencez...\n";
    public static final String MESS_ERR_MENU_TELEVISEUR = 
            "\nErreur ! Entrez un numero entre 1 et 2. Recommencez...\n";
    public static final String MESS_ERR_MENU_PETIT_ELECTRO =
            "\nErreur ! Entrez un numero entre 1 et 6. Recommencez... \n";
    public static final String MESS_ERR_MODELE_INVALIDE =
            "\nErreur ! Le numero du modele est invalide. Recommencez... \n";
            
    public static void main(String [] args){
        //initialisation variables
        char choixMenuPrincipal;
        int numCategorie;
        int numProduit = 0;
        int numModele;
        int codeProduit;
        int nbChiffre;
        int diviseur;
        boolean codeValide = true;
        String descrProduit = "";
        
        System.out.print(MESS_PRESENTATION);
        do{
            System.out.print(MENU_PRINCIPAL);
            choixMenuPrincipal = Clavier.lireCharLn();
            //boucle de validation du choix d'option dans le menu principal
            while(!(choixMenuPrincipal == '1' || choixMenuPrincipal == '2' 
                    || choixMenuPrincipal == '3')){
                System.out.print(MESS_ERR_MENU_PRINCIPAL);
                System.out.print(MENU_PRINCIPAL);
                choixMenuPrincipal = Clavier.lireCharLn();
            }
            if(choixMenuPrincipal == '1'){
                System.out.print(MENU_CATEGORIE);
                numCategorie = Clavier.lireIntLn();
                //boucle de validation du choix de categorie
                while(numCategorie < 1 || numCategorie > NB_CATEGORIE){
                    System.out.print(MESS_ERR_MENU_CATEGORIE);
                    System.out.print(MENU_CATEGORIE);
                    numCategorie = Clavier.lireIntLn();
                }
                if(numCategorie == CATEGORIE_ORDINATEUR){
                    System.out.print(MENU_ORDINATEUR);
                    numProduit = Clavier.lireIntLn();
                    //boucle de validation de selection du produit
                    while(numProduit < 1 
                            || numProduit > NB_PRODUIT_ORDINATEUR){
                    System.out.print(MESS_ERR_MENU_ORDINATEUR);
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
                        System.out.print(MESS_ERR_MENU_TELEVISEUR);
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
                        System.out.print(MESS_ERR_MENU_PETIT_ELECTRO);
                        System.out.print(MENU_PETIT_ELECTRO);
                        numProduit = Clavier.lireIntLn();
                    }
                }
                System.out.print(MENU_MODELE);
                numModele = Clavier.lireIntLn();
                //boucle de validation du numero de modele
                while(numModele < NUM_MODELE_MIN 
                        || numModele > NUM_MODELE_MAX){
                    System.out.print(MESS_ERR_MODELE_INVALIDE);
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
                if(codeProduit >= NUM_CODE_MIN && codeProduit <= NUM_CODE_MAX){

                    //lecture du numCategorie (premier chiffre du nombre)
                    numCategorie = codeProduit;
                    nbChiffre = 0;
                    do{
                        numCategorie /= 10;
                        nbChiffre++;
                    }while(numCategorie > 10);

                    //retire le premier chiffre du code
                    diviseur = 1;
                    for(int i = 0; i < nbChiffre; i++){
                        diviseur *= 10;
                    }
                    codeProduit %= diviseur;

                    //validation que la Categorie est possible
                    if(numCategorie >= 1 && numCategorie <= NB_CATEGORIE){
                        //isole le numero de produit
                        numProduit = codeProduit;
                        numProduit /= (diviseur/10);
                        
                        //retire le numero de produit du code
                        codeProduit %= (diviseur/10);

                        if(numCategorie == CATEGORIE_ORDINATEUR){
                            descrProduit += CATEGORIE + "Ordinateurs"
                                    + PRODUIT;
                            switch(numProduit){ //selection du bon produit
                                case(1): descrProduit += "Ordinateur de bureau";
                                    break;
                                case(2): descrProduit += "Portable";
                                    break;
                                case(3): descrProduit += "Tablette";
                                    break;
                                case(4): descrProduit += "Moniteur";
                                    break;
                                case(5): descrProduit 
                                        += "Imprimante / numeriseur";
                                    break;
                                default: codeValide = false;
                            }
                        } else if(numCategorie == CATEGORIE_TELEVISEUR){
                            descrProduit += CATEGORIE + "Televiseurs"
                                    + PRODUIT;
                            switch(numProduit){
                                case(1): descrProduit += "Televiseur";
                                    break;
                                case(2): descrProduit += "Projecteur";
                                    break;
                                default: codeValide = false;
                            }
                        }else if(numCategorie == CATEGORIE_APPAREIL_PHOTO){
                            descrProduit += CATEGORIE + "Appareil Photos"
                                    + PRODUIT;
                            if(numProduit == 1){
                                descrProduit += "Appareil photo numerique";
                            } else {
                                codeValide = false;
                            }
                        }else if(numCategorie == CATEGORIE_PETIT_ELECTRO){
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
                                case(6): descrProduit 
                                        += "Grille-pain / four grille-pain";
                                    break;
                                default: codeValide = false;
                            }
                        }
                        //validation du numero de modele
                        if(!(codeProduit > 999 && codeProduit < 9999999)){
                            codeValide = false;
                        }
                        //affichage des informations sur le produit
                        if(codeValide){ 
                            descrProduit += MODELE + codeProduit;
                            System.out.println(descrProduit);
                            System.out.println(AFFICHAGE_CODE_PRODUIT 
                                    + numCategorie + numProduit + codeProduit);
                            System.out.print(MESS_CONTINUER);
                            Clavier.lireFinLigne();
                        }else { //code non valide (produit)
                            System.out.println(MESS_ERR_CODE_INVALIDE);
                            System.out.print(MESS_CONTINUER);
                            Clavier.lireFinLigne();
                        }
                    }else{ //code non valide (categorie)
                        System.out.println(MESS_ERR_CODE_INVALIDE);
                        System.out.print(MESS_CONTINUER);
                        Clavier.lireFinLigne();
                    }

                }else { //code non valide (code n'est pas dans le limites possibles)
                    System.out.println(MESS_ERR_CODE_INVALIDE);
                    System.out.print(MESS_CONTINUER);
                    Clavier.lireFinLigne();
                }
                //reinitialisation des variables
                descrProduit = "";
                codeValide = true;
            }
            
        }while(choixMenuPrincipal != '3');
        System.out.print(MESS_FIN);
    }
}
