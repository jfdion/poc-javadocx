package Remplacer;

import com.javadocx.CreateDocxFromTemplate;

public class RemplacerChampImage extends RemplacerChampBase<String> {

    public RemplacerChampImage(String cle) {
        super(cle);
    }

    @Override
    public void remplacer(CreateDocxFromTemplate docx, String imagePath) {
        docx.replacePlaceholderImage(this.getCle(), imagePath);
    }
}
