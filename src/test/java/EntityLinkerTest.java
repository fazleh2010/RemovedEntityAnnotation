/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author elahi
 */
import citec.correlation.wikipedia.linking.AbstractEntityLinker;
import static citec.correlation.wikipedia.parameters.DirectoryLocation.anchors;
import citec.wikipedia.writer.utils.FileFolderUtils;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 *
 * @author elahi
 */
public class EntityLinkerTest {

    private static Map<String, TreeMap<String, List<String>>> alphabetInfo = new TreeMap<String, TreeMap<String, List<String>>>();
    private static Set<String> classFileNames = new HashSet<String>();

    public static void main(String[] args) throws IOException, Exception {
        Integer windowSize = 5, nGram = 5;
        String dbo_Class="dbo:Album";
        alphabetInfo = FileFolderUtils.getAlphabetInfo(anchors, ".txt");
        classFileNames = new HashSet<String>();
        classFileNames.add(dbo_Class);
        AbstractEntityLinker main = new AbstractEntityLinker(dbo_Class,classFileNames, windowSize, nGram, alphabetInfo);
    }
}
