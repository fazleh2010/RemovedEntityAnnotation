/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citec.correlation.wikipedia.utils;

import citec.correlation.wikipedia.element.DBpediaEntityPattern;
import citec.wikipedia.writer.table.DBpediaEntity;
import citec.wikipedia.writer.utils.FileFolderUtils;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import org.apache.commons.io.filefilter.WildcardFileFilter;

/**
 *
 * @author elahi
 */
public class FileFolderUtilsAnnotation extends FileFolderUtils {

    public static void convertToJson(List<DBpediaEntityPattern> correctedEntities, String dir, String filename) throws IOException, Exception {
        if (correctedEntities.isEmpty()) {
            throw new Exception("the list is empty!!!");
        }
        filename = dir + filename;
        ObjectMapper mapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
        mapper.writeValue(Paths.get(filename + ".json").toFile(), correctedEntities);
    }

    public static Map<String, List<DBpediaEntity>> readAlphabetSplitTables(List<File> list) throws IOException, Exception {
        Map<String, List<DBpediaEntity>> fileDBpediaEntities = new TreeMap<String, List<DBpediaEntity>>();
        for (File file : list) {
            ObjectMapper mapper = new ObjectMapper();
            List<DBpediaEntity> dbpediaEntitys = mapper.readValue(file, new TypeReference<List<DBpediaEntity>>() {
            });
            fileDBpediaEntities.put(file.getName(), dbpediaEntitys);
        }
        return fileDBpediaEntities;
    }

}
