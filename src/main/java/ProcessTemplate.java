import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.javadocx.CreateDocxFromTemplate;

import Remplacer.RemplacerChampComposite;
import Remplacer.RemplacerChampImage;
import Remplacer.RemplacerChampLink;
import Remplacer.RemplacerChampString;

public class ProcessTemplate {

        public static void main(String[] args) {
            CreateDocxFromTemplate docx = new CreateDocxFromTemplate("src/main/resources/template.docx");

            HashMap<String, ArrayList<String>> variables = docx.getTemplateVariables();
            System.out.println(variables);

            RemplacerChampComposite batchReplace = new RemplacerChampComposite();

            batchReplace.ajouter(new RemplacerChampString("participant_nom"));
            batchReplace.ajouter(new RemplacerChampString("formation_titre"));
            batchReplace.ajouter(new RemplacerChampLink("attestion_url_verification"));
            batchReplace.ajouter(new RemplacerChampImage("formation_formateur_signature"));
            batchReplace.ajouter(new RemplacerChampString("attestation_emission_date"));

            Map<String, String> lienVerificationOptions = new HashMap<>();
            lienVerificationOptions.put("color", "hotpink");
            lienVerificationOptions.put("underline", "none");

            Map<String, Object> valeurs = new HashMap<>();
            valeurs.put("participant_nom", "John Smith");
            valeurs.put("formation_titre", "Titre de la formation super cool que John à suivi!");
            valeurs.put("attestion_url_verification", LinkFragmentFactory.createLinkFragment(docx, "Vérifiez ce certificat!", "http://www.google.ca", lienVerificationOptions));
            valeurs.put("formation_formateur_signature", "src/main/resources/John_Hancock_Envelope_Signature.jpg");
            valeurs.put("attestation_emission_date", "le 7 juillet 2020");

            batchReplace.remplacer(docx, valeurs);

            docx.processTemplate(variables);

            docx.createDocx("example_processTemplate_1");

            // Requiert Libre Office sur le serveur pour fonctionner
            // https://www.javadocx.com/api-documentation/format-conversion/convert-Word-docx-into-pdf-with-java
            // TransformDocumentLibreOffice transform = new TransformDocumentLibreOffice();
            // transform.transformDocument("document.docx", "document.pdf");

        }
}
