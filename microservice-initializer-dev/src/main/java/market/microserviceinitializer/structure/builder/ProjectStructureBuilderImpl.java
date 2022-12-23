package market.microserviceinitializer.structure.builder;

import market.microserviceinitializer.structure.util.ApplicationStarterFileGenerator;
import market.microserviceinitializer.structure.util.PropertiesFileGenerator;
import market.microserviceinitializer.structure.util.ProjectStructureInitializer;
import org.springframework.stereotype.Service;

@Service
public class ProjectStructureBuilderImpl implements ProjectStructureBuilder {

    private final PropertiesFileGenerator propertiesFileGenerator;
    private final ProjectStructureInitializer projectStructureInitializer;
    private final ApplicationStarterFileGenerator applicationStarterFileGenerator;

    public ProjectStructureBuilderImpl(PropertiesFileGenerator propertiesFileGenerator, ProjectStructureInitializer projectStructureInitializer, ApplicationStarterFileGenerator applicationStarterFileGenerator) {
        this.propertiesFileGenerator = propertiesFileGenerator;
        this.projectStructureInitializer = projectStructureInitializer;
        this.applicationStarterFileGenerator = applicationStarterFileGenerator;
    }

    public void build(String projectName){
        projectStructureInitializer.createBaseFolderStructure(projectName);
        propertiesFileGenerator.placeBaseFiles(projectName);
        applicationStarterFileGenerator.build(projectName);

    }
}
