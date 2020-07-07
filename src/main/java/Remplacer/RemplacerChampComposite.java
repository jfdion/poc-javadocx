package Remplacer;

import com.javadocx.CreateDocxFromTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RemplacerChampComposite {

    private List<RemplacerChamp> remplaceurs = new ArrayList<RemplacerChamp>();

    public void ajouter(RemplacerChamp remplaceur) {
        remplaceurs.add(remplaceur);
    }

    public void retirer(RemplacerChamp remplaceur) {
        remplaceurs.remove(remplaceur);
    }

    public void remplacer(CreateDocxFromTemplate docx, Map<String, Object> valeurs) {
        remplaceurs.stream().forEach(r -> r.remplacer(docx, valeurs.get(r.getCle())));
    }
}
