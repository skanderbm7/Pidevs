/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tn.esprit.tests;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import tn.esprit.services.ColisService;
import tn.esprit.entities.Colis;
import tn.esprit.entities.Covoiturage;
import tn.esprit.entities.Mission;
import tn.esprit.entities.Participation;
import tn.esprit.services.CovoiturageService;
import tn.esprit.services.MissionService;
import tn.esprit.services.ParticipationService;
/**
 *
 * @author Pc
 */
public class Ugo {
    public static void main(String[] args) throws ParseException {
        ColisService sp = new ColisService();
       Colis c =new Colis(3,"animal",27);
       //sp.modifier(12,"az", "Zaher", "Hamdi","qsd",123,(float) 3.5,"azer");
        //sp1.supprimer(new Personne(1));
        //System.out.println(sp1.afficher());
      sp.ajouter(c);
       String strDate = "2011-12-31 00:00:00";

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        java.util.Date date = sdf.parse(strDate);
 
        java.sql.Date sqlDate = new Date(date.getTime());
        MissionService ms = new MissionService();
        Mission m =new Mission(3,sqlDate,7,3,"bardo",58784720,27);
       //sp.modifier (12,"az", "Zaher", "Hamdi","qsd",123,(float) 3.5,"azer");
        //sp1.supprimer(new Personne(1));
        //System.out.println(sp1.afficher());
      ms.ajouter(m);
      // omniaaatestttt***************
        CovoiturageService  sp1= new CovoiturageService();
        Covoiturage cv =new Covoiturage("haaa","bardo","ytfd","HHHH",3, (float) 3.1,"salut");
        System.out.println(sp1.afficher());
        //sp.modifier(12,"az", "Zaher", "Hamdi","qsd",123,(float) 3.5,"azer");
        //sp1.supprimer(new Personne(1));
        //System.out.println(sp1.afficher());
        sp1.ajouter(cv);
         ParticipationService sp2 = new ParticipationService();
        Participation participation  =new Participation(2,100,45);
        sp2.ajouter(participation);
        System.out.println(sp2.afficher());
        
        
        //sp.modifier(12,"az", "Zaher", "Hamdi","qsd",123,(float) 3.5,"azer");
        //sp1.supprimer(new Personne(1));
        //System.out.println(sp1.afficher());
        sp2.ajouter(participation);
}

    }


