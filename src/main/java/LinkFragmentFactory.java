import com.javadocx.CreateDocxFromTemplate;
import com.javadocx.WordFragment;
import com.javadocx.elements.OptionsLink;

import java.util.Map;

public class LinkFragmentFactory {

    public static WordFragment createLinkFragment(CreateDocxFromTemplate docx, String libelle, String url, Map<String, String> options) {
        WordFragment linkFragment = new WordFragment(docx);
        OptionsLink linkOptions = new OptionsLink();
        linkOptions.setUrl(url)
                .setColor(getColor(options))
                .setUnderline(getUnderline(options));

        linkFragment.addLink(libelle, linkOptions);
        return linkFragment;
    }

    private static String getColor(Map<String, String> options){
        if(options == null || !options.containsKey("color")) {
            return "0000FF";
        }
        return options.get("color");
    }

    private static String getUnderline(Map<String, String> options){
        if(options == null || !options.containsKey("underline")) {
            return "single";
        }
        return options.get("underline");
    }
}
